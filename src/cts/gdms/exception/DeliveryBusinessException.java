package cts.gdms.exception;

import org.apache.log4j.Logger;

public class DeliveryBusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG=Logger.getLogger(DeliveryBusinessException.class);

	public DeliveryBusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryBusinessException(final String message, final Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DeliveryBusinessException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DeliveryBusinessException(final Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}