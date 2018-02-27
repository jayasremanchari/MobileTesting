package com.appium.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import com.appium.locators.SearchUI;
import com.appium.utils.PageUtils;
import com.appium.utils.StringUtils;

public class SearchPage extends SearchUI {



	 public SearchPage(AndroidDriver driver) {
		super(driver);
	}

	public MobileElement searchByCategory() {

		 waitUntilVisible(categories);
		 if(elementExists(categories))
		 categories.click();
		 waitUntilVisible(container);
		 MobileElement scrollElement = scrollToElement(resouce,element);
		 if(elementExists(scrollElement)){
		 scrollElement.click();
		 return scrollElement;
		 }
		return null;

	}
	public WebElement searchByText() throws NoSuchElementException {



		if (elementExists(homeNavigator))
			homeNavigator.click();
				if (elementExists(home))
			home.click();

		if(elementExists(search))
		search.clear();
		searchtext.sendKeys(StringUtils.SEARCH_TEXT+"\n");
		waitUntilVisible(itemId);
		itemId.click();
		 MobileElement scrollElement = scrollToElement(searchcontainer, item);
		 if(elementExists(scrollElement))
			 scrollElement.click();


		return null;
	}


}
