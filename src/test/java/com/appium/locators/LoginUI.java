package com.appium.locators;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appium.utils.PageUtils;

/**
 * The Class LoginUI.
 */
public class LoginUI extends PageUtils {

	/**
	 * Instantiates a new login ui.
	 *
	 * @param driver the driver
	 */
	public LoginUI(AndroidDriver driver) {
		super(driver);

	}

	/** The home navigator. */
	@FindBy(id = "com.ebay.mobile:id/home")
	protected WebElement homeNavigator;

	/** The sign out status. */
	@FindBy(id = "com.ebay.mobile:id/textview_sign_out_status")
	protected WebElement signOutStatus;

	/** The sign out. */
	@FindBy(id = "com.ebay.mobile:id/menuitem_sign_out")
	protected WebElement signOut;

	/** The ok. */
	@FindBy(id = "android:id/button1")
	protected WebElement ok;

	/** The sign in status. */
	@FindBy(id = "com.ebay.mobile:id/textview_sign_in_status")
	protected WebElement signInStatus;

	/** The user nme. */
	@FindBy (id = "com.ebay.mobile:id/edit_text_username")
	protected WebElement userNme;

	/** The passwd. */
	@FindBy (id = "com.ebay.mobile:id/edit_text_password")
	protected WebElement passwd;

	/** The remember. */
	@FindBy (id = "com.ebay.mobile:id/button_google_deny")
	protected WebElement remember;

	/** The sign in ok. */
	@FindBy (id = "com.ebay.mobile:id/button_sign_in")
	protected WebElement signInOk;



}
