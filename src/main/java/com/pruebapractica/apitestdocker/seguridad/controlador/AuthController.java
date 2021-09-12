package com.pruebapractica.apitestdocker.seguridad.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapractica.apitestdocker.seguridad.exception.Authunauthorized;
import com.pruebapractica.apitestdocker.seguridad.servicio.AuthServiceImpl;
import com.pruebapractica.apitestdocker.seguridad.servicio.IAuthService;
import com.pruebapractica.apitestdocker.seguridad.validador.AuthValidator;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class AuthController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	IAuthService authService;
	
	@Autowired
	AuthValidator validador;
	
	@PostMapping(path = "/oauth/client_credential/accesstoken", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(
			@RequestBody MultiValueMap<String, String> paramMap,
			@RequestParam("grant_type") String grantType) throws Authunauthorized{
		
		String client_id = paramMap.getFirst("client_id");
		String client_secret = paramMap.getFirst("client_secret");
		
		//VALIDAR PARAMETROS
		validador.validate(paramMap, grantType);
		
		//AQUI SE DEBERIA VALIDAR SI EL USUARIO Y PASSWORD SON CORRECTOS
		if(client_id.equals("userTest") && client_secret.equalsIgnoreCase("test123")) {
			LOGGER.info("--->> El client_id y client_secret validados exitosamente, se procede a generar Token!." );
			return ResponseEntity.ok(authService.generateToken(client_id));
		}
		LOGGER.info("--->> El client_id/client_secret no son válidos!.");
		return ResponseEntity.ok("El client_id/client_secret no son válidos!.");
	}

}
