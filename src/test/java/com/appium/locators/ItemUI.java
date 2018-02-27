package com.appium.locators;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.appium.utils.PageUtils;


/**
 * The Class ItemUI.
 */
public class ItemUI extends PageUtils {

	/**
	 * Instantiates a new item ui.
	 *
	 * @param driver the driver
	 */
	public ItemUI(AndroidDriver driver) {
		super(driver);

	}

	/** The filter. */
	@FindBy(id = "com.ebay.mobile:id/button_filter")
	protected WebElement filter;

	/** The back. */
	@FindBy(id= "com.ebay.mobile:id/button_back_all_filters")
	protected WebElement back;

	/** The done. */
	@FindBy(id= "com.ebay.mobile:id/menu_search")
	protected WebElement done;

	/** The image. */
	@FindBy(id= "com.ebay.mobile:id/imageview_viewpager")
	protected WebElement image;


	/** The buy. */
	@FindBy(xpath= "//android.widget.Button[@content-desc='Buy It Now']")
	protected WebElement buy;


	/** The quantity. */
	@FindBy(id= "android:id/numberpicker_input")
	protected WebElement quantity;


	/** The image instances. */
	@FindBy(how = How.XPATH , using = "//android.widget.FrameLayout[@content-desc='Item photos']")

	protected WebElement imageInstances;


	/** The item id. */
	@FindBy(xpath= "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']")
	protected WebElement itemId;


	/** The color. */
	protected String color = "\"Colour\"";

	/** The black. */
	protected String black = "\"Black\"";

	/** The item. */
	protected String item = "\"Smart Wrist Watch\"";

	/** The resouce. */
	protected String resouce= "\"com.ebay.mobile:id/search_refine_fragment\"";

	/** The show more. */
	protected String showMore ="\"Show more\"";



}
