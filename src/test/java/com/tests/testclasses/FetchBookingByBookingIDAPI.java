package com.tests.testclasses;

import org.testng.annotations.Test;

import com.test.extentreports.ExtentTestManager;
import com.tests.utilities.BaseTest;
import com.tests.utilities.Constants;
import com.tests.utilities.TestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchBookingByBookingIDAPI extends BaseTest {

	private Response response;

	@Test
	public void fetch_Booking_By_Booking_ID_API_Test01() {

		int bookingtoretrieve = NewBookingAPI.newbookingid;
		
		ExtentTestManager.logMessageInReport("BOOKING TO RETRIEVE : " + bookingtoretrieve);

		response = RestAssured.given().spec(reqspecification).basePath(Constants.FETCH_BY_ID_END_POINT)
				.pathParam("id", bookingtoretrieve).when().get();

	}

	@Test
	public void fetch_Booking_By_Booking_ID_API_Test02() {

		ExtentTestManager.logMessageInReport("DETAILS RETRIEVED : " + response.asPrettyString());
		ExtentTestManager.logMessageInReport("STATUS CODE : " + String.valueOf(TestUtils.getResponseStatusCode(response)));
		ExtentTestManager.logMessageInReport("TIME TAKEN : " + String.valueOf(TestUtils.getRequestTimeTaken(response)));
		TestUtils.assertResponseStatusCode(response, 301);

	}

}