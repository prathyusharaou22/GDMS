package cts.gdms.exception;

public class CustomerBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerBusinessException(final String message,final Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerBusinessException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerBusinessException(final Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

