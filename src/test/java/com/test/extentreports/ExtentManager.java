package com.test.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tests.utilities.RandomUtils;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			createInstance();

		}

		return extent;
	}

	public static ExtentReports createInstance() {

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(
				"./ExtentReports/TestReport_" + RandomUtils.createRandomDateTimeValue());
		sparkreporter.config().setDocumentTitle("API Automation Report");
		sparkreporter.config().setReportName("Restful Booker APIs Report");
		sparkreporter.config().setEncoding("utf-8");
		sparkreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Automation Tester", "QATester_01");
		extent.setSystemInfo("Environment", "PRE-PROD");
		extent.setSystemInfo("Architecture", "RESTFul");
		return extent;

	}
	
}