package com.uptake.test;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.uptake.common.Constants.Action;
import com.uptake.common.DriverInitialization;
import com.uptake.report.Report;

/**
 * @author rmurug3
 *
 */
public class HomePageTest extends BaseCase {

	@Test(dataProvider = "browsers")
	public void homePageTest(String browserName) {
		try {
			Report.createReport("Homepage Validation_" + browserName);

			driver = DriverInitialization.launchDriver(browserName);
			driver.get("https://www.uptake.com");

			init(driver);

			testLog.log(LogStatus.INFO, "Title of the Homepage : " + driver.getTitle());
			logger.info("Title of the Homepage : " + driver.getTitle());

			click(homePage.products);
			webDriverWait(driver, homePage.industries, Action.CLICKABLE);
			moveToElement(driver, homePage.industries);

			click(homePage.aviation);
			Thread.sleep(3000);

			Assert.assertEquals(driver.getTitle(), "Industrial Analytics for Aviation | Uptake");
			testLog.log(LogStatus.INFO, "Page Load Successfully");
			testLog.log(LogStatus.PASS, "Homepage Validation_" + browserName + " Test Case Passed");
		} catch (InterruptedException e) {

			logger.error("Interrupted Exception  " + e.getMessage());
			testLog.log(LogStatus.FAIL, "Test Case Falied");
		} catch (NoSuchElementException e) {
			logger.error("Element Not Found  " + e.getMessage());
			testLog.log(LogStatus.FAIL, "Test Case Falied");
		} catch (AssertionError e) {
			logger.error("Assertion Error  " + e.getMessage());
			testLog.log(LogStatus.FAIL, "Test Case Falied  :  " + e.getMessage());
		}
	}
}
