
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

		if (currentWeather == "SUN") {
			longitude += 2;
			height += 4;
		}
		if (currentWeather == "RAIN")
			height -= 5;
		if (currentWeather == "FOG")
			height -= 3;
		if (currentWeather == "SNOW")
			height -= 15;
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
