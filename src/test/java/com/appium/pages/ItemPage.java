package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.PageFactory;

import com.appium.locators.ItemUI;
import com.appium.utils.StringUtils;

public class ItemPage extends ItemUI {

	public ItemPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectItem() {

		findElementByText(item).click();
		if (elementExists(itemId))
			itemId.click();
		viewItemImages();
		buy();
	}

	private void buy() {
		if (elementExists(buy)){
			testPage.takeScreenShot(driver, StringUtils.PURCHASE_BY_CATEGORY_TESTCASE);
			buy.click();
		}

	}

	private void viewItemImages() {
		testPage.takeScreenShot(driver, StringUtils.PURCHASE_BY_CATEGORY_TESTCASE);
		swipe(image);


	}

	private void applyFilter() {
		if (elementExists(filter))
			filter.click();
		if(elementExists(findElementByText(color)))
				findElementByText(color).click();
		if(elementExists(findElementByText(black)))
			findElementByText(black).click();
		done();
	}

	private void done() {
		if (elementExists(done))
			done.click();

	}

}
