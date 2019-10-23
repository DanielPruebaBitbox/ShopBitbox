package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "price_reduction")
public class PriceReduction {
    private long id;
    private int reductionPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public PriceReduction() {
    }

    public PriceReduction(int reductionPrice, LocalDate startDate, LocalDate endDate) {
        this.reductionPrice = reductionPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "reduction_price", nullable = false)
    public int getReductionPrice() {return reductionPrice; }
    public void setReductionPrice(int reductionPrice) {
        this.reductionPrice = reductionPrice;
    }

    @Column(name = "start_date", nullable = false)
    public LocalDate getStartDate() {return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    @Column(name = "end_date", nullable = false)
    public LocalDate getEndDate() {return endDate; }
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}
}
