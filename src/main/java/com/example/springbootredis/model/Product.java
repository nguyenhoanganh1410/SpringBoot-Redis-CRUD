package com.example.springbootredis.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Product implements Serializable{
	private int id;
	private String name;
	private Double price;
	public Product() {
		super();
	}
	public Product(int id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
