/**
 * This Class is for Question 1
 * 
 * Known Limitations: 
 * 
 * 1. Only decimal inputs (radix 10) are accepted. Other radix inputs like hexadecimal are not accepted. 
 * The code is written to accept a radix method, need to do some work to parse input to accpet characters
 * like '0X', 'L' etc. in the beginning and end of the input string
 * 
 * @author Prashant Bhartiya
 */
package com.prashant.zillow;

public class Utils {
	
	/**
	 * Converts a string in base 10 to a long value. 
	 * 
	 * @param s A numeric string to convert.
	 * @return The numeric value of the string.
	 * @throws NumberFormatException, if the string cannot be converted to a long
	 */
	
	public static long stringToLong(String s) throws NumberFormatException
	{
		return stringToLong(s,10);
	}
	
	/**
	 * Converts a string in base 10 to a long value. 
	 * 
	 * @param s A numeric string to convert.
	 * @param   radix  The radix to use 
	 * @return The numeric value of the string.
	 * @throws NumberFormatException, if the string cannot be converted to a long
	 */
	
	
	public static long stringToLong(String s, int radix)
            throws NumberFormatException
    {
		if (s == null) 
		{
			throw new NumberFormatException("null");
		}

		if (radix > Character.MAX_RADIX) 
		{
			throw new NumberFormatException("radix " + radix
					+ " is greater than Character.MAX_RADIX");
		}
		if (radix < Character.MIN_RADIX) 
		{
			throw new NumberFormatException("radix " + radix
					+ " is less than Character.MIN_RADIX");
		}

		int length = s.length();
		if (length == 0)
		{
			throw new NumberFormatException("Zero Length String");
		}
		
		boolean isNegative = false;
		int i = 0;
	
		long limit = Long.MAX_VALUE;
		
		
	
		char firstChar = s.charAt(0);
		// Check For leading '-' or '+'
		if (firstChar < '0') 
		{ 
			if (firstChar == '-')
			{
				isNegative = true;
				
			}
			else if (firstChar != '+')
			{
				throw new NumberFormatException("Invalid String: " + s);
			}

			//Check if string is  '-' or '+'
			if (length == 1) 
				throw new NumberFormatException("Cannot specify '-' or '+' alone as the string to convert");
			i++;
		}

		
		long multmin;
		int digit;
		long result = 0;
		
		multmin = limit / radix;
		
		while (i < length) {
			digit = Character.digit(s.charAt(i++), radix);
			if (digit < 0)
			{
				throw new NumberFormatException("Invalid String for converting to long: " + s);
			}
			// Check if the number to be converted is out of range for long numbers
			if (result >= multmin && i < length -1) 
		    {
				throw new NumberFormatException("Number out of range for long: " + s);
			
			}
			
			result *= radix;
			
			// Check for boundary cases
			if (isNegative && ((-result) < Long.MIN_VALUE + digit)) 
			{
				throw new NumberFormatException("Invalid string," +  
						"long value less than Long.MIN_VALUE: " + s);
						
			}
			if (!isNegative && (result  >  (Long.MAX_VALUE - digit)) ) 
			{
				throw new NumberFormatException("Invalid string," +  
						"long value greater than Long.MAX_VALUE: " + s);
						
			}
			result += digit;
		}
		
		return isNegative ? -result : result;
	}

}
