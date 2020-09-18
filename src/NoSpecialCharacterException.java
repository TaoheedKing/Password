        
/*
 * Nimesh Fernando
 * CMSC 204 - Assignment Passwords
 */


public class NoSpecialCharacterException extends Exception{

	public NoSpecialCharacterException() {
		
	}
	
	public NoSpecialCharacterException(String password) {
		
		super(password);
	}
}

    