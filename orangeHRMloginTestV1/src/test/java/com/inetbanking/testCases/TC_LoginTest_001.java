package com.inetbanking.testCases;

import com.inetbanking.pageObjects.Loginpage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void logintest() throws IOException 
	{
		
		Loggr.info("URL is Opened");
		
		Loginpage lp = new Loginpage(driver);
		
		lp.setUsername(username);
		Loggr.info("Entered username");
		
		lp.setPassword(password);
		Loggr.info("Entered pwd");
		
		lp.clickSubmit();
		Loggr.info("Entered submit");
		
		if(driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
			Loggr.info("Test Passed");
		}
		else 
		{
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			Loggr.info("Test failed");
			throw new AssertionError("Test failed");
		}
	}
		
	
}
