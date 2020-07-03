package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Loginpage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws IOException, InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		
		lp.setUsername(user);
		Loggr.info("user name provided");
		
		lp.setPassword(pwd);
		Loggr.info("password provided");
		
		lp.clickSubmit();
		Loggr.info("clicked");
		
	
		if(ispicPresent()==true)
		{
			Assert.assertTrue(true);
			Loggr.info("Test Passed");
			lp.clickLogbut();
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			
		}
		else 
		{
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			Loggr.info("Test failed");
			Loggr.warn("Login failed");
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			
			
			throw new AssertionError("Test failed");
			
			
		}
		
		
		
		
	}
	
	public boolean ispicPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		WebElement pic =driver.findElement(By.xpath("//*[@id='div_graph_display_emp_distribution']/canvas[2]"));
		pic.isDisplayed();	
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}