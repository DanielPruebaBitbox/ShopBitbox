package com.example.shop.shopproject.service;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.model.Product;
import com.example.shop.shopproject.model.Supplier;
import com.example.shop.shopproject.repository.ProductRepository;
import com.example.shop.shopproject.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;

    public  List<Supplier> addSupplier(Product product, List<Supplier> supplierList) throws ResourceNotFoundException {
        List<Supplier> productSupplierList = product.getSupplier();
        boolean equals = false;
        ArrayList<Supplier> supplierToAdd = new ArrayList<Supplier>();
        for (Supplier supplier : supplierList) {
            for (Supplier originalSupplier : productSupplierList) {
                equals = false;
                if (supplier.getName().equals(originalSupplier.getName()) &&
                        supplier.getCountry().equals(originalSupplier.getCountry())) {
                    equals = true;
                    break;
                }
            }
            if (!equals) supplierToAdd.add(supplier);

        }
        for(Supplier supplier: supplierToAdd) product.getSupplier().add(supplier);

        return product.getSupplier();
    }

    public List<Supplier> getAllSuppliers(){
        List<Supplier> supplierList = supplierRepository.findAll();
        if(supplierList.size()>0) return supplierList;
        else return new ArrayList<Supplier>();
    }


}