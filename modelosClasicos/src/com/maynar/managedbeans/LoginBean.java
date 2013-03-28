package com.maynar.managedbeans;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

public class LoginBean implements Serializable {
	
  private static final long serialVersionUID = -2152389656664659476L;
  private String nombre;
  private String clave;
  private boolean logeado = false;
  private static String SHOW_MENU = "/xhtml/menu.xhtml";
  private static String SHOW_LOGIN = "/xhtml/login.xhtml";
  
  public boolean estaLogeado() {
    return logeado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String login() {
    RequestContext context = RequestContext.getCurrentInstance();
    FacesMessage msg = null;
    if (nombre != null && nombre.equals("admin") && clave != null
        && clave.equals("admin")) {
      logeado = true;
      msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", nombre);
    } else {
      logeado = false;
      msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                             "Credenciales no válidas");
      return SHOW_LOGIN;
    }

    FacesContext.getCurrentInstance().addMessage(null, msg);
    context.addCallbackParam("estaLogeado", logeado);
//    if (logeado)
//      context.addCallbackParam("view", "gauge.xhtml");
    return SHOW_MENU;
  }

  public void logout() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance() 
                                        .getExternalContext().getSession(false);
    session.invalidate();
    logeado = false;
  }
}
