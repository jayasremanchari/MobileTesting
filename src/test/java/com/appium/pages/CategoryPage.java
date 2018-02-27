package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.PageFactory;

import com.appium.locators.CategoryUI;
import com.appium.utils.StringUtils;

public class CategoryPage extends CategoryUI {


	public CategoryPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public MobileElement selectSubtegory() {
		waitUntilVisible(categoryList);
		testPage.takeScreenShot(driver, StringUtils.SEARCH_BY_CATEGORY_TESTCASE);
		MobileElement element = scrollToElement(categoryClass,catgElement);
		if(elementExists(element)){
		testPage.takeScreenShot(driver, StringUtils.SEARCH_BY_CATEGORY_TESTCASE);
		element.click();
		return element;
		}
		return null;

	}



}
