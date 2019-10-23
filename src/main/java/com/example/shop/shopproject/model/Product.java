package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "Product")
public class Product {

    private long id;
    private long productCode;
    private String name;
    private String description;
    private boolean active;
    private LocalDate creationDate;
    private int price;
    private long creator;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "id")
    private ArrayList<Supplier> supplier = new ArrayList<Supplier>();
    private ArrayList<PriceReduction> priceReduction = new ArrayList<PriceReduction>();

    public Product() { }

    public Product(String name, String description, int price, int productCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.creationDate = null;
        //this.active = true;
        this.productCode = productCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "product_code", nullable = false)
    public long getProductCode() { return productCode;}
    public void setProductCode(long productCode) {this.productCode = productCode;
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
    public int getPrice(){return price;}
    public void setPrice(int price){this.price = price;}

    @Column(name = "creation_date", nullable = true)
    public LocalDate getCreationDate(){return creationDate;}
    public void setCreationDate(){this.creationDate = LocalDate.now();}

    @Column(name = "product_active", nullable = true)
    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;
    }

    @Column(name = "product_creator", nullable = true)
    public long getCreator() { return creator;    }
    public void setCreator(long creator) { this.creator = creator; }

    @Column(name = "creation_date", nullable = true)
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate;}

    @Column(name="supplier_id", nullable = true)
    public ArrayList<Supplier> getSupplier() { return supplier; }
    public void setSupplier(ArrayList<Supplier> supplier) {
        this.supplier = supplier;
    }

    @Column(name="price_reduction_id", nullable = true)
    public ArrayList<PriceReduction> getPriceReduction() { return priceReduction;}
    public void setPriceReduction(ArrayList<PriceReduction> priceReduction) {this.priceReduction = priceReduction;}
}
