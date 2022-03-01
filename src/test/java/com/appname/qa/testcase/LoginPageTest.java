package com.appname.qa.testcase;

import java.io.IOException;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.HomePage;
import com.appname.qa.pages.LoginPage;
import com.appname.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	public LoginPageTest() {
		super();
	}
	
	//test cases should be independant-->seperate from each other
	//before each test case --launch the browser and login
	//excecute ur test case
	//after each test case--close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialisation();
		loginpage=new LoginPage();	
		homepage=new HomePage();
		testutil=new TestUtil();
		homepage.clickLoginlink();
//		TestUtil.explictwait(loginpage.emailtxtbox);
		
	}
	@DataProvider
	public Object[][] gettestdata() throws EncryptedDocumentException, IOException
	{
		Object[][] data = TestUtil.getTestData("logindata");
		return data;
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 2,enabled = false)
	public void logintitle()
	{
		String title = loginpage.loginpagetitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority = 2,enabled = false) 
	public void Invalidlogin() throws InterruptedException, IOException
	{Thread.sleep(2000);
		String errormsg = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.takescreenshot();
		Assert.assertEquals(errormsg, "Invalid login");
	}
	
	@Test(priority = 1,dataProvider = "gettestdata")
	
	public void Invalidlogin(String username,String password) throws InterruptedException, IOException
	{
//		Thread.sleep(2000);
	System.out.println(username+"   "+password);
		String errormsg = loginpage.login(username,password);
		testutil.takescreenshot();
		Assert.assertEquals(errormsg, "Invalid login");
	}
}
