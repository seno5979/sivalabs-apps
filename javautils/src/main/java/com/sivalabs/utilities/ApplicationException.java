/**
 * 
 */
package com.sivalabs.utilities;

/**
 * @author siva
 *
 */
public class ApplicationException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}
	
}
