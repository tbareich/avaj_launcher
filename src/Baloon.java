
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

		if (height > 0) {
			if (currentWeather == "SUN") {
				longitude += 2;
				height += 4;
				System.out.println("Baloon#" + this.name + "(" + this.id + "): "
						+ "Chamson sata3at wa ljawo jamilon hada lyawm!");
			} else if (currentWeather == "RAIN") {
				height -= 5;
				System.out.println("Baloon#" + this.name + "(" + this.id + "): "
						+ "3ta9 3ta9, hadchi kayt9atar.");
			} else if (currentWeather == "FOG") {
				height -= 3;
				System.out.println("Baloon#" + this.name + "(" + this.id + "): "
						+ "Ach had dbaba, fin 7na daba?");
			} else if (currentWeather == "SNOW") {
				height -= 15;
				System.out.println("Baloon#" + this.name + "(" + this.id + "): "
						+ "Jib dik lmanta wch3alina chi film ntfarjo.");
			}
			if (height > 100)
				height = 100;
		} else {
			System.out.println("Baloon#" + this.name + "(" + this.id + "): "
					+ "Anhabto ghir bchwiya, lazrba 3la sla7.");
			this.weatherTower.unregister(this);
			this.weatherTower = null;
			return;
		}
		this.coordinates = new Coordinates(longitude, latitude, height);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
