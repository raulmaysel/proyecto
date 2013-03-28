package com.maynar.service;


import java.util.List;

import com.maynar.model.Employee;

public interface IGestion_Empleados {

	public List<Employee> consultar_Todos();
	
	public Employee consultar_PorClave(Integer employeeNumber);
	
	public Employee consultar_PorClave(Employee Employee);
	
	public boolean baja_Employee(Employee Employee_desconectado);

	public Employee modificacion_Employee(Employee Employee_desconectado);
	
	public boolean alta_Employee(Employee Employee_desconectado);
	
	
}