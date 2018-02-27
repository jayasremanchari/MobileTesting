# eBay Mobile Testing with Appium

This is an Appium Project to test the given Android apk of 'eBay App' for the Scenario - "Login to Ebay Mobile Application,search
for an item,add to cart and purchase it"

Test Coverage :
1 : SearchItemCategoryWise
2 : SearchItemByTextInput

This application works in Page Object Model fashion  and effectively makes use of the below Appium Functions to test the above scenarios

1.Click()
2.WebDriverWait()
3.isDisplayed()
4.implicitlyWait()
5.findElement()
6.AndroidUIAutomator()
7.UiScrollable()
8.UiSelector()
9.scrollIntoView()
10.TouchAction()


### Prerequisites

	* Android SDK
	* Android SDK Tools
	* Node JS
	* Eclipse (Any version)
	* Maven 3 or above
	* Java 7 or above
	* Appium Server version 1.7.2
	* Appium Doctor - (To Verify if the above softwares are installed properly and check the env path variables)
	* Selenium, TestNG, Surefire and Appium Java Client dependencies  to be added in pom.xml

### Installing

Install the above prerequisites
Clone the code from the repo and import it as an eclipse project

## Configurations

1. Enable Developer options in your android Device with USB debugging enabled.
2. Change the configuration under resource/package/scenarios folder scenario.xml according to your Android Device.
Note: To know your device name you need to run the ADB devices command in command prompt.
3. Change the user name and password  resource/testdata TestData.xlsx and provide the login details for ebay app.

## Running the Tests

Option 1

If you have testNG Plugin installed in your eclipse . scenario.xml > Right Click > run as TestNG

Option 2

Go to Project root folder and invoke the command : mvn test



### Test Case Scenarios



####SearchItemCategoryWise
The test case is to search an item category wise .
This is done in order to extensively make use of all Appium touch actions/gestures.

1.The test case first logs into the mobile app with a valid credentials and selects the Category "Mobile Accessories" through vertical Scroll.
2.Under the selected category , the test case selects a sub category "Mobile Gadgets" and "Smart Wrist Watch" under the sub category.
3.From the list of result items the first one is selected.
4.Following this the item image is swiped using Horizontal Swipe and purchased by clicking "Buy it Now" Option.


####SearchItemByTextInput

This Test case is to search and purchase an item with a search input provided in the search text box provided in the home page.

1.The Test case first navigates to the home navigator and selects the home button.
2.The item to be searched is the entered in the text box field on the page as "Smart Wrist Watch"
3.From the list of result items the first one is selected.
4.Following this the item is purchased by clicking on the "Buy It Now" Option Present.



## Test Results

To view the Test results please Browse to the below paths

###Report
1.test-output/index.html
2.test-output/emailable-report
3.test-output/TestNgParametersSuite/EbayAppTest

###Screenshots : src/test/resources/output/screenshots/*





