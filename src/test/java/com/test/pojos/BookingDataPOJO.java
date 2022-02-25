package com.test.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookingDataPOJO {

	@JsonProperty
	private String firstname;
	@JsonProperty
	private String lastname;
	@JsonProperty
	private int totalprice;
	@JsonProperty
	private boolean depositpaid;
	@JsonProperty
	private String additionalneeds;
	@JsonProperty
	private BookingDatesPOJO bookingdates;

}