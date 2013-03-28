package com.maynar.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AjaxMessages {
	
	public static void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  

}
