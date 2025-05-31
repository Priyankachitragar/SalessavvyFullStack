package com.example.demo2.services;

import com.example.demo2.entities.Category;
import com.example.demo2.entities.Product;
import com.example.demo2.entities.ProductImage;
import com.example.demo2.repositories.ProductRepository;
import com.example.demo2.repositories.ProductImageRepository;
import com.example.demo2.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getProductsByCategory(String categoryName) {
        if (categoryName != null && !categoryName.isEmpty()) {
            Optional<Category> categoryOpt = categoryRepository.findByCategoryName(categoryName);
            if (categoryOpt.isPresent()) {
                Category category = categoryOpt.get();
                return productRepository.findByCategoryCategoryId(category.getCategory_id());
            } else {
                throw new RuntimeException("Category not found");
            }
        } else { 
            return productRepository.findAll();
        }
    }

    public List<String> getProductImages(Integer productId) {
        List<ProductImage> productImages = productImageRepository.findByProductProductId(productId);
        List<String> imageUrls = new ArrayList<>();
        for (ProductImage image : productImages) {
            imageUrls.add(image.getImage_url());
        }
        return imageUrls;
    }
}