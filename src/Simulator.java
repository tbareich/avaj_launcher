import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exceptions.EmptyFileException;
import exceptions.InvalidAircraftTypeException;
import exceptions.InvalidCoordinatesException;
import exceptions.InvalidFileFormat;

public class Simulator {
	public static void main(String[] args) {
		try {
			WeatherTower weatherTower = new WeatherTower();
			int simulationLength = parseFile(args[0], weatherTower);
			while (--simulationLength >= 0)
				weatherTower.changeWeather();
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static int parseFile(String path, WeatherTower weatherTower)
			throws EmptyFileException, InvalidFileFormat,
			FileNotFoundException, InvalidAircraftTypeException,
			InvalidCoordinatesException {
		File file = new File(path);
		int lineIndex;
		String line;
		String[] lineSplit;
		int iterations;
		boolean match;
		Flyable flyable;
		int height;

		try {
			Scanner scanner = new Scanner(file);
			iterations = 0;
			if (scanner.hasNextLine() == false) {
				scanner.close();
				throw new EmptyFileException();
			}
			lineIndex = 0;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (lineIndex == 0) {
					if (line.isEmpty()) {
						scanner.close();
						throw new InvalidFileFormat();
					}
					iterations = Integer.parseInt(line);
					++lineIndex;
					continue;
				}
				match = line.matches("^[A-z]+ [A-z0-9]+ \\d+ \\d+ \\d+$");
				if (match == false) {
					scanner.close();
					throw new InvalidFileFormat();
				}
				lineSplit = line.split(" ");
				height = Integer.parseInt(lineSplit[4]);
				flyable = AircraftFactory.newAircraft(lineSplit[0],
						lineSplit[1], Integer.parseInt(lineSplit[2]),
						Integer.parseInt(lineSplit[3]),
						height > 100 ? 100 : height < 0 ? 0 : height);
				flyable.registerTower(weatherTower);
			}
			scanner.close();
			return iterations;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (NumberFormatException e) {
			throw e;
		}
	}
}
