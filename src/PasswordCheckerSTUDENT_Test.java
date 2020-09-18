import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"553DD377", "He11ooOu", "michael2AAA", "4head", "martha22", "4wardMarch",
				"30august", "Grapesxx", "bbllc", "pivotProyect", "myProtecto",
				"myPassword2"};
				passwords = new ArrayList<String> ();
				passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			PasswordCheckerUtility.isValidPassword("Def72");
			assertTrue("Did not throw lengthException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthException", true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			PasswordCheckerUtility.isValidPassword("lmnopq12");
			assertTrue("Did not throw NoUpperAlphaException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			PasswordCheckerUtility.isValidPassword("LMNOPQ12");
			assertTrue("Did not throw NoLowerException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a NoLowerException", true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			PasswordCheckerUtility.isValidPassword("abc12");
			assertTrue("Did not throw LengthException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthException", true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			PasswordCheckerUtility.isValidPassword("aabc12");
			assertTrue("Did not throw InvalidSequenceException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException", true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			PasswordCheckerUtility.isValidPassword("defghijk");
			assertTrue("Did not throw NoDigitException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a NoDigitException", true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			PasswordCheckerUtility.isValidPassword("Hello123");
			assertTrue("Did not throw isValidPassword", true);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a isValidPassword", false);
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(results.size(), 12);
		assertEquals(results.get(0), "553DD377 -> The password must contain at least one lower case alphabetic character");
		assertEquals(results.get(1), "He11ooOu -> The password must contain at least one special character");
		assertEquals(results.get(2), "michael2AAA -> The password must contain at least one special character");
		assertEquals(results.get(3), "4head -> The password must be at least 6 characters long");
		assertEquals(results.get(4), "martha22 -> The password must contain at least one uppercase alphabetic character"); 
		assertEquals(results.get(5), "4wardMarch -> The password must contain at least one special character");
		assertEquals(results.get(6), "30august -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(7), "Grapesxx -> The password must contain at least one digit");
		assertEquals(results.get(8), "bbllc -> The password must be at least 6 characters long");
		assertEquals(results.get(9), "pivotProyect -> The password must contain at least one digit");
		assertEquals(results.get(10), "myProtecto -> The password must contain at least one digit");
		assertEquals(results.get(11), "myPassword2 -> The password must contain at least one special character");
	}
	
}