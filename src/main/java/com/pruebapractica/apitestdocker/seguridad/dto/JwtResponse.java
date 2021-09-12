package com.pruebapractica.apitestdocker.seguridad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class JwtResponse {
	
	//@JsonProperty(value = "token_type")
	private String token_type;
	
	//@JsonProperty(value = "access_token")
	private String access_token;
	
	//@JsonProperty(value = "expires_in")
	private int expires_in;
	
	//@JsonProperty(value = "issued_at")
	private String issued_at;
	
	//@JsonProperty(value = "client_id")
	private String client_id;

	public JwtResponse() {
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getIssued_at() {
		return issued_at;
	}

	public void setIssued_at(String issued_at) {
		this.issued_at = issued_at;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

}
