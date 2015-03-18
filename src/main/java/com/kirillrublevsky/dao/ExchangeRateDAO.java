package com.kirillrublevsky.dao;

import com.kirillrublevsky.model.ExchangeRate;

public interface ExchangeRateDAO {


    public void addExchangeRate(ExchangeRate exchangeRate);
    public ExchangeRate getExchangeRateById(Integer id);
    public void removeExchangeRate(Integer id);
}
