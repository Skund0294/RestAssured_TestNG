package com.tests.testclasses;

import org.testng.annotations.Test;

import com.test.extentreports.ExtentTestManager;
import com.test.pojos.ResponseBodyPOJO;
import com.tests.utilities.BaseTest;
import com.tests.utilities.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllExistingBookingsAPI extends BaseTest {

	@Test
	public void fetch_All_Existing_Booking_IDs_API_Test01() {

		Response response = RestAssured.given().spec(reqspecification).basePath(Constants.FETCH_ALL_END_POINT).when().get();

		int bookingidtocheckinresponse = NewBookingAPI.newbookingid;
		int counter = 0;

		ResponseBodyPOJO[] responsebodypojo = response.as(ResponseBodyPOJO[].class);

		for (ResponseBodyPOJO id : responsebodypojo) {

			if (id.getBookingid() == bookingidtocheckinresponse) {
				counter++;
			}

		}

		if (counter > 0) {

			ExtentTestManager.logMessageInReport("Booking exists in the response body.");

		} else {

			ExtentTestManager.logMessageInReport("Booking does not exist in the response body.");

		}

	}

}