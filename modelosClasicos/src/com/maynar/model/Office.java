package com.maynar.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Office entity. @author MyEclipse Persistence Tools
 */

public class Office implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String officecode;
	private String city;
	private String phone;
	private String addressline1;
	private String addressline2;
	private String state;
	private String country;
	private String postalcode;
	private String territory;
	private Set employees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Office() {
	}

	/** minimal constructor */
	public Office(String officecode) {
		this.officecode = officecode;
	}

	/** full constructor */
	public Office(String officecode, String city, String phone,
			String addressline1, String addressline2, String state,
			String country, String postalcode, String territory, Set employees) {
		this.officecode = officecode;
		this.city = city;
		this.phone = phone;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.state = state;
		this.country = country;
		this.postalcode = postalcode;
		this.territory = territory;
		this.employees = employees;
	}

	// Property accessors

	public String getOfficecode() {
		return this.officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getTerritory() {
		return this.territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}