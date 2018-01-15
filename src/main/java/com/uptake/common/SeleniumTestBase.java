package com.uptake.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.uptake.common.Constants.Action;

/**
 * @author rmurug3
 *
 */
public class SeleniumTestBase {

	private static final Logger logger = Logger.getLogger(SeleniumTestBase.class);

	private static ExtentTest testLog;

	public void setTestLog(ExtentTest testLog) {
		SeleniumTestBase.testLog = testLog;
	}

	/**
	 * Method to Click on the web element
	 * 
	 * @param element
	 *            WebElement
	 */
	public void click(WebElement element) {

		try {
			String text = element.getText();
			element.click();
			logger.info(text + "  Element Clicked Successfully");
			testLog.log(LogStatus.INFO, text + "  Element Clicked Successfully");
		} catch (WebDriverException e) {
			logger.error("Element Not Found  " + e.getMessage());
			testLog.log(LogStatus.FAIL, "Element Not Found  " + e.getMessage());
		}

	}

	/**
	 * Method to mouse over to web element
	 * 
	 * @param driver
	 *            Driver Instance
	 * @param toElement
	 *            WebElement
	 */
	public void moveToElement(WebDriver driver, WebElement toElement) {
		try {
			String text = toElement.getText();

			Actions action = new Actions(driver);
			action.moveToElement(toElement).build().perform();

			logger.info("Mouse over to element " + text + " completed");
			testLog.log(LogStatus.INFO, "Mouse over to element " + text + " completed");
		} catch (WebDriverException e) {
			logger.error("WebDriver Exception  " + e.getMessage());
			testLog.log(LogStatus.FAIL, "WebDriver Exception  " + e.getMessage());
		}
	}

	public void webDriverWait(WebDriver driver, WebElement element, Action action) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
			if (driver == null) {
				throw new NullPointerException("Driver is null");
			}
			switch (action) {
			case CLICKABLE:
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			case VISIBILITY:
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			default:
				logger.warn("Check the action");
			}
		} catch (NullPointerException e) {
			logger.error("Driver can't be null  " + e.getMessage());
			testLog.log(LogStatus.FAIL, "Driver can't be null  " + e.getMessage());
		} catch (TimeoutException e) {
			logger.error("Maximum time reached " + e.getMessage());
		}

	}

}
