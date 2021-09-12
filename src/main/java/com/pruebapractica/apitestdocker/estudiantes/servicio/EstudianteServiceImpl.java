package com.pruebapractica.apitestdocker.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.pruebapractica.apitestdocker.comunes.GenericServiceImpl;
import com.pruebapractica.apitestdocker.estudiantes.dominio.Estudiante;
import com.pruebapractica.apitestdocker.estudiantes.dto.EstudianteDTO;

@Component
public class EstudianteServiceImpl extends GenericServiceImpl<Estudiante, EstudianteDTO> implements IEstudianteService {
	
	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {
		return firestore.collection("estudiantes");
	}

}
