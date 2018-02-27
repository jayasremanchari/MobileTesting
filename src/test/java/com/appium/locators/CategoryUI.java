package com.appium.locators;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import com.appium.utils.PageUtils;


/**
 * The Class CategoryUI.
 */
public class CategoryUI extends PageUtils {

	/**
	 * Instantiates a new category ui.
	 *
	 * @param driver the driver
	 */
	public CategoryUI(AndroidDriver driver) {
		super(driver);
	}

	/** The category list. */
	protected By categoryList= By.id("com.ebay.mobile:id/fragment_container");

	/** The category class. */
	protected	String categoryClass = "\"com.ebay.mobile:id/category_list\"";

	/** The catg element. */
	protected String catgElement = "\"Mobile Gadgets\"";

}
