package com.test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.test.extentreports.ExtentManager;
import com.test.extentreports.ExtentTestManager;

public class TestListener implements ITestListener {

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {

		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		String logtext = "<b>" + methodname.toUpperCase() + " - PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		ExtentTestManager.test.pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		String logtext = "<b>" + methodname.toUpperCase() + " - FAILED" + "</b>";
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.RED);
		ExtentTestManager.test.fail(m);
	}

	public void onTestSkipped(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		String logtext = "<b>" + methodname.toUpperCase() + " - SKIPPED" + "</b>";
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.AMBER);
		ExtentTestManager.test.skip(m);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}