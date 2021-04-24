package com.KodeItClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By usermail = By.id("user_email");

	By userpass = By.id("user_password");
	By loginBtn = By.name("commit");

	public WebElement clickOnBtn() {

		return driver.findElement(loginBtn);

	}


	public WebElement getMailInput() {
		return driver.findElement(usermail);
	}

	public WebElement getPassInput() {
		return driver.findElement(userpass);
	}

}
