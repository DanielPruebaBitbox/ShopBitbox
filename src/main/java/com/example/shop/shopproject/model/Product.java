package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "Product")
public class Product {

    private long id;
    private String name;
    private String description;
    private boolean active;
    private LocalDate creationDate;
    private int price;
    private long creator;
    private ArrayList<Supplier> supplier = new ArrayList<Supplier>();
    private ArrayList<PriceReduction> priceReduction = new ArrayList<PriceReduction>();

    public Product() { }

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.creationDate = null;
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
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

    @Column(name = "price", nullable = false)
    public int getPrice(){return price;}
    public void setPrice(int price){this.price = price;}

    @Column(name = "creation_date", nullable = false)
    public LocalDate getCreationDate(){return creationDate;}
    public void setCreationDate(){this.creationDate = LocalDate.now();}

    @Column(name = "product_active", nullable = false)
    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;
    }

    @Column(name = "product_creator", nullable = false)
    public long getCreator() { return creator;    }
    public void setCreator(long creator) { this.creator = creator; }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public ArrayList<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(ArrayList<Supplier> supplier) {
        this.supplier = supplier;
    }

    public ArrayList<PriceReduction> getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(ArrayList<PriceReduction> priceReduction) {
        this.priceReduction = priceReduction;
    }
}
