package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "country", nullable = false)
    private String country;

    @OneToMany
    private List<Product> productList;

    public Supplier(){
    }

    public Supplier(long id, String name, String country) {
        this.name = name;
        this.country = country;
    }


    public long getId() {return id; }
    public void setId(long id) {this.id = id;}


    public String getName() { return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
