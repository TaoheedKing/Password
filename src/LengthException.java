/*
 * Nimesh Fernando
 * CMSC 204 - Assignment Passwords
 */
public class LengthException extends Exception{
	
	public LengthException() {
		
	}
	public LengthException(String password) {
		
		super(password);
	}
	
	
}
