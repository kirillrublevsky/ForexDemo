package com.kirillrublevsky.service;

public interface ExchangeRateService {

    void updateExchangeRate(double rate, int id);
    double getExchangeRate();
    double generateExchangeRate();
    double roundToCents(double rate);
}


