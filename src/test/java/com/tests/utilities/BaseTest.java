package com.tests.utilities;

import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	protected static RequestSpecBuilder reqbuilder;
	protected static RequestSpecification reqspecification;

	@BeforeSuite
	public void setBaseURIAndAuthToken() {

		reqbuilder = new RequestSpecBuilder();
		reqbuilder.setBaseUri(Constants.BASE_URI).setContentType(Constants.CONTENT_TYPE);
		reqspecification = reqbuilder.build();

	}

}