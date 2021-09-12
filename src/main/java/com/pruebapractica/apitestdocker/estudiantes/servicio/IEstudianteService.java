package com.pruebapractica.apitestdocker.estudiantes.servicio;

import org.springframework.stereotype.Service;

import com.pruebapractica.apitestdocker.comunes.GenericServiceAPI;
import com.pruebapractica.apitestdocker.estudiantes.dominio.Estudiante;
import com.pruebapractica.apitestdocker.estudiantes.dto.EstudianteDTO;

@Service
public interface IEstudianteService extends GenericServiceAPI<Estudiante, EstudianteDTO> {

}
