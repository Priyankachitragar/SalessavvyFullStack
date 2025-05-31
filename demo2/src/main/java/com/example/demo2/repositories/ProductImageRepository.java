package com.example.demo2.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.entities.ProductImage;


@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{
	List<ProductImage> findByProductProductId(Integer productId);
}
