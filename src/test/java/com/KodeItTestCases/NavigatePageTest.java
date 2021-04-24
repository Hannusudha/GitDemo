package com.KodeItTestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.KodeItClasses.LoginPage;
import com.KodeItClasses.Utility;
import com.KodeItClasses.mainpage;
import com.beust.jcommander.Parameter;

public class NavigatePageTest {

	WebDriver driver;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void browserOpen(@Optional("chrome") String browser1) {

		if (browser1.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F://geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browser1.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");

			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("https://letskodeit.teachable.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	@Test(groups = { "sanity", "regression" })
	public void navigateToUrl() throws IOException {

		mainpage p = new mainpage(driver);
		p.clickOnLogin().click();
		
		System.out.println("adding comment from Git itself")

		Assert.assertEquals(driver.getTitle(), "Home | Let's Kode It");
		System.out.println("Task is successfully completed......!!!!!");

		Utility.takeScreen(driver);

		LoginPage l = new LoginPage(driver);
		l.getMailInput().sendKeys("sudhakarhosmani@yahoo.co.in");
		l.getPassInput().sendKeys("Janu@123");

		l.clickOnBtn().click();

		System.out.println("----Logged in Successfully---");
	}

	@Test(groups = { "sanity", "regression" })
	public void verifyHeader() {

		mainpage p = new mainpage(driver);

		Assert.assertEquals(p.hedartxt().getText(), "Featured Courses");

		System.out.println("*******Test is successfully************");

	}

	@Test
	public void verifyTextPrac() {

		mainpage p = new mainpage(driver);

		Reporter.log("executing something from the verify TEXT prac", true);
		Assert.assertEquals(p.verifyText().getText(), "Practice");

		System.out.println("*******Test is successfully*****(Practice)*******");

	}

	@Test(groups = "regression")
	public void verifyCourseLink() {

		mainpage p = new mainpage(driver);

		Assert.assertEquals(p.getcoursesLink().getText(), "View All Products");

		System.out.println("*******Test is successfully*****(View All Courses)*******");

	}

}
