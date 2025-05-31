package com.example.demo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer categoryId;	

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

	public Category() {
		super();
	}

	public Category(Integer category_id, String category_name) {
		super();
		this.categoryId = category_id;
		this.categoryName = category_name;
	}

	public Category(String category_name) {
		super();
		this.categoryName = category_name;
	}

	public Integer getCategory_id() {
		return categoryId;
	}

	public void setCategory_id(Integer category_id) {
		this.categoryId = category_id;
	}

	public String getCategory_name() {
		return categoryName;
	}

	public void setCategory_name(String category_name) {
		this.categoryName = category_name;
	}
    
    
   
}