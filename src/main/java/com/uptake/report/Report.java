package com.uptake.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Report {

	private static ExtentReports report;
	private static ExtentTest testLog;

	public static ExtentTest getTestLog() {
		return testLog;
	}

	private static void setTestLog(ExtentTest testLog) {
		Report.testLog = testLog;
	}

	/**
	 * Create a report template on the specified path
	 * 
	 * @param filePath
	 *            FilePath
	 */
	public static void createRepTemplate(String filePath) {
		report = new ExtentReports(filePath + "/ExecutionReport.html", true);
		report.addSystemInfo("User", "Raghul");
	}

	/**
	 * Create a report based on test case name
	 * 
	 * @param testName
	 *            actual test case name
	 */
	public static void createReport(String testName) {

		testLog = report.startTest(testName);
		setTestLog(testLog);
	}

	/**
	 * End the report after the test
	 */
	public static void endTest() {
		report.endTest(testLog);
	}

	/**
	 * Flush the report
	 */
	public static void flushReport() {

		if (report != null) {
			report.flush();
		}
	}

}
