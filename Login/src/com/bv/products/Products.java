package com.bv.products;

import java.util.Date;

public class Products {

	private int id;
	private String productname , manufacturername;
	private double price;
	private Date manufacturedate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getManufacturername() {
		return manufacturername;
	}
	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getManufactureDate() {
		return manufacturedate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufacturedate = manufactureDate;
	}
	
	
	
}
