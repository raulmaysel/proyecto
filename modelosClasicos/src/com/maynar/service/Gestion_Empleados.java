package com.maynar.service;

import java.util.List;

import com.maynar.dao.EmployeeDAO;
import com.maynar.model.Employee;

public class Gestion_Empleados implements IGestion_Empleados {
	
	
	private EmployeeDAO emploDao;

	public List<Employee> consultar_Todos() {
		
		return emploDao.findAll();
	}
	
	public Employee consultar_PorClave(Integer employeeNumber) {
		return emploDao.findById(employeeNumber);
	}
	
	public Employee consultar_PorClave(Employee Employee) {
		return emploDao.findById(Employee.getEmployeenumber());
	}

	public boolean baja_Employee(Employee Employee_desconectado) {
		
		emploDao.delete(Employee_desconectado);
		return false;
		
	}

	public Employee modificacion_Employee(Employee Employee_desconectado) {
		
		emploDao.attachDirty(Employee_desconectado);
		
		return null;
	}

	public boolean alta_Employee(Employee Employee_desconectado) {
		Employee existingEmployee = emploDao.findById(Employee_desconectado.getEmployeenumber());

		if (existingEmployee != null) {
			if (existingEmployee != Employee_desconectado) {
				existingEmployee.setEmployeenumber(Employee_desconectado.getEmployeenumber());
				existingEmployee.setLastname(Employee_desconectado.getLastname());
				existingEmployee.setFirstname(Employee_desconectado.getFirstname());
				existingEmployee.setExtension(Employee_desconectado.getExtension());
				existingEmployee.setEmail(Employee_desconectado.getEmail());
				existingEmployee.setReportsto(Employee_desconectado.getReportsto());
				existingEmployee.setJobtitle(Employee_desconectado.getJobtitle());
			}
			Employee_desconectado = existingEmployee;
		} 
		
		emploDao.save(Employee_desconectado);
		return false;
	}


	// ACCCESORES PARA SPRING
	public void setemploDao(EmployeeDAO emploDao) {
		this.emploDao = emploDao;
	}

	

}
