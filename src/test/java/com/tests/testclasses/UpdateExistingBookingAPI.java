package com.tests.testclasses;

import org.testng.annotations.Test;

import com.test.extentreports.ExtentTestManager;
import com.test.pojos.BookingDataPOJO;
import com.test.pojos.BookingDatesPOJO;
import com.tests.utilities.BaseTest;
import com.tests.utilities.Constants;
import com.tests.utilities.CreateAuthToken;
import com.tests.utilities.RandomUtils;
import com.tests.utilities.TestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateExistingBookingAPI extends BaseTest {

	private Response response;

	@Test
	public void update_Existing_Booking_API_Test01() {

		String authtoken = CreateAuthToken.createAuthToken();
		int bookingtoupdate = NewBookingAPI.newbookingid;

		ExtentTestManager.logMessageInReport("BOOKING UPDATED : " + bookingtoupdate);
		
		BookingDatesPOJO datesdata = new BookingDatesPOJO();
		datesdata.setCheckin(RandomUtils.generateDate(6));
		datesdata.setCheckout(RandomUtils.generateDate(20));

		BookingDataPOJO booking = new BookingDataPOJO();
		booking.setFirstname(RandomUtils.generateRandomString(3));
		booking.setLastname(RandomUtils.generateRandomString(5));
		booking.setTotalprice(RandomUtils.generateRandomNumber(3));
		booking.setDepositpaid(Constants.DEPOSITPAID_TRUE);
		booking.setAdditionalneeds(Constants.ADDITIONAL_NEEDS);
		booking.setBookingdates(datesdata);

		response = RestAssured.given().spec(reqspecification).basePath(Constants.UPDATE_END_POINT)
				.pathParam("id", bookingtoupdate).header("Cookie", "token=" + authtoken).body(booking).when().put();

	}

	@Test
	public void update_Existing_Booking_API_Test02() {

		ExtentTestManager.logMessageInReport("FIRSTNAME : " + response.jsonPath().get("firstname"));
		ExtentTestManager.logMessageInReport("LASTNAME : " + response.jsonPath().get("lastname"));
		ExtentTestManager.logMessageInReport("TOTAL PRICE : " + response.jsonPath().get("totalprice"));
		ExtentTestManager.logMessageInReport("ADDITIONAL NEEDS : " + response.jsonPath().get("additionalneeds"));
		ExtentTestManager.logMessageInReport("DEPOSIT PAID : " + response.jsonPath().get("depositpaid"));
		ExtentTestManager.logMessageInReport("CHECKIN ON : " + response.jsonPath().get("bookingdates.checkin"));
		ExtentTestManager.logMessageInReport("CHECKOUT ON : " + response.jsonPath().get("bookingdates.checkout"));
		ExtentTestManager.logMessageInReport("STATUS CODE : " + String.valueOf(TestUtils.getResponseStatusCode(response)));
		ExtentTestManager.logMessageInReport("TIME TAKEN : " + String.valueOf(TestUtils.getRequestTimeTaken(response)));

	}

}