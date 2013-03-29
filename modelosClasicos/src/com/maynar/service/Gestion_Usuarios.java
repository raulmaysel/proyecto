package com.maynar.service;

import java.util.List;

import com.maynar.dao.UsuarioDAO;
import com.maynar.dao.UsuarioDAO;
import com.maynar.model.Usuario;

public class Gestion_Usuarios implements IGestion_Usuarios {

	private UsuarioDAO usu_DAO;
	
	

	public List<Usuario> consultarTodos() {
		return usu_DAO.findAll();
	}

	public Usuario consultarporNombre(String nombre){
		
		return usu_DAO.findById(nombre);
		
	}
	
	public boolean bajaUsuario(Usuario usuario) {
		usu_DAO.delete(usuario);
		return true;
	}

	public boolean altaUsuario(Usuario usuario) {
		usu_DAO.save(usuario);
		return false;
	}
	
	public boolean modificacionUsuario(Usuario usuario) {
		usu_DAO.attachDirty(usuario);
		return false;
	}
	
	public UsuarioDAO getUsu_DAO() {
		return usu_DAO;
	}

	public void setUsu_DAO(UsuarioDAO usu_DAO) {
		this.usu_DAO = usu_DAO;
	}

	

	

	
	
}
