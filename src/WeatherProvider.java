
public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String[] weather = { "SNOW", "RAIN", "FOG", "SUN" };

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return weatherProvider == null ? new WeatherProvider()
				: weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		double degree;
		double rangePosition;

		rangePosition = Math.sqrt(Math.pow(coordinates.getLatitude(), 2)
				+ Math.pow(coordinates.getLongitude(), 2)) % (45 * 2);
		if (rangePosition > 45)
			degree = 45 - (rangePosition % 45);
		else
			degree = rangePosition;
		degree -= coordinates.getHeight() / 5;
		if (degree <= 0)
			return weather[0];
		else if (degree <= 18)
			return weather[1];
		else if (degree <= 22)
			return weather[2];
		return weather[3];
	}
}
