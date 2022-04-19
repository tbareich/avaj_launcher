
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

		if (height > 0) {
			if (currentWeather == "SUN") {
				latitude += 10;
				height += 2;
				System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
						+ "Wach texas hadi, la tayra yatir wala 7imaran yassir.");
			} else if (currentWeather == "RAIN") {
				latitude += 5;
				System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
						+ "Khdam essuie-glace.");
			} else if (currentWeather == "FOG") {
				latitude -= 1;
				System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
						+ "Chkon 3mar l RGB kamla, rah makaybanli walo.");
			} else if (currentWeather == "SNOW") {
				height -= 7;
				System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
						+ "Ara chi zlafa dial lbissara, hiya li gha tsla7 m3a had lbard.");
			}
			if (height > 100)
				height = 100;
		} else {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): "
					+ "Al7afid lah, 3faat khlina nhabto fissa3.");
			this.weatherTower.unregister(this);
			this.weatherTower = null;
			return;
		}
		this.coordinates = new Coordinates(longitude, latitude, height);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
