package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.appium.locators.LoginUI;
import com.appium.utils.ExcelUtils;
import com.appium.utils.StringUtils;

public class LoginPage extends LoginUI {



	public LoginPage(AndroidDriver driver) throws IOException {
		super(driver);
		loadData();

	}

	public WebElement login() {

		waitUntilVisible(homeNavigator);
		if (elementExists(homeNavigator)){
			homeNavigator.click();
		}
		if (elementExists(signOutStatus))
			signOutStatus.click();
		if (elementExists(userNme) && elementExists(passwd)) {
			userNme.clear();
			userNme.sendKeys(ExcelUtils.getCellValue(1, 0));
			passwd.clear();
			passwd.sendKeys(ExcelUtils.getCellValue(1, 1));
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (elementExists(signInOk)){
			signInOk.click();
		}
		waitUntilVisible(remember);
		testPage.takeScreenShot(driver, StringUtils.LOGIN_TESTCASE);
		if (elementExists(remember))
			remember.click();
		waitUntilVisible(homeNavigator);
		if (elementExists(homeNavigator))
			homeNavigator.click();
		if (elementExists(signInStatus))
			return signInStatus;

		return null;

	}

	private void loadData() throws IOException {
		ExcelUtils.loadExcelData(StringUtils.LOGIN_TEST_DATA_PATH,
				StringUtils.LOGIN_TEST_DATA_SHEET_NAME);

	}

}
