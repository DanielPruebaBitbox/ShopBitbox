package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {

    private Long id;
    private Long productCode;
    private String name;
    private String description;
    private Boolean active;
    private Date creationDate;
    private Integer price;
    private Long creator;
/*
    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "id")
    private ArrayList<Supplier> supplier = new ArrayList<Supplier>();
    private ArrayList<PriceReduction> priceReduction = new ArrayList<PriceReduction>();*/

    public Product() { }

    public Product(String name, String description, Integer price, Long productCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.creationDate = null;
        //this.active = true;
        this.productCode = productCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "product_code", nullable = false)
    public Long getProductCode() { return productCode;}
    public void setProductCode(Long productCode) {this.productCode = productCode;
    }

    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }
    public void setName(String firstName) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = true)
    public Integer getPrice(){return price;}
    public void setPrice(Integer price){this.price = price;}


    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = true)
    public Date getCreationDate(){return creationDate;}
    public void setCreationDate(Date creationDate){this.creationDate = creationDate;}

    @Column(name = "product_active", nullable = true)
    public Boolean isActive() {return active;}
    public void setActive(Boolean active) {this.active = active;
    }

    @Column(name = "product_creator", nullable = true)
    public Long getCreator() { return creator;    }
    public void setCreator(Long creator) { this.creator = creator; }

/*    @Column(name = "creation_date", nullable = true)
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate;}*/

/*    @Column(name="supplier_id", nullable = true)
    public ArrayList<Supplier> getSupplier() { return supplier; }
    public void setSupplier(ArrayList<Supplier> supplier) {
        this.supplier = supplier;
    }

    @Column(name="price_reduction_id", nullable = true)
    public ArrayList<PriceReduction> getPriceReduction() { return priceReduction;}
    public void setPriceReduction(ArrayList<PriceReduction> priceReduction) {this.priceReduction = priceReduction;}*/
}
