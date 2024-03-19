package com.property.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Property Table")
public class PropertyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int Id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String onwerName;
	@Column
	private String ownerEmail;
	@Column
	private Double price;
	@Column
	private String address;

	public String getTitle() {
		return title;
	}

	public PropertyEntity() {
		super();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOnwerName() {
		return onwerName;
	}

	public void setOnwerName(String onwerName) {
		this.onwerName = onwerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
}
