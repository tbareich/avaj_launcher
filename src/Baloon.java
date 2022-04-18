
public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		WeatherProvider provider = WeatherProvider.getProvider();
		String currentWeather = provider.getCurrentWeather(coordinates);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if (height < 0) {
			System.out.println("Baloon#" + this.name + "(" + this.id + "): "
					+ "Rahna habtin.");
			this.weatherTower.unregister(this);
			this.weatherTower = null;
			return;
		}
		if (currentWeather == "SUN") {
			longitude += 2;
			height += 4;
			System.out.println("Baloon#" + this.name + "(" + this.id + "): "
					+ "Ahya nari 3ndak ytartagu bina hadchi!");
		}
		if (currentWeather == "RAIN") {
			height -= 5;
			System.out.println("Baloon#" + this.name + "(" + this.id + "): "
					+ "Tla3 lfo9 3amro stola wkhwiwhom, rah dakchi kayt9atar.");
		}
		if (currentWeather == "FOG") {
			height -= 3;
			System.out.println("Baloon#" + this.name + "(" + this.id + "): "
					+ "Ach had dbaba, fin 7na daba?");
		}
		if (currentWeather == "SNOW") {
			height -= 15;
			System.out.println("Baloon#" + this.name + "(" + this.id + "): "
					+ "Jib dik lmanta w ch3alina chi film ntfarjo.");
		}
		if (height > 100)
			height = 100;
		this.coordinates = new Coordinates(
				longitude, latitude, height);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}

}
