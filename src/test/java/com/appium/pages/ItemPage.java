package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.PageFactory;

import com.appium.locators.ItemUI;

public class ItemPage extends ItemUI {

	public ItemPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectItem() {

		findElementByText(item).click();
		applyFilter();
		if (elementExists(itemId))
			itemId.click();
		viewItemImages();
		buy();
	}

	private void buy() {
		if (elementExists(buy))
			buy.click();

	}

	private void viewItemImages() {

		swipe(image);

	}

	private void applyFilter() {
		if (elementExists(filter))
			filter.click();
		findElementByText(color).click();
		findElementByText(black).click();
		done();
	}

	private void done() {
		if (elementExists(done))
			done.click();

	}

}
