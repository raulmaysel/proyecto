/**
 * 
 */
package com.maynar.managedbeans;

/**
 * @author Raul
 *
 */
import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;  

import com.maynar.util.Accesos_Contextos;
import com.maynar.util.AjaxMessages;
import com.maynar.model.Employee;
import com.maynar.model.Office;
import com.maynar.service.IGestion_Empleados;
import com.maynar.spring.Acceso_ApplicationContext;
  
 

public class EmployeeBean implements Serializable {  
  
    /**
	 * 
	 */
	
	private final static String OK = "OK";
//	private final static String ERROR = "ERROR";
	private final static String VIEW_EMPLOYEE = "/xhtml/employee/viewEmployee.xhtml";
	private final static String SHOW_MENU = "/xhtml/menu.xhtml";
	private final static String NEW_EMPLOYEE = "/xhtml/employee/createEmployee.xhtml";
    private IGestion_Empleados ges_employee;
    private List<Employee> lista_empleados;
    private Employee selectedEmployee;
  

  
   
    public EmployeeBean() {  
        
    	
    	ges_employee = (IGestion_Empleados) Acceso_ApplicationContext.getBean("ges_employee");
    	consultarEmpleados();
    
    }  
  
    
    
    public void consultarEmpleados(){
//    	EmployeeDAO emploDao = (EmployeeDAO) Acceso_ApplicationContext.getBean("emploDao");
    	lista_empleados = new ArrayList<Employee>();
    	lista_empleados = ges_employee.consultar_Todos();
    	selectedEmployee = new Employee();
//    	lista_empleados = ges_employee.consultar_Todos();
//    	lista_empleados = new ArrayList<Employee>();
//    	emploDao = (EmployeeDAO) Acceso_ApplicationContext.getBean("emploDao");
//    	lista_empleados = (List<Employee>)emploDao.findAll();
    	
    	
    	
    	Accesos_Contextos.getSesion().setAttribute("empleados", lista_empleados);
    	Accesos_Contextos.getSesion().setAttribute("selectedEmployee", selectedEmployee);
 
    }
    
    public String nuevoEmpleado() {
		selectedEmployee = new Employee();

		return NEW_EMPLOYEE;
	}
    
    public String saveEmployee() {
		ges_employee.alta_Employee(selectedEmployee);
		consultarEmpleados();
		return SHOW_MENU;
	}
    
    public void removeItem(Employee employee){
    	
    	lista_empleados.remove(employee);
    	ges_employee.baja_Employee(employee);
    	AjaxMessages.addMessage("Empleado Eliminado");
    	consultarEmpleados();
    	
    	System.out.println("Empleado Eliminado");
    	
    	
    }
    
    public String viewEmployee(Integer employeenumber){
    	
    	selectedEmployee = (Employee)ges_employee.consultar_PorClave(employeenumber);
    	Office office = selectedEmployee.getOffice();
    	Accesos_Contextos.getSesion().setAttribute("selectedEmployee", selectedEmployee);
    	return VIEW_EMPLOYEE;
    }
    
    public void newEmployeeOffice(Integer employeenumber){
    	System.out.println("ea");
    }
       	

	public IGestion_Empleados getGes_employee() {
		return ges_employee;
	}

	public void setGes_employee(IGestion_Empleados ges_employee) {
		this.ges_employee = ges_employee;
	}

	public List<Employee> getLista_empleados() {
		return lista_empleados;
	}

	public void setLista_empleados(List<Employee> lista_empleados) {
		this.lista_empleados = lista_empleados;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}  
    
    
}  