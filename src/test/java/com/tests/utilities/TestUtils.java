package com.tests.utilities;

import org.testng.Assert;

import com.test.pojos.ResponseBodyPOJO;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestUtils {

	private static ResponseBodyPOJO responsebody;

	public static void assertResponseStatusCode(Response response, int expectedStatusCode) {

		Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
				"Incorrect status code obtained in response.");

	}

	public static int getResponseStatusCode(Response response) {

		return (response.getStatusCode());

	}

	public static long getRequestTimeTaken(Response response) {

		return (response.getTime());

	}

	public static void logResponseStatusCode(Response response) {

		System.out.println(response.getStatusCode());

	}

	public static void logRequestTimeTaken(Response response) {

		System.out.println(response.getTime());

	}

	public static void logCompleteResponse(Response response) {

		response.then().log().all();

	}

	public static long logResponseTime(Response response) {

		return (response.getTime());

	}

	public static void logResponseBody(Response response) {

		System.out.println(response.asPrettyString());

	}

	public static String fetchHeaderValue(Response response, String headername) {

		Headers headers = response.headers();
		return (headers.getValue(headername));

	}

	public static int extractValueFromResponseBody(Response response, String key) {

		responsebody = response.as(ResponseBodyPOJO.class);

		int result = 0;

		if (key.equals("bookingid")) {
			result = responsebody.getBookingid();
		}

		return result;

	}

	public static String extractNestedValueFromResponseBody(Response response, String key) {

		responsebody = response.as(ResponseBodyPOJO.class);

		String result = null;

		if (key.equals("firstname")) {
			result = responsebody.getBooking().getFirstname();
		} else if (key.equals("lastname")) {
			result = responsebody.getBooking().getLastname();
		} else if (key.equals("totalprice")) {
			result = String.valueOf(responsebody.getBooking().getTotalprice());
		} else if (key.equals("additionalneeds")) {
			result = responsebody.getBooking().getAdditionalneeds();
		} else if (key.equals("depositpaid")) {
			result = String.valueOf(responsebody.getBooking().isDepositpaid());
		} else if (key.equals("checkin")) {
			result = responsebody.getBooking().getBookingdates().getCheckin();
		} else if (key.equals("checkout")) {
			result = responsebody.getBooking().getBookingdates().getCheckout();
		}

		return result;

	}

}