package br.com.futils.exceptions;

public class FUtilsException extends Exception {

	private static final long serialVersionUID = 5237174706727952889L;

	public FUtilsException() {
		super();
	}

	public FUtilsException(final String message) {
		super(message);
	}

	public FUtilsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public FUtilsException(final Throwable cause) {
		super(cause);
	}

}
