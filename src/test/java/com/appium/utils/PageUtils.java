package com.appium.utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// TODO: Auto-generated Javadoc
/**
 * The Class PageUtils.
 */
public class PageUtils  {

	/** The test page. */
	protected MobileUtils testPage;

	/** The driver. */
	protected static AndroidDriver driver;

	/**
	 * Instantiates a new page utils.
	 *
	 * @param driver the driver
	 */
	public PageUtils(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 testPage =  new MobileUtils();
	}

	 /**
 	 * Wait until visible.
 	 *
 	 * @param element the element
 	 * The method checks waits until 30 seconds for the provided web element to be visible.
 	 */
 	protected void waitUntilVisible(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));

		}

	 /**
 	 * Wait until visible.
 	 *
 	 * @param locator the locator
 	 * The method checks waits until 30 seconds for the provided web element By locator to be visible.
 	 */
 	protected void waitUntilVisible(By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	 /**
 	 * Element exists.
 	 *
 	 * @param element the element
 	 * @return true, if successful
 	 * The method checks if the element exists, returns true if displayed , else false.
 	 */
 	protected boolean elementExists(WebElement element){
		 try{

			 if(element.isDisplayed())
				 return true;
		 }
		 catch(NoSuchElementException ex){
			 return false;
		 }
		return false;
	 }

	 /**
 	 * Scroll to element.
 	 *
 	 * @param resource the resource
 	 * @param element the element
 	 * @return the mobile element
 	 *
 	 * The method executes the Appium vertical scroll function within the container until the element is found.
 	 */
 	protected MobileElement scrollToElement(String resource,String element) {

		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		MobileElement selectedCategory =(MobileElement) driver.findElement(MobileBy.AndroidUIAutomator
				("new UiScrollable(new UiSelector().resourceId("+resource+")).scrollIntoView(new UiSelector().text("+element+"))"));


		return selectedCategory;


		}

 	/**
 	 * Find element by text.
 	 *
 	 * @param text the text
 	 * @return the mobile element
 	 * The method finds the mobile element using the text parameter of the xml.
 	 */
 	protected MobileElement findElementByText(String text){
			return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text("+text+")"));


		}

	 /**
 	 * Previous page.
 	 * Navigates to previous page.
 	 */
 	public static void previousPage() {

			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);


		}

 	/**
 	 * Swipe.
 	 *
 	 * @param element the element
 	 * The method executes Horizontal wipe functionality with the X and Y co-ordinates of the screen resoulution.
 	 * Also effectively works when rotated.
 	 */
 	protected void swipe(WebElement element){
			Point point = element.getLocation(); // topCharts - first element present in the scroll list
			int startY = point.y;
			int endY = point.y;

			int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.80);
			int endX = (int) ((driver.manage().window().getSize().getWidth()) * 0.10);

			TouchAction actions = new TouchAction(driver);

			actions.press(startX, startY).waitAction(Duration.ofSeconds(2)).moveTo(endX, endY).release().perform();


	 }

}
