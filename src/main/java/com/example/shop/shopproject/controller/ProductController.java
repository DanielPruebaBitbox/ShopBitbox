package com.example.shop.shopproject.controller;

import java.util.List;

import com.example.shop.shopproject.service.ProductService;
import com.example.shop.shopproject.model.Product;
import com.example.shop.shopproject.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity <Product> getProductById(@PathVariable(value = "id") Long productId)
        throws ResourceNotFoundException{
        Product product = productService.getProductById(productId);
        return new ResponseEntity<Product>(product, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity <Product> createProduct(Product product) throws ResourceNotFoundException {
        Product updated = productService.createOrUpdateProduct(product, 0);
        return new ResponseEntity<Product>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity <Product> updateProduct(@RequestBody Product product, @PathVariable(value = "id") Long userId)
                                                  throws ResourceNotFoundException {
        Product updated = productService.createOrUpdateProduct(product, userId);
        return new ResponseEntity<Product>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public HttpStatus deleteProduct(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        productService.deleteProduct(productId);
        return HttpStatus.OK;
    }


}
