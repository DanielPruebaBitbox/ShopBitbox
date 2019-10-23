package com.example.shop.shopproject.service;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.model.Product;
import com.example.shop.shopproject.model.Supplier;
import com.example.shop.shopproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SupplierService {
    ProductRepository productRepository;

    public void addSupplier(Product product, Supplier supplier) throws ResourceNotFoundException {
        Optional<Product> dbProduct = productRepository.findById(product.getId());
        if (dbProduct.isPresent()) {
            ArrayList<Supplier> productSupplier = product.getSupplier();
            if (!productSupplier.contains(supplier)){
                productSupplier.add(supplier);
                product.setSupplier(productSupplier);
                productRepository.save(product);
            }
            else throw new ResourceNotFoundException("Supplier already in");
        } else throw new ResourceNotFoundException("No product found with given id");
    }
}