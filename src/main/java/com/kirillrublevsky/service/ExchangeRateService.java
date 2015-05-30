package com.kirillrublevsky.service;

public interface ExchangeRateService {

    double getExchangeRate();
    double generateExchangeRate();
    double roundToCents(double rate);
}


