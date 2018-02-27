package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.appium.locators.SearchUI;
import com.appium.utils.StringUtils;


/**
 * The Class SearchPage.
 */
public class SearchPage extends SearchUI {


	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(SearchPage.class);

 	/**
 	 * Instantiates a new search page.
 	 *
 	 * @param driver the driver
 	 */
 	public SearchPage(AndroidDriver driver) {
		super(driver);
	}

	/**
	 * Search by category.
	 *
	 * @return the mobile element
	 * The method searches an item through its category (Here "MobileAccessories")
	 * Categories tab is clicked.
	 * Scroll through the page until Mobile Accessories is found and the select.
	 */
	public MobileElement searchByCategory() {

		 waitUntilVisible(categories);
		testPage.takeScreenShot(driver, StringUtils.SEARCH_BY_CATEGORY_TESTCASE);
		 if(elementExists(categories))
		 categories.click();
		 waitUntilVisible(container);
		 MobileElement scrollElement = scrollToElement(resouce,element);
		 testPage.takeScreenShot(driver, StringUtils.SEARCH_BY_CATEGORY_TESTCASE);
		 if(elementExists(scrollElement)){
		 scrollElement.click();

		 return scrollElement;
		 }
		return null;

	}

	/**
	 * Search by text.
	 *
	 * @return the web element
	 * @throws NoSuchElementException the no such element exception
	 * The method searches an item through the search input provided in the search text box.
	 * Click on home navigator and go to Home page.
	 * In the search text box field, item to be searched is given as input. (Here "Smart Wrist Watch")
	 *
	 */
	public void searchByText() throws NoSuchElementException {

		if (elementExists(homeNavigator))
			homeNavigator.click();
		testPage.takeScreenShot(driver,
				StringUtils.SEARCH_BY_TEXTINPUT_TESTCASE);
		if (elementExists(home))
			home.click();
		logger.info("Navigated Back To Home Button..");
		if (elementExists(search)) {
			search.clear();
			testPage.takeScreenShot(driver,
					StringUtils.SEARCH_BY_TEXTINPUT_TESTCASE);
			searchtext.sendKeys(StringUtils.SEARCH_TEXT + "\n");
			logger.info("Input Provided in SearchText Box..");
			testPage.takeScreenShot(driver,
					StringUtils.SEARCH_BY_TEXTINPUT_TESTCASE);
		}

	}


}
