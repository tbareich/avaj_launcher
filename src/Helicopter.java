
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

		if (height > 0) {
			if (currentWeather == "SUN") {
				longitude += 10;
				height += 2;
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
						+ "Had ljaw ghir dial chi tab7ira f saidia.");
			} else if (currentWeather == "RAIN") {
				longitude += 5;
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
						+ "Wa chtiwa hadi.");
			} else if (currentWeather == "FOG") {
				longitude -= 1;
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
						+ "Fin lmatar rah makayban liya walo.");
			} else if (currentWeather == "SNOW") {
				height -= 12;
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
						+ "Ach had lbard, rassi znad 3liya!");
			}
			if (height > 100)
				height = 100;
		} else {
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): "
					+ "Khwiw tri9, Rah jaw li kayklo lcouscous blfarchita.");
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
