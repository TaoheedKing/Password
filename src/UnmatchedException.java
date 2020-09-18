/*
 * Nimesh Fernando
 * CMSC 204 - Assignment Passwords
 */
public class UnmatchedException extends Exception{
	
	public UnmatchedException() {
		
	}
	public UnmatchedException(String password) {
		
		super(password);
	}
	
	
}
