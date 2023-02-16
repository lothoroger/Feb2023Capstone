package com.fds.FoodDelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuisines {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	public String name;
	public String origin;
	private Double price;
	public Boolean available;
	public String addedon;
	public String image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getAddedon() {
		return addedon;
	}
	public void setAddedon(String addedon) {
		this.addedon = addedon;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Cuisines [id=" + id + ", name=" + name + ", origin=" + origin + ", price=" + price + ", available="
				+ available + ", addedon=" + addedon + ", image=" + image + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getOrigin()=" + getOrigin() + ", getPrice()=" + getPrice() + ", getAvailable()="
				+ getAvailable() + ", getAddedon()=" + getAddedon() + ", getImage()=" + getImage() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Cuisines(Integer id, String name, String origin, Double price, Boolean available, String addedon,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.price = price;
		this.available = available;
		this.addedon = addedon;
		this.image = image;
	}
	
	
	
	public Cuisines() {}
	
	

}
