package com.kirillrublevsky.dao;

public interface BalanceDAO {

    void updateBalance(Double amount);
    Double getBalance();
}
