package com.appium.locators;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.appium.utils.PageUtils;


/**
 * The Class SearchUI.
 */
public class SearchUI extends PageUtils {


	/**
	 * Instantiates a new search ui.
	 *
	 * @param driver the driver
	 */
	public SearchUI(AndroidDriver driver) {
		super(driver);
	}

	/** The search. */
	@FindBy(id = "com.ebay.mobile:id/search_box")
	protected WebElement search;

	/** The searchtext. */
	@FindBy(id = "com.ebay.mobile:id/search_src_text")
	protected WebElement searchtext;


	/** The categories. */
	@FindBy(id= "com.ebay.mobile:id/capsule_categories")
	protected WebElement categories;

	/** The container. */
	protected By container = By.id("com.ebay.mobile:id/top_scrollview");

	/** The resouce. */
	protected String resouce= "\"com.ebay.mobile:id/channel_content\"";

	/** The element. */
	protected String element ="\"Mobile Accessories\"";


	/** The home navigator. */
	@FindBy(id = "com.ebay.mobile:id/home")
	protected WebElement homeNavigator;

	/** The home. */
	@FindBy(id = "com.ebay.mobile:id/menuitem_home")
	protected WebElement home;





}
