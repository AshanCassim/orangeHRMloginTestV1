package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="txtUsername")
	WebElement txtUsername;
	

	@FindBy(name="txtPassword")
	WebElement txtPassword;
	

	@FindBy(name="Submit")
	WebElement Submit;
	
	@FindBy(xpath="//*[@id=\'welcome\']")
	@CacheLookup
	WebElement adminlogouut;
	
	@FindBy(xpath="//*[@id=\'welcome-menu\']/ul/li[2]/a")
	@CacheLookup
	WebElement lnkLogout;

	public void setUsername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		Submit.click();
	}
	
	public void clickLogbut()
	{
		adminlogouut.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	}
