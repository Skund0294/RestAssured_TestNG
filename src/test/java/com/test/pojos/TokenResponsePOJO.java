package com.test.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TokenResponsePOJO {
	
	@JsonProperty
	private String token;

}