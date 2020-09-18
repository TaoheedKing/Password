/*
 * Nimesh Fernando
 * CMSC 204 - Assignment Passwords
 */
public class NoLowerAlphaException extends Exception{
	
	public NoLowerAlphaException() {
		
	}
	
	public NoLowerAlphaException(String password) {
		super(password);
	}

}
