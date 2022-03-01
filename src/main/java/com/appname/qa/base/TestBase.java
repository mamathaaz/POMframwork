package com.appname.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.appname.qa.util.TestUtil;
import com.appname.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	EventFiringWebDriver e_driver;
	WebEventListener eventListner;
//constructor
	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\mamatha\\eclipse-workspace\\Selenium\\POMframwork\\src\\main\\java\\com\\appname\\qa\\configuration\\config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	

	public static void initialisation() throws InterruptedException
	{
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamatha\\eclipse-workspace\\Selenium\\POMframwork\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		
		if(browsername.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "");
		driver=new FirefoxDriver();
		}
		

		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		WebEventListener eventListner = new WebEventListener();
		e_driver.register(eventListner);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.page_imp_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
//		Thread.sleep(1000);
		
	}

}
