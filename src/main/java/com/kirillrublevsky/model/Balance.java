package com.kirillrublevsky.model;

import javax.persistence.*;

@Entity
public class Balance {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private Integer amount;

    public Balance() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
