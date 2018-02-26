package com.appium.locators;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import com.appium.utils.PageUtils;

public class CategoryUI extends PageUtils {

	public CategoryUI(AndroidDriver driver) {
		super(driver);
	}

	protected By categoryList= By.id("com.ebay.mobile:id/fragment_container");

	protected	String categoryClass = "\"com.ebay.mobile:id/category_list\"";

	protected String catgElement = "\"Mobile Gadgets\"";

}
