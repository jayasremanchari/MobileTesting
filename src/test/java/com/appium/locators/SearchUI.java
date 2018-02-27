package com.appium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appium.utils.PageUtils;

import io.appium.java_client.android.AndroidDriver;

public class SearchUI extends PageUtils {


	public SearchUI(AndroidDriver driver) {
		super(driver);
	}

	@FindBy(id = "com.ebay.mobile:id/search_box")
	protected WebElement search;

	@FindBy(id = "com.ebay.mobile:id/search_src_text")
	protected WebElement searchtext;


	@FindBy(id= "com.ebay.mobile:id/capsule_categories")
	protected WebElement categories;

	protected By container = By.id("com.ebay.mobile:id/top_scrollview");

	protected String resouce= "\"com.ebay.mobile:id/channel_content\"";
	protected String element ="\"Mobile Accessories\"";

	protected String searchcontainer= "\"com.ebay.mobile:id/top_scrollview_content\"";
	protected String item ="\"Buy It Now\"";

	@FindBy(xpath= "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='2']")
	protected WebElement itemId;




}
