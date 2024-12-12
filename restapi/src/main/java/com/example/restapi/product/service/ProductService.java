package com.example.restapi.product.service;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.restapi.common.dto.ProductDTO;
import com.example.restapi.common.entity.Product;
import com.example.restapi.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());  // Setting the name field
        product.setPrice(productDTO.getPrice());  // Setting the price field
        return productRepository.save(product);  // Saving the Product entity to the database
    }

	
	  @Cacheable(value = "products", key = "#id") public Product
	  getProductById(Long id) {
	  
	  System.out.println("not cache=");
	  
	  return productRepository.findById(id).orElseThrow(() -> new
	  RuntimeException("Product not found")); }
	 
    
//    @Cacheable(value = "products", key = "#id")
//    public Optional<Product> getProductById(Long id) {
//        System.out.println("Fetching from database..."); // Indicates cache miss
//        return productRepository.findById(id);
//    }
    
 // Fetch all products and cache them in Hazelcast
    @Cacheable(value = "products")
    public Iterable<Product> getAllProducts() {
        System.out.println("Fetching from database...");  // This will print the first time when data is not cached
        return productRepository.findAll();
    }
}
