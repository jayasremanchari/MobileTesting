package com.appium.utils;

import java.util.NoSuchElementException;

import io.appium.java_client.android.AndroidDriver;

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


}
