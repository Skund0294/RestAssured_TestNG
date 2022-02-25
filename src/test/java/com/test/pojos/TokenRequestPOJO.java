package com.test.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TokenRequestPOJO {
	
	@JsonProperty
	private String username;
	@JsonProperty
	private String password;

}