package com.KodeItClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainpage {

	WebDriver driver;

	@FindBy(linkText = "View All Products")
	WebElement coursesLink;

	@FindBy(linkText = "Practice")

	WebElement linkPractice;

	public WebElement verifyText() {

		return linkPractice;
	}

	@FindBy(linkText = "Login")
	WebElement loginBtn;

	public WebElement clickOnLogin() {

		return loginBtn;
	}

	@FindBy(xpath = "//h2[text()='Featured Courses']")

	WebElement headerText;

	public WebElement getcoursesLink() {
		return coursesLink;
	}

	public WebElement hedartxt() {

		return headerText;
	}

	public mainpage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

}
