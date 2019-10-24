package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "price_reduction")
public class PriceReduction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "reduction_price", nullable = false)
    private int reductionPrice;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @ManyToOne
    private Product product;
    public PriceReduction() {
    }

    public PriceReduction(int reductionPrice, LocalDate startDate, LocalDate endDate) {
        this.reductionPrice = reductionPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getReductionPrice() {return reductionPrice; }
    public void setReductionPrice(int reductionPrice) {
        this.reductionPrice = reductionPrice;
    }


    public LocalDate getStartDate() {return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }


    public LocalDate getEndDate() {return endDate; }
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}
}
