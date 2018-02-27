package com.appium.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class MobileUtils.
 */
public class MobileUtils {

	/**
	 * Take screen shot.
	 *
	 * @param driver the driver
	 * @param page the page
	 *
	 * Takes the screenshot of the page provided and save the image to a destination in the form of png format.
	 */
	public void takeScreenShot(AndroidDriver driver, String page) {

		String destDir = "src/test/resources/output/screenshots";

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		new File(destDir).mkdirs();

		String destFile =  page + "_" + dateFormat.format(new Date())
				+ ".png";

		try {

			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
