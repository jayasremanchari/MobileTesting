package com.appium.scenario;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.appium.config.Appiumconfiguration;
import com.appium.pages.LoginPage;

public class EbayAppTest  {

	final static Logger logger = Logger.getLogger(EbayAppTest.class);

	Appiumconfiguration appiumConfig;

	AndroidDriver driver;

	@BeforeSuite
	public void initDriver() throws MalformedURLException {

		appiumConfig = new Appiumconfiguration();
		driver = appiumConfig.getAndroidDriver();

	}

	@Test
	public void EbayAppTestCase()  {
		try {

			loginTest();

		}

		catch (NoSuchElementException ex) {

			logger.info("NoSuchElementException Caught in TestCase!"
					+ ex.getClass());

		} catch (TimeoutException ex) {


			logger.info("TimeoutException Caught in TestCase!" + ex.getClass());
		} catch (IOException ex) {

			logger.info("IOException Caught for the TestCase!.."
					+ "Please check for valid input path!" + ex.getClass());
		}

	}

	public void loginTest() throws IOException  {

		WebElement stats = null;

		stats = new LoginPage(driver).login();

		if (stats != null)
			assertEquals(stats.getText(), "fiya04");
		logger.info("Page Logged in Successfully!!");

	}

	@AfterClass
	public void tearDown() {

		this.driver.quit();
	}
}
