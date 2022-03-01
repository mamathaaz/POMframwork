package com.appname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appname.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="email")//@CacheLookup
	public
	WebElement emailtxtbox;
	
	@FindBy(name="password")
	WebElement pwdtxtbox;
	
	@FindBy(xpath="//*[@class=\"ui fluid large blue submit button\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[text()=\"Invalid login\"]")
	WebElement invalidLogin;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginpagetitle()
	{
		return driver.getTitle();
	}
	
	public String login(String username,String password)
	{
		
		emailtxtbox.sendKeys(username);		
		pwdtxtbox.sendKeys(password);
		loginBtn.click();
		return invalidLogin.getText();
	}
}
