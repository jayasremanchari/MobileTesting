package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import com.appium.locators.SearchUI;

public class SearchByCategoryPage extends SearchUI {



	 public SearchByCategoryPage(AndroidDriver driver) {
		super(driver);
	}

	public MobileElement searchCategory() {

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



}
