package exceptions;

public class InvalidFileFormat extends Exception {
	public InvalidFileFormat(int line) {
		super("Error: Invalid file format: line " + line + ".");
	}
}
