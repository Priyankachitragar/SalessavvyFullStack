package com.example.demo2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productimages")
public class ProductImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer image_id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column
	private String image_url;

	public ProductImage() {
		super();
	}

	public ProductImage(Integer image_id, Product product, String image_url) {
		super();
		this.image_id = image_id;
		this.product = product;
		this.image_url = image_url;
	}

	public ProductImage(Product product, String image_url) {
		super();
		this.product = product;
		this.image_url = image_url;
	}

	public Integer getImage_id() {
		return image_id;
	}

	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
}
