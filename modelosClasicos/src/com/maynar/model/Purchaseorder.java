package com.maynar.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Purchaseorder entity. @author MyEclipse Persistence Tools
 */

public class Purchaseorder implements java.io.Serializable {

	// Fields

	private Integer purchaseordernumber;
	private Date orderdate;
	private Date requireddate;
	private Date shippeddate;
	private String status;
	private String comments;
	private Integer customernumber;
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Purchaseorder() {
	}

	/** minimal constructor */
	public Purchaseorder(Integer purchaseordernumber) {
		this.purchaseordernumber = purchaseordernumber;
	}

	/** full constructor */
	public Purchaseorder(Integer purchaseordernumber, Date orderdate,
			Date requireddate, Date shippeddate, String status,
			String comments, Integer customernumber, Set orderdetails) {
		this.purchaseordernumber = purchaseordernumber;
		this.orderdate = orderdate;
		this.requireddate = requireddate;
		this.shippeddate = shippeddate;
		this.status = status;
		this.comments = comments;
		this.customernumber = customernumber;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getPurchaseordernumber() {
		return this.purchaseordernumber;
	}

	public void setPurchaseordernumber(Integer purchaseordernumber) {
		this.purchaseordernumber = purchaseordernumber;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getRequireddate() {
		return this.requireddate;
	}

	public void setRequireddate(Date requireddate) {
		this.requireddate = requireddate;
	}

	public Date getShippeddate() {
		return this.shippeddate;
	}

	public void setShippeddate(Date shippeddate) {
		this.shippeddate = shippeddate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getCustomernumber() {
		return this.customernumber;
	}

	public void setCustomernumber(Integer customernumber) {
		this.customernumber = customernumber;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}