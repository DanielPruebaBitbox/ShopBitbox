package com.example.shop.shopproject.model;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
    private long id;
    private String name;
    private String country;

    public Supplier(){
    }

    public Supplier(long id, String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {return id; }
    public void setId(long id) {this.id = id;}

    @Column(name = "name", nullable = false)
    public String getName() { return name;}
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
