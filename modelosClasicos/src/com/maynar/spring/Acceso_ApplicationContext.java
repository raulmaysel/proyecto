package com.maynar.spring;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class Acceso_ApplicationContext implements ApplicationContextAware {

	private static WebApplicationContext ctx;

	/**
	 * Recibimos de forma automatica (al crearse el applicationcontext) cuando
	 * se crea el bean.<br/>
	 * Al incorporar la interface ese comportamiento se realiza el paso 4/5 del
	 * ciclo de vida de los bean.
	 * 
	 * */
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		Acceso_ApplicationContext.ctx = (WebApplicationContext) ctx;
	}

	/**
	 * Nos permite acceder al WebapplicationContext directamente en cualquier
	 * clase de aplicacion.
	 * 
	 * @return
	 */
	public static WebApplicationContext getContextoSpring() {
		return ctx;
	}

	/**
	 * Proceso de conveniencia para la obtencion directa del bean.
	 * 
	 * @param objeto
	 *            Id o nombre del objeto que spring tiene que pasar.
	 * @return Objeto creado por spring.
	 */
	public static Object getBean(String objeto) {
		return ctx.getBean(objeto);
	}

	/**
	 * Nos permite acceder al servletcontext en cualquier clase de la aplicacion
	 * de forma estatica.
	 * 
	 * @return
	 */
	public static ServletContext getServletContext() {
		ServletContext servletContext = ctx.getServletContext();
		return servletContext;
	}

}
