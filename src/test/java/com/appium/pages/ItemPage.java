package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.PageFactory;

import com.appium.locators.ItemUI;
import com.appium.utils.StringUtils;


/**
 * The Class ItemPage.
 */
public class ItemPage extends ItemUI {

	/**
	 * Instantiates a new item page.
	 *
	 * @param driver the driver
	 */
	public ItemPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Select item.
	 */
	public void selectItem() {

		findElementByText(item).click();
		if (elementExists(itemId))
			itemId.click();
		viewItemImages();
		buy();
	}

	/**
	 * Buy.
	 */
	private void buy() {
		if (elementExists(buy)){
			testPage.takeScreenShot(driver, StringUtils.PURCHASE_BY_CATEGORY_TESTCASE);
			buy.click();
		}

	}

	/**
	 * View item images.
	 * View the selected item by swiping the image with the help of horizontal swipe function.
	 */
	private void viewItemImages() {
		testPage.takeScreenShot(driver, StringUtils.PURCHASE_BY_CATEGORY_TESTCASE);
		swipe(image);


	}

	/**
	 * Apply filter.
	 */
	private void applyFilter() {
		if (elementExists(filter))
			filter.click();
		if(elementExists(findElementByText(color)))
				findElementByText(color).click();
		if(elementExists(findElementByText(black)))
			findElementByText(black).click();
		done();
	}

	/**
	 * Done.
	 */
	private void done() {
		if (elementExists(done))
			done.click();

	}

	/**
	 * Purchase item.
	 * Scroll through the page and select the provided item.
	 */
	public void purchaseItem() {
		waitUntilVisible(itemId);
		itemId.click();
		testPage.takeScreenShot(driver,
				StringUtils.PURCHASE_BY_TEXTINPUT_TESTCASE);
		MobileElement scrollElement = scrollToElement(searchcontainer, buyItem);
		if (elementExists(scrollElement))
			scrollElement.click();
		testPage.takeScreenShot(driver,
				StringUtils.PURCHASE_BY_TEXTINPUT_TESTCASE);
	}

}
