package com.ssr.model;

public class Goods {
	private int id;
	private String name;
	private double price;
	private String brand;
	private String sort;
	private String decs;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goods(String name) {
		super();
		this.name = name;
	}

	public Goods(int id, String name, double price, String brand, String sort, String decs) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.sort = sort;
		this.decs = decs;
	}
	
	public Goods(String name, double price, String brand) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDecs() {
		return decs;
	}
	public void setDecs(String decs) {
		this.decs = decs;
	}
	

}
