
import java.util.ArrayList;

import java.util.regex.*;

public final class PasswordCheckerUtility {

	public static boolean isValidPassword(String password) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {
		boolean valid = true;
			// check password length
			if (isValidLength(password)!=true) {
				valid=false;
				throw new LengthException("The password must be at least 6 characters long");
			} else if (hasDigit(password)!= true) {
				valid=false;
				throw new NoDigitException("The password must contain at least one digit");
			} else if (hasUpperAlpha(password)!=true) {
				valid = false;
				throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
			} else if (hasLowerAlpha(password)!=true) {
				valid = false;
				throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
			} else if (hasSpecialChar(password)!=true) {
				valid = false;
				throw new NoSpecialCharacterException("The password must contain at least one special character");
			} else if (hasSameCharInSequence(password)!=true) {
				valid = false;
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
			} 
			return valid;
	}
			
//			

	public static boolean isWeakPassword(java.lang.String password)
            throws WeakPasswordException {
		try {
			if ((isValidPassword(password)) && (password.length() > 5 && password.length() < 10)) {
				throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
			}
		} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
				| InvalidSequenceException | NoSpecialCharacterException | WeakPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
}

//	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(
//			java.util.ArrayList<java.lang.String> passwords) {
//
//		//ArrayList<String> validPasswords = new ArrayList<>();
//		ArrayList<String> invalidPasswords = new ArrayList<>();
//
//		for (int i = 0; i < passwords.size(); i++) {
//			try {
//				isValidPassword(passwords.get(i)); {
//					//validPasswords.add(passwords.get(i));
//				}
//			} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
//					| InvalidSequenceException e) {
//				// TODO Auto-generated catch block
//				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
//				e.printStackTrace();
//			}
//		}
//		return invalidPasswords;
//	}

//	public static boolean checkPasswordLength(String password) throws LengthException {
//		if (password.length() >= 6) {
//			return true;
//		} else {
//			throw new LengthException("The password must be at least 6 characters long");
//		}
//	}

	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		if (password.equals(passwordConfirm)) {
			return true;
		}
		return false;
	}

	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm)
			throws UnmatchedException {
		if (!(password.equals(passwordConfirm))) {
			throw new UnmatchedException("Passwords do not match");
		}
	}
	
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(
			java.util.ArrayList<java.lang.String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
			for (int i = 0; i < passwords.size(); i++) {
			try {
				if (isValidPassword(passwords.get(i))== false){
					invalidPasswords.add(passwords.get(i));
				}
			} catch (LengthException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoDigitException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoUpperAlphaException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoLowerAlphaException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoSpecialCharacterException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (InvalidSequenceException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
		}
		return invalidPasswords;
	}

	public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
		if ((password.length() > 5) && (password.length() < 10)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasDigit(java.lang.String password)
            throws NoDigitException{
		int digitCounter = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((int) password.charAt(i) >= 48 && (int) password.charAt(i) <= 57) {
				digitCounter++;
			}
		}
		if (digitCounter > 0) {
			return true;
		} else {
			throw new NoDigitException("The password must contain at least one digit");
		}
	}
	
	public static boolean hasLowerAlpha(java.lang.String password)
            throws NoLowerAlphaException{
		int lowerAlphacounter = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((int) password.charAt(i) >= 97 && (int) password.charAt(i) <= 122) {
				lowerAlphacounter++;
			}
		}
		if (lowerAlphacounter > 0) {
			return true;
		} else {
			throw new NoLowerAlphaException(
					"The password must contain at least one lower case alphabetic character");
		}
	}
	
	public static boolean hasSameCharInSequence(java.lang.String password)
            throws InvalidSequenceException{
		for (int i = 0; i < password.length(); i++) {
			if (i < password.length() - 2) {
				if (password.charAt(i) == password.charAt(i + 1)
						&& password.charAt(i + 1) == password.charAt(i + 2)) {
					throw new InvalidSequenceException(
							"The password cannot contain more than two of the same character in sequence");

				}
			}
		}
		return true;
	}
	
	public static boolean hasSpecialChar(java.lang.String password)
            throws NoSpecialCharacterException{
		String pattern = "(\\W)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(password);
		if (!(m.find())) {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		return true;
	}
	
	public static boolean hasUpperAlpha(java.lang.String password)
            throws NoUpperAlphaException{
		int upperAlphacounter = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((int) password.charAt(i) >= 65 && (int) password.charAt(i) <= 90) {
				upperAlphacounter++;
			}
		}
		if (upperAlphacounter > 0) {
			return true;
		} else {
			throw new NoUpperAlphaException(
					"The password must contain at least one uppercase alphabetic character");
		}
	}
	
	public static boolean isValidLength(java.lang.String password)
            throws LengthException {
		if (password.length() >= 6) {
			return true;
		} else {
			throw new LengthException("The password must be at least 6 characters long");
		}
	}
	
	
}
/*

			


	
	

*/