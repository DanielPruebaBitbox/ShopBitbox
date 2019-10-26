package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productCode;

    private String name;

    private String description;
    private Boolean active;

    private Date creationDate;
    private Integer price;
    private Long creator;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Supplier> supplierList;


    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = false)
    private List<PriceReduction> priceReductionList;
    public Product() { }

    public Product(String name, String description, Integer price, Long productCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.creationDate = null;
        this.active = true;
        this.productCode = productCode;
    }

    public Product(String description, Long productCode){
        this.description = description;
        this.productCode = productCode;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "product_code", nullable = false)
    public Long getProductCode() { return productCode;}
    public void setProductCode(Long productCode) {this.productCode = productCode;}

    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
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
    public void setActive(Boolean active) {this.active = active;}
    @Column(name = "product_creator", nullable = true)
    public Long getCreator() { return creator;    }
    public void setCreator(Long creator) { this.creator = creator; }

    public List<Supplier> getSupplier() {return supplierList;}
    public void setSupplier(List<Supplier> supplierList) {this.supplierList = supplierList;}

    public List<PriceReduction> getPriceReduction() {return priceReductionList;}
    public void setPriceReduction(List<PriceReduction> priceReductionList) {this.priceReductionList = priceReductionList;}


}
