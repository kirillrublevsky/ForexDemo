package com.kirillrublevsky.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "rate")
public class ExchangeRate {

    @Id
    @Column(name = "rate_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "rate")
    private Double rate;

    public ExchangeRate() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeRate)) return false;

        ExchangeRate that = (ExchangeRate) o;

        if (!id.equals(that.id)) return false;
        return rate.equals(that.rate);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + rate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", rate=" + rate +
                '}';
    }
}


