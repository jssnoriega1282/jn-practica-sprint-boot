package com.pruebapractica.apitestdocker.estudiantes.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapractica.apitestdocker.estudiantes.dominio.Estudiante;
import com.pruebapractica.apitestdocker.estudiantes.dto.EstudianteDTO;
import com.pruebapractica.apitestdocker.estudiantes.servicio.IEstudianteService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/api/v1/estudiante/")
@CrossOrigin("*")
public class EstudianteRestController {
	
	@Autowired
	IEstudianteService estudianteService;
	
	@GetMapping(value = "/all", produces = "application/json")
	@ApiOperation(value = "all", notes = "Obtiene toda la lista de estudiantes del sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperación exitosa"),
            @ApiResponse(code = 404, message = "Not Found. No se encuentra el recurso solicitado"),
			@ApiResponse(code = 400, message = "Bad Request. El request solicitado tiene problemas sintácticos o semánticos, revisar el ejemplo Swagger provisto"),
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", dataType = "string", paramType = "header") })
	public List<EstudianteDTO> getAll() throws Exception {
		return estudianteService.getAll();
	}

	@GetMapping(value = "/find/{id}", produces = "application/json")
	@ApiOperation(value = "find", notes = "Obtiene un estudiante por su ID.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperación exitosa"),
            @ApiResponse(code = 404, message = "Not Found. No se encuentra el recurso solicitado"),
			@ApiResponse(code = 400, message = "Bad Request. El request solicitado tiene problemas sintácticos o semánticos, revisar el ejemplo Swagger provisto"),
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", dataType = "string", paramType = "header") })
	public EstudianteDTO find(@PathVariable(name = "id", required = true, value = "id") String id) throws Exception {
		return estudianteService.get(id);
	}
	
	@GetMapping(value = "/findByEdadAndEstado/{edad}/{estado}", produces = "application/json")
	@ApiOperation(value = "findByEdadAndEstado", notes = "Consulta los estudiantes por edad y estado.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperación exitosa"),
            @ApiResponse(code = 404, message = "Not Found. No se encuentra el recurso solicitado"),
			@ApiResponse(code = 400, message = "Bad Request. El request solicitado tiene problemas sintácticos o semánticos, revisar el ejemplo Swagger provisto"),
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", dataType = "string", paramType = "header") })
	public ResponseEntity<?> findByEdadAndEstado(
			@PathVariable(name = "edad", required = true, value = "edad") Integer edad, 
			@PathVariable(name = "estado", required = true, value = "estado") String estado) throws Exception {
		List<EstudianteDTO> listaEstudiantes = estudianteService.findByEdadAndEstado(edad, estado);
		return new ResponseEntity<List<EstudianteDTO>>(listaEstudiantes != null ? listaEstudiantes : new ArrayList<EstudianteDTO>(), HttpStatus.OK); 
	}
	
	@PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "save", notes = "Crea un nuevo estudiante en el sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperación exitosa"),
            @ApiResponse(code = 404, message = "Not Found. No se encuentra el recurso solicitado"),
			@ApiResponse(code = 400, message = "Bad Request. El request solicitado tiene problemas sintácticos o semánticos, revisar el ejemplo Swagger provisto"),
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", dataType = "string", paramType = "header") })
	public ResponseEntity<String> save(@RequestBody(required = true) Estudiante estudiante) throws Exception {
		if(estudiante.getEdad() >= 18) {
			return new ResponseEntity<String>("Solo se permiten estudiantes menores de 18 años", HttpStatus.OK);
		}
		estudiante.setEstado("Activo");
		return new ResponseEntity<String>(estudianteService.save(estudiante), HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}")
	@ApiOperation(value = "update", notes = "Actualiza un estudiante.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperación exitosa"),
            @ApiResponse(code = 404, message = "Not Found. No se encuentra el recurso solicitado"),
			@ApiResponse(code = 400, message = "Bad Request. El request solicitado tiene problemas sintácticos o semánticos, revisar el ejemplo Swagger provisto"),
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", dataType = "string", paramType = "header") })
	public ResponseEntity<String> update(@RequestBody(required = true) Estudiante estudiante, 
			@PathVariable(name = "id", required = true, value = "id") String id) throws Exception {
		if(estudiante.getEdad() >= 18) {
			return new ResponseEntity<String>("Solo se permiten estudiantes menores de 18 años", HttpStatus.OK);
		}	
		return new ResponseEntity<String>(estudianteService.save(estudiante, id), HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	@ApiOperation(value = "delete", notes = "Elimina un estudiante del sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperación exitosa"),
            @ApiResponse(code = 404, message = "Not Found. No se encuentra el recurso solicitado"),
			@ApiResponse(code = 400, message = "Bad Request. El request solicitado tiene problemas sintácticos o semánticos, revisar el ejemplo Swagger provisto"),
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", dataType = "string", paramType = "header") })
	public ResponseEntity<EstudianteDTO> delete(@PathVariable(name = "id", required = true, value = "id") String id) throws Exception {
		Estudiante estudiante = estudianteService.getEntity(id);
		if (estudiante != null) {
			estudiante.setEstado("Inactivo");
			estudianteService.save(estudiante, id);
		} else {
			return new ResponseEntity<EstudianteDTO>(HttpStatus.NO_CONTENT);
		}
		EstudianteDTO estudianteDTO = estudianteService.get(id);
		return new ResponseEntity<EstudianteDTO>(estudianteDTO, HttpStatus.OK);
	}

}
