package com.tests.testclasses;

import org.testng.annotations.Test;

import com.test.extentreports.ExtentTestManager;
import com.tests.utilities.BaseTest;
import com.tests.utilities.Constants;
import com.tests.utilities.CreateAuthToken;
import com.tests.utilities.TestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteBookingAPI extends BaseTest {

	private Response response;
	
	@Test
	public void delete_Booking_API_Test01() {

		String authtoken = CreateAuthToken.createAuthToken();
		int bookingtodelete = NewBookingAPI.newbookingid;
		
		ExtentTestManager.logMessageInReport("BOOKING TO DELETE : " + bookingtodelete);
		
		response = RestAssured.given().spec(reqspecification).basePath(Constants.DELETE_END_POINT)
				.pathParam("id", bookingtodelete).header("Cookie", "token=" + authtoken).when().delete();

	}
	
	@Test
	public void delete_Booking_API_Test02() {

		ExtentTestManager.logMessageInReport("STATUS CODE : " + String.valueOf(TestUtils.getResponseStatusCode(response)));
		ExtentTestManager.logMessageInReport("TIME TAKEN : " + String.valueOf(TestUtils.getRequestTimeTaken(response)));

	}
	
}