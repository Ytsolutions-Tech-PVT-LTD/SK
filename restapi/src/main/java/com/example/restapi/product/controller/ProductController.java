package com.example.restapi.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.common.dto.ProductDTO;
import com.example.restapi.common.entity.Product;
import com.example.restapi.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProductAPI(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

	
    @GetMapping("/{id}")
    public Product getProductByIdAPI(@PathVariable Long id) {
        return productService.getProductById(id);
    }
	 
    
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductByIdAPI(@PathVariable Long id) {
//        return productService.getProductById(id)
//                .map(product -> ResponseEntity.ok(product)) // 200 OK if product is found
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // 404 Not Found if missing
//    }

    
 // Endpoint to get all products
    @GetMapping
    public Iterable<Product> getAllProductsAPI() {
        return productService.getAllProducts();
    }
    
    
}
