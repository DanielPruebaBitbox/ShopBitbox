package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_code", nullable = false)
    private Long productCode;
    @Column(name = "name", nullable = true)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "product_active", nullable = true)
    private Boolean active;
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = true)
    private Date creationDate;
    @Column(name = "price", nullable = true)
    private Integer price;
    @Column(name = "product_creator", nullable = true)
    private Long creator;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "id")
    private List<Supplier> supplierList;
    //TODO change ArrayList to List
    @OneToMany(mappedBy = "product", fetch=FetchType.EAGER)
    private List<PriceReduction> priceReductionList;

    public Product() { }

    public Product(String name, String description, Integer price, Long productCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.creationDate = null;
        //this.active = true;
        this.productCode = productCode;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCode() { return productCode;}
    public void setProductCode(Long productCode) {this.productCode = productCode;}


    public String getName() {
        return name;
    }
    public void setName(String firstName) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice(){return price;}
    public void setPrice(Integer price){this.price = price;}

    public Date getCreationDate(){return creationDate;}
    public void setCreationDate(Date creationDate){this.creationDate = creationDate;}

    public Boolean isActive() {return active;}
    public void setActive(Boolean active) {this.active = active;}

    public Long getCreator() { return creator;    }
    public void setCreator(Long creator) { this.creator = creator; }

    public List<Supplier> getSupplier() {return supplierList;}
//    public void setSupplier(List<Supplier> supplierList) {this.supplierList = supplierList;}

    public List<PriceReduction> getPriceReduction() {return priceReductionList;}
//    public void setPriceReduction(List<PriceReduction> priceReductionList) {this.priceReductionList = priceReductionList;}



}
