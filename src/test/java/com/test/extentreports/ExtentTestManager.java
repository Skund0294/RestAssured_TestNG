package com.test.extentreports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestManager {

	public static ExtentTest test;

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();

	public static synchronized ExtentTest getTest() {

		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));

	}

	public static synchronized void endTest() {

		extent.flush();

	}

	public static synchronized ExtentTest startTest(String testName) {

		test = extent.createTest(testName.toUpperCase());
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;

	}

	public static void logMessageInReport(String message) {

		test.log(Status.INFO, message);

	}

}