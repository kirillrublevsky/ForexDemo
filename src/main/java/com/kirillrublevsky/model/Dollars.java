package com.kirillrublevsky.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dollars")
public class Dollars implements Serializable {

    @Id
    @Column(name = "dollars_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "amount")
    private Integer amount;

    public Dollars() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dollars)) return false;

        Dollars dollars = (Dollars) o;

        return amount.equals(dollars.amount) && id.equals(dollars.id);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dollars{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
