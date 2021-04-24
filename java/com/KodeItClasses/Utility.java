package com.KodeItClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 

public class Utility {

	public static void takeScreen(WebDriver driver) throws IOException {

		String directory = "F:\\screenshot.png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(directory + ".png"));

		
	}

}
