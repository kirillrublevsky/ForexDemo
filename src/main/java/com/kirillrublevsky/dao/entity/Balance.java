package com.kirillrublevsky.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "balance")
public class Balance implements Serializable {

    @Id
    @Column(name = "balance_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "amount")
    private Double amount;

    public Balance() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance)) return false;

        Balance balance = (Balance) o;

        if (!amount.equals(balance.amount)) return false;
        return id.equals(balance.id);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
