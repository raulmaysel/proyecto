package com.maynar.model;

/**
 * Usuario entity. @author MyEclipse Persistence Tools
 */

public class Usuario implements java.io.Serializable {

	// Fields

	private String nombre;
	private String clave;

	// Constructors

	/** default constructor */
	public Usuario() {
	}

	/** minimal constructor */
	public Usuario(String nombre) {
		this.nombre = nombre;
	}

	/** full constructor */
	public Usuario(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	// Property accessors

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}