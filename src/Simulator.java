import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.EmptyFileException;
import exceptions.InvalidFileFormat;

public class Simulator {
	public static void main(String[] args) {
		try {
			WeatherTower weatherTower = new WeatherTower();
			if (args.length != 1) {
				System.out.println("Error: Wrong length of arguments.");
				return;
			}
			int simulationLength = parseFile(args[0], weatherTower);
			while (--simulationLength >= 0)
				weatherTower.changeWeather();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static int parseFile(String path, WeatherTower weatherTower)
			throws EmptyFileException, InvalidFileFormat,
			FileNotFoundException {
		File file = new File(path);
		int lineIndex;
		String line;
		String[] lineSplit;
		int iterations;
		boolean match;
		ArrayList<Flyable> flyables = new ArrayList<Flyable>();
		int height;

		try {
			Scanner scanner = new Scanner(file);
			iterations = 0;
			if (scanner.hasNextLine() == false) {
				scanner.close();
				throw new EmptyFileException();
			}
			lineIndex = 1;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (lineIndex == 1) {
					if (line.isEmpty()) {
						scanner.close();
						throw new InvalidFileFormat(lineIndex);
					}
					iterations = Integer.parseInt(line);
					++lineIndex;
					continue;
				}
				match = line.matches(
						"^(Baloon|JetPlane|Helicopter)+ " +
								"[A-z0-9]+ \\d+ \\d+ \\d+$");
				if (match == false) {
					scanner.close();
					throw new InvalidFileFormat(lineIndex);
				}
				lineSplit = line.split(" ");
				height = Integer.parseInt(lineSplit[4]);
				flyables.add(AircraftFactory.newAircraft(lineSplit[0],
						lineSplit[1], Integer.parseInt(lineSplit[2]),
						Integer.parseInt(lineSplit[3]),
						height > 100 ? 100 : height < 0 ? 0 : height));
				++lineIndex;
			}
			scanner.close();
			for (Flyable flyable : flyables) {
				flyable.registerTower(weatherTower);
			}
			return iterations;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (NumberFormatException e) {
			throw e;
		}
	}
}
