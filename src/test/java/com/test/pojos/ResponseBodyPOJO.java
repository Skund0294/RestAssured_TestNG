package com.test.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseBodyPOJO {

	@JsonProperty
	private int bookingid;
	@JsonProperty
	private BookingDataPOJO booking;

}