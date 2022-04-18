package exceptions;

public class InvalidCoordinatesException extends Exception {
	public InvalidCoordinatesException() {
		super("Invalid aircraft coordinates.");
	}
}
