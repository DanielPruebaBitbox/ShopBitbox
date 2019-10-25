package com.example.shop.shopproject.service;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.model.Product;
import com.example.shop.shopproject.model.Supplier;
import com.example.shop.shopproject.repository.ProductRepository;
import com.example.shop.shopproject.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        if(productList.size()>0) return productList;
        else return new ArrayList<Product>();
    }

    public Product getProductById(Long id) throws ResourceNotFoundException{
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) return product.get();
        else throw new ResourceNotFoundException("No product found with given id");
    }

    public Product createOrUpdateProduct(@RequestBody Product product, long productId) throws ResourceNotFoundException{

        Optional<Product> newProduct = productRepository.findById(productId);
        if(newProduct.isPresent()){
            Product returnProduct = newProduct.get();
            returnProduct.setProductCode(product.getProductCode());
            returnProduct.setDescription(product.getDescription());
            returnProduct.setPrice(product.getPrice());
            returnProduct.setActive(product.isActive());
            returnProduct.setSupplier(product.getSupplier());
            returnProduct.setCreationDate(product.getCreationDate());
            returnProduct.setPriceReduction(product.getPriceReduction());
            returnProduct = productRepository.save(returnProduct);
            return returnProduct;
        }
        else{
            product = productRepository.save(product);
            return product;
        }
    }

    public void deleteProduct(Long id) throws ResourceNotFoundException{
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) productRepository.deleteById(id);
        else throw new ResourceNotFoundException("No product found with given id");
    }
}
