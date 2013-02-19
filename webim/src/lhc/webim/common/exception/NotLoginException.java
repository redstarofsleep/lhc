package lhc.webim.common.exception;

public class NotLoginException extends Exception {
	
	private static final long serialVersionUID = -6823149526961295677L;

	public NotLoginException() {
		super("User Not Login");
	}
}
