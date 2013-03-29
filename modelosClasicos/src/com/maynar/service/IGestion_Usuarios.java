package com.maynar.service;

import java.util.List;

import com.maynar.model.Usuario;

public interface IGestion_Usuarios {
	
	
	public Usuario consultarporNombre(String nombre);
	public boolean bajaUsuario(Usuario usuario);
	public boolean altaUsuario(Usuario usuario);
	public boolean modificacionUsuario(Usuario usuario);
	public List<Usuario> consultarTodos();

}
