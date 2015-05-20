package com.kirillrublevsky.dao;

public interface ExchangeRateDAO {


    void updateExchangeRate(Double rate);
    Double getExchangeRate();
}
