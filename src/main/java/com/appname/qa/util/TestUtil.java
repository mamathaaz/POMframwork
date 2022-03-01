package com.appname.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appname.qa.base.TestBase;

public class TestUtil extends TestBase{
public static long page_load_timeout=20;
public static long page_imp_wait=10;
public static String TestData_path="C:\\Users\\mamatha\\eclipse-workspace\\Selenium\\POMframwork\\src\\main\\java\\com\\appname\\qa\\testdata\\testdata.xlsx";

public void switchtoframe()
{
	driver.switchTo().frame("");
}
	
public static void explictwait(WebElement locator)
{
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeSelected(locator));
}

public static Object[][] getTestData(String Sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(TestData_path);
	Workbook book = WorkbookFactory.create(fis);
	 Sheet sheet = book.getSheet(Sheetname);
	int row = sheet.getLastRowNum();
	int column = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[row][column];
	for(int i=0;i<row;i++)
	{
		for(int k=0;k<column;k++)
{
	data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	
}
	}
	return data;
	
}

public static void takescreenshot() throws IOException

{
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir=System.getProperty("user.dir");
	FileUtils.copyFile(srcfile, new File(currentDir+"/Screenshots/"+System.currentTimeMillis()+".png"));
}
}
