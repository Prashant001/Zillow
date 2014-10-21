package com.prashant.zillow;




import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Utils
 */
public class UtilsTest 
{

	
   
	@Test public void positiveLong() 
	{
		    Assert.assertEquals(7564, Utils.stringToLong("7564"));
	}
	
	@Test public void negativeLong() 
	{
		    Assert.assertEquals(-7564, Utils.stringToLong("-7564"));
	}
	
	@Test(expected=NumberFormatException.class) public void invalidstringAlonePositive() 
	{
		    Utils.stringToLong("+");
	}
	
	@Test(expected=NumberFormatException.class) public void invalidstringAloneNegative() 
	{
		    Utils.stringToLong("-");
	}
	
	@Test(expected=NumberFormatException.class) public void invalidstringNullString() 
	{
		    Utils.stringToLong("");
	}
	
	@Test(expected=NumberFormatException.class) public void invalidString() 
	{
		    Utils.stringToLong("1aqwe");
	}
	
	@Test(expected=NumberFormatException.class) public void invalidStringSpace() 
	{
		    Utils.stringToLong("12  345");
	}
	
	@Test public void longMaxValueTest() 
	{
		    Assert.assertEquals(Long.MAX_VALUE,Utils.stringToLong("9223372036854775807"));
	}
	
	@Test public void longMinValueTest() 
	{
		    Assert.assertEquals(Long.MIN_VALUE,Utils.stringToLong("-9223372036854775808"));
	}
	
	@Test(expected=NumberFormatException.class) public void longMaxValueTestBoundary() 
	{
		    Utils.stringToLong("9223372036854775808");
	}
	
	@Test(expected=NumberFormatException.class) public void longMinValueTestBoundary() 
	{
		    Utils.stringToLong("-9223372036854775809");
	}
	
	@Test(expected=NumberFormatException.class)public void longLargerMaxValueTest() 
	{
		 	Utils.stringToLong("922337203685477580712123");
	}
	
	
	@Test(expected=NumberFormatException.class) public void longSmallerMinValueTest() 
	{
		    Utils.stringToLong("-9223372036854775808123");
	}
}
