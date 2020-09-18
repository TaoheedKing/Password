/*
 * Nimesh Fernando
 * CMSC 204 - Assignment Passwords
 */
public class NoDigitException extends Exception {

	public NoDigitException() {
		
	}
	
	public NoDigitException(String password) {
		
		super(password);
	}
	
}
