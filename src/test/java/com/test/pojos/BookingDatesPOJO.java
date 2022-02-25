package com.test.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookingDatesPOJO {

	@JsonProperty
	private String checkin;
	@JsonProperty
	private String checkout;

}