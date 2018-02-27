package com.appium.config;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.utils.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Appiumconfiguration.
 */
public class Appiumconfiguration {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(Appiumconfiguration.class);

	/** The properties. */
	static Properties properties;

	/** The driver. */
	private AndroidDriver driver;


	/**
	 * Instantiates a new appiumconfiguration.
	 */
	public Appiumconfiguration() {
		PropertyConfigurator.configure(StringUtils.LOG_PATH);
		loadProperties();
	}

	/**
	 * Gets the android driver.
	 *
	 * @return the android driver
	 * @throws MalformedURLException the malformed url exception
	 *
	 * The method sets the device properties to the appium driver in
	 * order to establish a session between the Appium server and
	 * the client.
	 *
	 */
	public AndroidDriver getAndroidDriver() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", properties.get("deviceName"));
		capabilities.setCapability("platformName",properties.get("platformName"));
		capabilities.setCapability("platformVersion",properties.get("platformVersion"));
		capabilities.setCapability("appPackage", properties.get("appPackage"));
		capabilities.setCapability("appActivity", properties.get("appActivity"));
		try {

			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
					capabilities);


		} catch (MalformedURLException e) {

			logger.error("Exception Caught while initiating driver", e);

		}
		return driver;

	}

	/**
	 * Load properties.
	 *
	 * The method loads the properties of the device to be tested from an external property file .
	 */
	private static void loadProperties() {
		try {

			FileInputStream file = new FileInputStream(StringUtils.PROP_PATH);
			properties = new Properties();
			properties.load(file);

		}

		catch (FileNotFoundException fe) {
			logger.error("FileNotFoundException caught" + fe);

		}

		catch (IOException io) {
			logger.error("IOException caught" + io);

		}

	}
}
