package com.pruebapractica.apitestdocker.estudiantes.dominio;

import java.util.List;

public class Estudiante {
	
	private String nombre;
	private String identificacion;
	private String email;
	private Integer edad;
	private String estado;
	private List<Acudiente> acudientes;
	
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
	public List<Acudiente> getAcudientes() {
		return acudientes;
	}
	public void setAcudientes(List<Acudiente> acudientes) {
		this.acudientes = acudientes;
	}
	
	

}
