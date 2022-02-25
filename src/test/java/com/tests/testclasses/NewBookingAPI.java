package com.tests.testclasses;

import org.testng.annotations.Test;

import com.test.extentreports.ExtentTestManager;
import com.test.pojos.BookingDataPOJO;
import com.test.pojos.BookingDatesPOJO;
import com.tests.utilities.BaseTest;
import com.tests.utilities.Constants;
import com.tests.utilities.RandomUtils;
import com.tests.utilities.TestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewBookingAPI extends BaseTest {

	public static int newbookingid = 0;
	private Response response;

	@Test
	public void new_Booking_API_Test01() {

		BookingDatesPOJO datesdata = new BookingDatesPOJO();
		datesdata.setCheckin(RandomUtils.generateDate(5));
		datesdata.setCheckout(RandomUtils.generateDate(10));

		BookingDataPOJO booking = new BookingDataPOJO();
		booking.setFirstname(RandomUtils.generateRandomString(6));
		booking.setLastname(RandomUtils.generateRandomString(6));
		booking.setTotalprice(RandomUtils.generateRandomNumber(4));
		booking.setDepositpaid(Constants.DEPOSITPAID_FALSE);
		booking.setAdditionalneeds(Constants.ADDITIONAL_NEEDS);
		booking.setBookingdates(datesdata);

		response = RestAssured.given().spec(reqspecification).basePath(Constants.CREATE_END_POINT).body(booking).when()
				.post();

		newbookingid = TestUtils.extractValueFromResponseBody(response, "bookingid");

		ExtentTestManager.logMessageInReport("NEW BOOKING CREATED WITH ID : "
				+ String.valueOf(TestUtils.extractValueFromResponseBody(response, "bookingid")));

	}

	@Test
	public void new_Booking_API_Test02() {

		ExtentTestManager.logMessageInReport(
				"BOOKING ID : " + String.valueOf(TestUtils.extractValueFromResponseBody(response, "bookingid")));
		ExtentTestManager.logMessageInReport(
				"FIRSTNAME : " + TestUtils.extractNestedValueFromResponseBody(response, "firstname"));
		ExtentTestManager
				.logMessageInReport("LASTNAME : " + TestUtils.extractNestedValueFromResponseBody(response, "lastname"));
		ExtentTestManager.logMessageInReport(
				"TOTAL PRICE : " + TestUtils.extractNestedValueFromResponseBody(response, "totalprice"));
		ExtentTestManager.logMessageInReport(
				"ADDITIONAL NEEDS : " + TestUtils.extractNestedValueFromResponseBody(response, "additionalneeds"));
		ExtentTestManager.logMessageInReport(
				"DEPOSIT PAID : " + TestUtils.extractNestedValueFromResponseBody(response, "depositpaid"));
		ExtentTestManager.logMessageInReport(
				"CHECKIN ON : " + TestUtils.extractNestedValueFromResponseBody(response, "checkin"));
		ExtentTestManager.logMessageInReport(
				"CHECKOUT ON : " + TestUtils.extractNestedValueFromResponseBody(response, "checkout"));
		ExtentTestManager
				.logMessageInReport("STATUS CODE : " + String.valueOf(TestUtils.getResponseStatusCode(response)));
		ExtentTestManager.logMessageInReport("TIME TAKEN : " + String.valueOf(TestUtils.getRequestTimeTaken(response)));

	}

}