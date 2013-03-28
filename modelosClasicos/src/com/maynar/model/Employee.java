package com.maynar.model;

import java.io.Serializable;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer employeenumber;
	private Office office;
	private String lastname;
	private String firstname;
	private String extension;
	private String email;
	private Integer reportsto;
	private String jobtitle;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(Integer employeenumber) {
		this.employeenumber = employeenumber;
	}

	/** full constructor */
	public Employee(Integer employeenumber, Office office, String lastname,
			String firstname, String extension, String email,
			Integer reportsto, String jobtitle) {
		this.employeenumber = employeenumber;
		this.office = office;
		this.lastname = lastname;
		this.firstname = firstname;
		this.extension = extension;
		this.email = email;
		this.reportsto = reportsto;
		this.jobtitle = jobtitle;
	}

	// Property accessors

	public Integer getEmployeenumber() {
		return this.employeenumber;
	}

	public void setEmployeenumber(Integer employeenumber) {
		this.employeenumber = employeenumber;
	}

	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReportsto() {
		return this.reportsto;
	}

	public void setReportsto(Integer reportsto) {
		this.reportsto = reportsto;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

}