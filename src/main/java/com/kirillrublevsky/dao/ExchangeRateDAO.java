package com.kirillrublevsky.dao;

public interface ExchangeRateDAO {


    void updateExchangeRate(double rate, int id);
    double getExchangeRate();
    double getOldExchangeRate();
}
