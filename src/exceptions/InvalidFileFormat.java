package exceptions;

public class InvalidFileFormat extends Exception {
	public InvalidFileFormat(int line) {
		super("Invalid file format: line " + line + ".");
	}
}
