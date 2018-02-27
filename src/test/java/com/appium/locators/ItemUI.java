package com.appium.locators;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.appium.utils.PageUtils;

public class ItemUI extends PageUtils {

	public ItemUI(AndroidDriver driver) {
		super(driver);

	}

	@FindBy(id = "com.ebay.mobile:id/button_filter")
	protected WebElement filter;

	@FindBy(id= "com.ebay.mobile:id/button_back_all_filters")
	protected WebElement back;

	@FindBy(id= "com.ebay.mobile:id/menu_search")
	protected WebElement done;

	@FindBy(id= "com.ebay.mobile:id/imageview_viewpager")
	protected WebElement image;


	@FindBy(xpath= "//android.widget.Button[@content-desc='Buy It Now']")
	protected WebElement buy;


	@FindBy(id= "android:id/numberpicker_input")
	protected WebElement quantity;


	@FindBy(how = How.XPATH , using = "//android.widget.FrameLayout[@content-desc='Item photos']")

	protected WebElement imageInstances;


	@FindBy(xpath= "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']")
	protected WebElement itemId;


	protected String color = "\"Colour\"";
	protected String black = "\"Black\"";
	protected String item = "\"Smart Wrist Watch\"";

	protected String resouce= "\"com.ebay.mobile:id/search_refine_fragment\"";
	protected String showMore ="\"Show more\"";



}
