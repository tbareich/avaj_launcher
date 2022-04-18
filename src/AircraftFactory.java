
import exceptions.InvalidAircraftTypeException;
import exceptions.InvalidCoordinatesException;

public abstract class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude,
			int latitude, int height)
			throws InvalidAircraftTypeException, InvalidCoordinatesException {
		if (type.equals("Baloon"))
			return new Baloon(name, new Coordinates(longitude, latitude,
					height));
		else if (type.equals("JetPlane"))
			return new JetPlane(name, new Coordinates(longitude, latitude,
					height));
		else if (type.equals("Helicopter"))
			return new Helicopter(name, new Coordinates(longitude, latitude,
					height));
		if (longitude < 0 || latitude < 0)
			throw new InvalidCoordinatesException();
		throw new InvalidAircraftTypeException(
				"Unkonwn aircraft type: " + type);
	}
}
