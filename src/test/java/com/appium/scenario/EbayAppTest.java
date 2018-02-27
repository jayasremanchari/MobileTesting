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

// TODO: Auto-generated Javadoc
/**
 * The Class EbayAppTest.
 */
public class EbayAppTest  {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(EbayAppTest.class);

	/** The appium config. */
	Appiumconfiguration appiumConfig;

	/** The driver. */
	AndroidDriver driver;

	/**
	 * Inits the driver.
	 *
	 * @throws MalformedURLException the malformed url exception
	 */
	@BeforeSuite
	public void initDriver() throws MalformedURLException {

		appiumConfig = new Appiumconfiguration();
		driver = appiumConfig.getAndroidDriver();

	}

	/**
	 * Ebay app search by category test case.
	 *
	 * The test case is to search an item category wise (This is done in order to extensively make use of all
	 * Appium touch actions/gestures.). Also Exceptions are handled effectively.
	 *
	 * Steps:
	 * Login to the page
	 * Search for a category
	 * Select the sub category from it
	 * Select the item and purchase.
	 */
	@Test(priority = 0)
	public void EbayAppSearchByCategoryTestCase() {
		try {
			logger.info("Test Case Scenario1 [STARTED]-  SearchItemCategoryWise");
			loginTest();
			searchCategoryTest();
			subCategorySelect();
			purchaseItem();
			logger.info("Test Case Scenario1 [COMPLETED]-  SearchItemCategoryWise");
			logger.info("***********************");

		} catch (NoSuchElementException ex) {

			logger.info("NoSuchElementException Caught in TestCase!"
					+ ex.getClass());

		} catch (TimeoutException ex) {

			logger.info("TimeoutException Caught in TestCase!" + ex.getClass());
		} catch (IOException ex) {

			logger.info("IOException Caught for the TestCase!.."
					+ "Please check for valid input path!" + ex.getClass());
		}

	}



	/**
	 * Ebay app search by text input test case.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * The test case is to search an item by providing an input in the search text field.
	 */
	@Test(dependsOnMethods = { "EbayAppSearchByCategoryTestCase" })
	public void EbayAppSearchByTextInputTestCase() throws IOException {
		logger.info("Test Case Scenario2 [STARTED]-  SearchItemByTextInput");
		searchByTextAndPurchaseItem();
		logger.info("Test Case Scenario2 [COMPLETED]-  SearchItemByTextInput");
		logger.info("***********************");
	}


	/**
	 * Search by text.
	 */
	private void searchByTextAndPurchaseItem() {

		new SearchPage(driver).searchByText();
		new ItemPage(driver).purchaseItem();
		logger.info("Item Purchased - BySearch TextInput!!");
	}



	/**
	 * Login test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void loginTest() throws IOException  {

		WebElement stats = null;

		stats = new LoginPage(driver).login();

		if (stats != null)
			assertEquals(stats.getText(), "jayasrmanchar_0");
		logger.info("Page Logged in Successfully!!");

	}


		/**
		 * Search category test.
		 */
		public void searchCategoryTest() {

		PageUtils.previousPage();
		WebElement stats = new SearchPage(driver).searchByCategory();
		if(stats!=null)
		assertEquals(stats.getText(), "Mobile Accessories");
		logger.info("Category Selection completed..");
}

	/**
	 * Sub category select.
	 */
	public void subCategorySelect() {

		WebElement stats = new CategoryPage(driver).selectSubtegory();
		if(stats!=null)
		assertEquals(stats.getText(), "Mobile Gadgets");
		logger.info("SubCategory Selection  Completed..");

}

	/**
	 * Purchase item.
	 */
	public void purchaseItem() {

		new ItemPage(driver).selectItem();
		logger.info("Item Purchased - Category-wise.");


}

	/**
	 * Tear down.
	 */
	@AfterSuite
	public void tearDown() {

		this.driver.quit();


	}
}
