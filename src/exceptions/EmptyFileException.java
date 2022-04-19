package exceptions;

public class EmptyFileException extends Exception {
	public EmptyFileException() {
		super("Error: Empty file error.");
	}
}
