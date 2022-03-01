package com.appname.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.HomePage;
import com.appname.qa.pages.LoginPage;
import com.appname.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;

	public HomePageTest() {
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
		homepage=new HomePage();
		testutil=new TestUtil();
	}
	
	@Test(priority = 2)
	public void homepagetitle()
	{
		String title = homepage.valiatedpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
	
	@Test(priority = 1)
	public void validatelogo()
	{
		boolean logo = homepage.validatecrmlogo();
		System.out.println(logo);
		Assert.assertTrue(logo);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
