/**
 * 
 */
package com.maynar.managedbeans;

/**
 * @author Raul
 *
 */
import java.io.Serializable;

import javax.faces.event.ActionEvent;

import com.maynar.util.AjaxMessages;
  
public class MenuBean implements Serializable{  
      
    /**
	 * 
	 */
	
	public String pulsar(){
		System.out.println("hola");
		return "pulsado";
	}

	public void save() {  
        AjaxMessages.addMessage("Data saved");  
    }  
      
    public void update() {  
    	AjaxMessages.addMessage("Data updated");  
    }  
      
    public void delete(ActionEvent evento) {
    	
    	AjaxMessages.addMessage("Item Eliminado");  
    }  

}  
