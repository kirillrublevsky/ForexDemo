package com.kirillrublevsky.dao;

public interface BalanceDAO {

    void updateBalance(double amount);
    double getBalance();
}
