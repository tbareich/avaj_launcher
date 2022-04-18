
public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	protected JetPlane(String name, Coordinates coordinates) {
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
			this.weatherTower.unregister(this);
			this.weatherTower = null;
			return;
		}
		if (currentWeather == "SUN") {
			latitude += 10;
			height += 2;
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
					+ "Fhad sahd la tayra yatir wala 7maran yassir.");
		}
		if (currentWeather == "RAIN") {
			latitude += 5;
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
					+ "Khdam essuie-glace nchofo sma 9damna.");
		}
		if (currentWeather == "FOG") {
			latitude -= 1;
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
					+ "Khdam do dial dbaba la dkhol fina chi tayara.");
		}
		if (currentWeather == "SNOW") {
			height -= 7;
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
					+ "Ara chi zlafa dial lbissara nsakhno biha rassna.");
		}
		if (height > 100)
			height = 100;
		this.coordinates = new Coordinates(
				longitude, latitude, height);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
