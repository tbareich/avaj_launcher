
public class Simulator {
	public static void main(String[] args) {
		try {
			long simulationLength = 25;
			WeatherTower weatherTower = new WeatherTower();
			Flyable baloon = AircraftFactory.newAircraft("Baloon",
					"B1", 100, 150, 50);
			Flyable jetPlane = AircraftFactory.newAircraft("JetPlane",
					"J1", 90, 2, 15);
			Flyable helicopter = AircraftFactory.newAircraft("Helicopter",
					"H1", 55, 10, 25);
			baloon.registerTower(weatherTower);
			jetPlane.registerTower(weatherTower);
			helicopter.registerTower(weatherTower);
			while (simulationLength > 0) {
				weatherTower.changeWeather();
				--simulationLength;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
