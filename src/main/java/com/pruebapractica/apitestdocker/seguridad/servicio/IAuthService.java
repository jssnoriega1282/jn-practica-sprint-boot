package com.pruebapractica.apitestdocker.seguridad.servicio;

import org.springframework.stereotype.Service;

import com.pruebapractica.apitestdocker.seguridad.dto.JwtResponse;

@Service
public interface IAuthService {
	
	JwtResponse generateToken(String clientId);

}
