package exceptions;

public class InvalidFileFormat extends Exception {
	public InvalidFileFormat(int line) {
		super("invalid file format: line " + line + ".");
	}
}
