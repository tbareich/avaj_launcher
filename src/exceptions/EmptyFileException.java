package exceptions;

public class EmptyFileException extends Exception {
	public EmptyFileException() {
		super("empty file error.");
	}
}
