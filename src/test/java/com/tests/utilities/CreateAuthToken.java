package com.tests.utilities;

import com.test.pojos.TokenRequestPOJO;
import com.test.pojos.TokenResponsePOJO;

import io.restassured.RestAssured;

public class CreateAuthToken extends BaseTest {

	public static String createAuthToken() {

		TokenRequestPOJO tokenrequest = new TokenRequestPOJO();
		tokenrequest.setUsername(PropertyFileReader.readPropertyFile("username"));
		tokenrequest.setPassword(PropertyFileReader.readPropertyFile("password"));

		TokenResponsePOJO tokenresponse = new TokenResponsePOJO();
		
		tokenresponse = RestAssured.given().spec(reqspecification).basePath(Constants.AUTH_URL_ENDPOINT).when()
				.body(tokenrequest).post().as(TokenResponsePOJO.class);
		String authtoken = tokenresponse.getToken();
		return authtoken;

	}
}