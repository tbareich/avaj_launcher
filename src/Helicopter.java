
public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	protected Helicopter(String name, Coordinates coordinates) {
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
			longitude += 10;
			height += 2;
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
					+ "Jahanma ka7la hadi, 7al charjam ytrachna lbard!");
		}
		if (currentWeather == "RAIN") {
			longitude += 5;
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
					+ "Wa chtiwa hadi, khit mn sma, khassha ghir chi 9hiwa.");
		}
		if (currentWeather == "FOG") {
			longitude -= 1;
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
					+ "Chof wach ybanlk chi 7aja, rah ana ma9ache3 walo");
		}
		if (currentWeather == "SNOW") {
			height -= 12;
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
					+ "Sad dak charjam wjib lmanta!");
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
