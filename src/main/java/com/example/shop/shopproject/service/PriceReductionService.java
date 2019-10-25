package com.example.shop.shopproject.service;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.model.PriceReduction;

import com.example.shop.shopproject.repository.PriceReductionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceReductionService {
    @Autowired
    private PriceReductionRepository priceReductionRepository;
    public List<PriceReduction> getAllPriceReductions(){
        List<PriceReduction> priceReductionList = priceReductionRepository.findAll();
        if(priceReductionList.size()>0) return priceReductionList;
        else return new ArrayList<PriceReduction>();
    }

    public PriceReduction createPriceReduction(PriceReduction priceReduction, long priceReductionId) throws ResourceNotFoundException {
        Optional<PriceReduction> newPriceReduction = priceReductionRepository.findById(priceReductionId);
        if(newPriceReduction.isPresent()){
            return priceReduction;
        }
        else{
            priceReduction = priceReductionRepository.save(priceReduction);
            return priceReduction;
        }
    }
}
