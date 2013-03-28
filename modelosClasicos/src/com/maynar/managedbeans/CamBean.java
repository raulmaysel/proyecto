/**
 * 
 */
package com.maynar.managedbeans;

/**
 * @author Raul
 *
 */
import java.io.File;  
import java.io.Serializable;
import java.util.ArrayList;  
import java.util.List;  
import javax.faces.FacesException;  
import javax.faces.context.FacesContext;  
import javax.imageio.stream.FileImageOutputStream;  
import javax.servlet.ServletContext;  
import org.primefaces.event.CaptureEvent;  

import com.maynar.util.AjaxMessages;
  
public class CamBean implements Serializable{  
     
    private List<String> photos = new ArrayList<String>();  


      
    private String getRandomImageName() {  
        int i = (int) (Math.random() * 10000000);  
          
        return String.valueOf(i);  
    }  
  
    public List<String> getPhotos() {  
        return photos;  
    }      
      
    
    public void oncapture(CaptureEvent captureEvent) {  
        String photo = getRandomImageName();  
        this.photos.add(0,photo);  
        byte[] data = captureEvent.getData();  
          
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
        String newFileName = servletContext.getRealPath("") + File.separator + "photocam" + File.separator + photo + ".png";  
          
        FileImageOutputStream imageOutput;  
        try {  
            imageOutput = new FileImageOutputStream(new File(newFileName));  
            imageOutput.write(data, 0, data.length);  
            imageOutput.close(); 
           
        }  
        catch(Exception e) {  
            throw new FacesException("Error in writing captured image.");  
        }  
    }  
    


	public void eliminarFotos(){
    	photos.clear();
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
        File folder = new File(servletContext.getRealPath("") + File.separator + "photocam");
        File[] files = folder.listFiles();
        if(files!=null) { //some JVMs return null for empty dirs
            for(File f: files)
               f.delete();
                
            }
        
    	AjaxMessages.addMessage("Fotos Eliminadas");
    }
    
}  