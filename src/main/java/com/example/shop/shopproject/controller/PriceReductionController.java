package com.example.shop.shopproject.controller;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.model.PriceReduction;
import com.example.shop.shopproject.service.PriceReductionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
public class PriceReductionController {
    PriceReductionService priceReductionService;

    @GetMapping("/pricereductions")
    public ResponseEntity<List<PriceReduction>> getAllPriceReductions() {
        List<PriceReduction> list = priceReductionService.getAllPriceReductions();
        return new ResponseEntity<List<PriceReduction>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping ("/pricereductions")
    public ResponseEntity <PriceReduction> createPriceReduction (PriceReduction priceReduction) throws ResourceNotFoundException {
        PriceReduction created = priceReductionService.createPriceReduction(priceReduction,priceReduction.getId());
        return new ResponseEntity<PriceReduction>(created, new HttpHeaders(), HttpStatus.OK);
    }
}
