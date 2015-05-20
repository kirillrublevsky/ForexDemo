package com.kirillrublevsky.service;

public interface ExchangeRateService {

    void updateExchangeRate(Double rate);
    Double getExchangeRate();
}
