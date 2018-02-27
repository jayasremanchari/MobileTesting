package com.appium.scenario;

import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.appium.config.Appiumconfiguration;
import com.appium.pages.CategoryPage;
import com.appium.pages.ItemPage;
import com.appium.pages.LoginPage;
import com.appium.pages.SearchPage;
import com.appium.utils.PageUtils;

public class EbayAppTest  {

	final static Logger logger = Logger.getLogger(EbayAppTest.class);

	Appiumconfiguration appiumConfig;

	AndroidDriver driver;

	@BeforeSuite
	public void initDriver() throws MalformedURLException {

		appiumConfig = new Appiumconfiguration();
		driver = appiumConfig.getAndroidDriver();

	}

	@Test(priority = 0)
	public void EbayAppSearchByCategoryTestCase()  {
		try {
			logger.info("Test Case Scenario1 [STARTED]-  SearchItemCategoryWise");
			loginTest();
			searchCategoryTest();
			subCategorySelect();
			purchaseItem();
			logger.info("Test Case Scenario1 [COMPLETED]-  SearchItemCategoryWise");
			logger.info("***********************");

		}
		catch (NoSuchElementException ex) {

			logger.info("NoSuchElementException Caught in TestCase!"
					+ ex.getClass());

		} catch (TimeoutException ex) {


			logger.info("TimeoutException Caught in TestCase!" + ex.getClass());
		} catch (IOException ex) {

			logger.info("IOException Caught for the TestCase!.."
					+ "Please check for valid input path!" + ex.getClass());
		}

	}



	@Test(dependsOnMethods = { "EbayAppSearchByCategoryTestCase" })
	public void EbayAppSearchByTextInputTestCase() throws IOException {
		logger.info("Test Case Scenario2 [STARTED]-  SearchItemByTextInput");
		searchByText();
		logger.info("Test Case Scenario2 [COMPLETED]-  SearchItemByTextInput");
		logger.info("***********************");
	}


	private void searchByText() {

		new SearchPage(driver).searchByText();
	}



	public void loginTest() throws IOException  {

		WebElement stats = null;

		stats = new LoginPage(driver).login();

		if (stats != null)
			assertEquals(stats.getText(), "jayasrmanchar_0");
		logger.info("Page Logged in Successfully!!");

	}


		public void searchCategoryTest() {

		PageUtils.previousPage();
		WebElement stats = new SearchPage(driver).searchByCategory();
		if(stats!=null)
		assertEquals(stats.getText(), "Mobile Accessories");
		logger.info("Category Selection completed..");
}
	public void subCategorySelect() {

		WebElement stats = new CategoryPage(driver).selectSubtegory();
		if(stats!=null)
		assertEquals(stats.getText(), "Mobile Gadgets");
		logger.info("SubCategory Selection  Completed..");

}

	public void purchaseItem() {

		new ItemPage(driver).selectItem();
		logger.info("Item Purchased - Category-wise.");


}

	@AfterSuite
	public void tearDown() {

		this.driver.quit();


	}
}
