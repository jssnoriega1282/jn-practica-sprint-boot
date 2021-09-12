package com.pruebapractica.apitestdocker.estudiantes.dto;

import java.util.List;

public class EstudianteDTO {
	
	private String id;
	private String nombre;
	private String identificacion;
	private String email;
	private Integer edad;
	private String estado;
	private List<AcudienteDTO> acudientes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<AcudienteDTO> getAcudientes() {
		return acudientes;
	}
	public void setAcudientes(List<AcudienteDTO> acudientes) {
		this.acudientes = acudientes;
	}
	
	

}
