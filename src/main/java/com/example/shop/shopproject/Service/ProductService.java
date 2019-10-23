package com.example.shop.shopproject.Service;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.model.Product;
import com.example.shop.shopproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        if(productList.size()>0) return productList;
        else return new ArrayList<Product>();
    }

    public Product getProductById(Long id) throws ResourceNotFoundException{
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) return product.get();
        else throw new ResourceNotFoundException("No product find with given id");
    }

    public Product createOrUpdateProduct(Product product, long userId) throws ResourceNotFoundException{
        Optional<Product> newProduct = productRepository.findById(userId);
        if(newProduct.isPresent()){
            //TODO update fields
            Product returnProduct = newProduct.get();
            returnProduct.setDescription(product.getDescription());
            returnProduct.setPrice(product.getPrice());
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
        else throw new ResourceNotFoundException("No product find with given id");
    }
}
