package com.pruebapractica.apitestdocker.seguridad.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.pruebapractica.apitestdocker.seguridad.dto.JwtResponse;
import com.pruebapractica.apitestdocker.seguridad.infraestructura.JwtIO;
import com.pruebapractica.apitestdocker.util.DateUtils;

@Component
public class AuthServiceImpl implements IAuthService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Autowired
	private JwtIO jwtIO;
	
	@Autowired
	private DateUtils dateUtils;
	
	@Value("${jms.jwt.token.expires-in}")
	private int EXPIRES_IN;

	@Override
	public JwtResponse generateToken(String clientId) {
		JwtResponse jwt = new JwtResponse();
		jwt.setToken_type("bearer");
		jwt.setAccess_token(jwtIO.generateToken(clientId));
		jwt.setIssued_at(dateUtils.getDateMillis() + "");
		jwt.setClient_id(clientId);
		jwt.setExpires_in(EXPIRES_IN);
		return jwt;
	}

}
