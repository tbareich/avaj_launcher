package exceptions;

public class EmptyFileException extends Exception {
	public EmptyFileException() {
		super("Empty file error.");
	}
}
