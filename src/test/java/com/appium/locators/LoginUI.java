package com.appium.locators;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appium.utils.PageUtils;

public class LoginUI extends PageUtils {
	public LoginUI(AndroidDriver driver) {
		super(driver);

	}
	@FindBy(id = "com.ebay.mobile:id/home")
	protected WebElement homeNavigator;

	@FindBy(id = "com.ebay.mobile:id/textview_sign_out_status")
	protected WebElement signOutStatus;

	@FindBy(id = "com.ebay.mobile:id/menuitem_sign_out")
	protected WebElement signOut;

	@FindBy(id = "android:id/button1")
	protected WebElement ok;

	@FindBy(id = "com.ebay.mobile:id/textview_sign_in_status")
	protected WebElement signInStatus;

	@FindBy (id = "com.ebay.mobile:id/edit_text_username")
	protected WebElement userNme;

	@FindBy (id = "com.ebay.mobile:id/edit_text_password")
	protected WebElement passwd;

	@FindBy (id = "com.ebay.mobile:id/button_google_deny")
	protected WebElement remember;

	@FindBy (id = "com.ebay.mobile:id/button_sign_in")
	protected WebElement signInOk;



}
