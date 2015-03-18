package com.kirillrublevsky.service;

import com.kirillrublevsky.model.Balance;

public interface BalanceService {

    public void addBalance(Balance balance);
    public Balance getBalanceById(Integer id);
    public void removeBalance(Integer id);
}
