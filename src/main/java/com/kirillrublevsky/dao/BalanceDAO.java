package com.kirillrublevsky.dao;

import com.kirillrublevsky.model.Balance;

public interface BalanceDAO {

    public void addBalance(Balance balance);
    public Balance getBalanceById(Integer id);
    public void removeBalance(Integer id);
}
