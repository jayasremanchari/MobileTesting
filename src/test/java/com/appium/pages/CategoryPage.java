package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.PageFactory;

import com.appium.locators.CategoryUI;

public class CategoryPage extends CategoryUI {


	public CategoryPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public MobileElement selectSubtegory() {
		waitUntilVisible(categoryList);
		MobileElement element = scrollToElement(categoryClass,catgElement);
		if(elementExists(element)){
		element.click();
		return element;
		}
		return null;

	}



}
