package com.maynar.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Utilidad para el acceso a los distintos contextos necesarios dentro de la
 * aplicacion. Aprovecha el echo de que los accesos a los mismo son todos
 * objetos estaticos y los expone de la misma forma estatica.
 * 
 * @author profesor Juan Antonio Solves Garcia
 * @since 29-9-2011 1.0
 */
public class Accesos_Contextos {

	/**
	 * Metodo de conveniencia para la inclusion de mensajes en los managedbean
	 * sin tener que llamar todo el rato al facescontext.
	 * 
	 * @param mensaje
	 * @param identificador
	 */
	public static void addMensaje(String mensaje_sumario,
			String mensaje_detalle, FacesMessage.Severity nivel,
			String identificador) {
		FacesContext.getCurrentInstance().addMessage(identificador,
				new FacesMessage(nivel, mensaje_sumario, mensaje_detalle));
	}

	/**
	 * Devuelve la sesion si existe. De no existir no devuelve nada, no crea una
	 * nueva
	 * 
	 * @return Sesion en curso. (HTTPSESSION)
	 */
	public static HttpSession getSesion() {
		HttpSession salida = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return salida;
	}

	/**
	 * Devuelve la peticion de en curso.
	 * 
	 * @return Peticion en curso. (HTTPSERVLETREQUEST)
	 */
	public static HttpServletRequest getPeticion() {
		HttpServletRequest peticion = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return peticion;
	}

	/**
	 * Devuelve el contexto de aplicacion correspondiente.
	 * 
	 * @return Contexto de aplicion JEE. (SERVLETCONTEXT).
	 */
	public static ServletContext getAplicacion() {
		ServletContext aplicacion = ((HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(false))
				.getServletContext();
		return aplicacion;
	}

	/**
	 * Devuelve la respuesta de en curso.
	 * 
	 * @return Respuesta en curso. (HTTPSERVLETRESPONSE)
	 */
	public static HttpServletResponse getRespuesta() {

		HttpServletResponse respuesta = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		return respuesta;
	}

	/**
	 * Devuelve el applicationContext de spring para su uso.
	 * 
	 * @return ApplicationContext de spring. (APPLICATIONCONTEXT)
	 */
	public static ApplicationContext getApplication_Context() {
		ApplicationContext application = WebApplicationContextUtils
				.getWebApplicationContext(Accesos_Contextos.getAplicacion());
		return application;
	}

}
