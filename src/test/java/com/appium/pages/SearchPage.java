package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.appium.locators.SearchUI;
import com.appium.utils.StringUtils;

public class SearchPage extends SearchUI {


	final static Logger logger = Logger.getLogger(SearchPage.class);
	 public SearchPage(AndroidDriver driver) {
		super(driver);
	}

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

	public WebElement searchByText() throws NoSuchElementException {

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
			waitUntilVisible(itemId);
			itemId.click();
			logger.info("Item Selected..");
			testPage.takeScreenShot(driver,
					StringUtils.PURCHASE_BY_TEXTINPUT_TESTCASE);
			MobileElement scrollElement = scrollToElement(searchcontainer, item);
			if (elementExists(scrollElement))
				scrollElement.click();
		}
		logger.info("Item Purchased - BySearch TextInput!!");
		testPage.takeScreenShot(driver,
				StringUtils.PURCHASE_BY_TEXTINPUT_TESTCASE);
		return null;
	}


}
