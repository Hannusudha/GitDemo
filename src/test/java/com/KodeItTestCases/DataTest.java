package com.KodeItTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest {

	WebDriver driver;

	@Test(dataProvider = "data")
	public void multipleData(String email, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");
		System.out.println("adding some data after adding develop branch");

		Thread.sleep(3000);

		driver.findElement(By.id("user_email")).sendKeys(email);

		driver.findElement(By.id("user_password")).sendKeys(password);

	}

	@DataProvider(name = "data")
	
	public Object[][] getData() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Sheet");

		int row = s.getLastRowNum() - s.getFirstRowNum();
		
		System.out.println("the last row number is :"+s.getLastRowNum());
		System.out.println("the first row numbe is :"+s.getFirstRowNum());
		
		System.out.println("the actual row's are " + row);
		Row r = s.getRow(1);

		int col = r.getLastCellNum();
		System.out.println("get the last col value in row 1 is :"+col);
		return null;

		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
