package com.uptake.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentTest;

import com.uptake.common.Constants.Browser;

import com.uptake.common.SeleniumTestBase;
import com.uptake.pagefactory.HomePage;
import com.uptake.report.Report;

/**
 * @author rmurug3
 *
 */
public class BaseCase extends SeleniumTestBase {
	public static final Logger logger = Logger.getLogger(BaseCase.class);
	protected WebDriver driver;
	protected HomePage homePage;
	protected ExtentTest testLog;

	@DataProvider(name = "browsers")
	public static Object[][] browers() {
		return new Object[][] { { Browser.IE.getName() }, { Browser.CHROME.getName() } };
	}

	@BeforeTest
	public void beforeTest() {
		Report.createRepTemplate("src/test/resources/result");
	}

	public void init(WebDriver driver) {
		homePage = PageFactory.initElements(driver, HomePage.class);
		testLog = Report.getTestLog();
		setTestLog(testLog);

	}

	@AfterMethod
	public void afterMethod() {
		Report.endTest();
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	@AfterTest
	public void afterTest() {
		Report.flushReport();

	}

}
