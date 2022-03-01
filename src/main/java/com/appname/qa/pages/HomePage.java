package com.appname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appname.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page factory object repository
	
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	@FindBy(xpath="//img[contains(@src,'freecrm_logo.png')]")
	WebElement logoimg;
	
	//@FindBy(className,css,is,linktext,nam,partiallinktext,tagnam,using,xpath )
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String valiatedpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatecrmlogo()
	{
		return logoimg.isDisplayed();
	}
	
	public LoginPage clickLoginlink()
	{
		loginLink.click();
		return new LoginPage();
	}
}
