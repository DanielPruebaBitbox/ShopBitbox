package com.example.shop.shopproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "price_reduction")
public class PriceReduction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "reduction_price", nullable = false)
    private int reductionPrice;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @ManyToOne
    private Product product;

    public PriceReduction() {
    }

    public PriceReduction(int reductionPrice, Date startDate, Date endDate) {
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


    public Date getStartDate() {return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }


    public Date getEndDate() {return endDate; }
    public void setEndDate(Date endDate) {this.endDate = endDate;}
}
