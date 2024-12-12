package com.example.restapi.common.dto;



public class ProductDTO {
    private String name;
    private Double price;
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
	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + "]";
	}
}
