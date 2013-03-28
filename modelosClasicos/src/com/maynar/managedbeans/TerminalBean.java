/**
 * 
 */
package com.maynar.managedbeans;

/**
 * @author Raul
 *
 */
import java.io.Serializable;
import java.util.Date;  

public class TerminalBean implements Serializable{  
  
    public String handleCommand(String command, String[] params) {  
        if(command.equals("greet"))  
            return "Hello ";  
        else if(command.equals("date"))  
            return new Date().toString();  
        else  
            return command + " not found";  
    }  
}  