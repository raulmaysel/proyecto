package com.maynar.model;

/**
 * Productline entity. @author MyEclipse Persistence Tools
 */

public class Productline implements java.io.Serializable {

	// Fields

	private String productline;
	private String textdescription;
	private String htmldescription;
	private String image;

	// Constructors

	/** default constructor */
	public Productline() {
	}

	/** minimal constructor */
	public Productline(String productline) {
		this.productline = productline;
	}

	/** full constructor */
	public Productline(String productline, String textdescription,
			String htmldescription, String image) {
		this.productline = productline;
		this.textdescription = textdescription;
		this.htmldescription = htmldescription;
		this.image = image;
	}

	// Property accessors

	public String getProductline() {
		return this.productline;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public String getTextdescription() {
		return this.textdescription;
	}

	public void setTextdescription(String textdescription) {
		this.textdescription = textdescription;
	}

	public String getHtmldescription() {
		return this.htmldescription;
	}

	public void setHtmldescription(String htmldescription) {
		this.htmldescription = htmldescription;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}