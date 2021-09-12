package com.pruebapractica.apitestdocker.seguridad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Authunauthorized extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3259808911612406534L;
	
	public Authunauthorized(String message) {
		super(message);
	}

}
