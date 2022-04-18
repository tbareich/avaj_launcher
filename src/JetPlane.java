
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

		if (currentWeather == "SUN") {
			latitude += 10;
			height += 2;
		}
		if (currentWeather == "RAIN")
			latitude += 5;
		if (currentWeather == "FOG")
			latitude -= 1;
		if (currentWeather == "SNOW")
			height -= 7;
		if (height > 100)
			height = 100;
		else if (height < 0) {
			this.weatherTower.unregister(this);
			this.weatherTower = null;
			return;
		}
		this.coordinates = new Coordinates(
				longitude, latitude, height);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
