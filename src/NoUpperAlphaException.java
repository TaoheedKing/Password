/*
 * Nimesh Fernando
 * CMSC 204 - Assignment Passwords
 */
public class NoUpperAlphaException extends Exception{

	public NoUpperAlphaException() {
		
	}
	
	public NoUpperAlphaException(String password) {
		super(password);
	}
}
