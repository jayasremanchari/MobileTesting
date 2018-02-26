package com.appium.utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {

	protected static AndroidDriver driver;
	public PageUtils(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 protected void waitUntilVisible(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));

		}

	 protected void waitUntilVisible(By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	 protected boolean elementExists(WebElement element){
		 try{

			 if(element.isDisplayed())
				 return true;
		 }
		 catch(NoSuchElementException ex){
			 return false;
		 }
		return false;
	 }

	 protected MobileElement scrollToElement(String resource,String element) {

		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		MobileElement selectedCategory =(MobileElement) driver.findElement(MobileBy.AndroidUIAutomator
				("new UiScrollable(new UiSelector().resourceId("+resource+")).scrollIntoView(new UiSelector().text("+element+"))"));


		return selectedCategory;



		}

	 public static void previousPage() {

			driver.pressKeyCode(AndroidKeyCode.BACK);

		}


}
