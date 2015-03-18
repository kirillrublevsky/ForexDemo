package com.kirillrublevsky.service;

import com.kirillrublevsky.model.ExchangeRate;

public interface ExchangeRateService {

    public void addExchangeRate(ExchangeRate exchangeRate);
    public ExchangeRate getExchangeRateById(Integer id);
    public void removeExchangeRate(Integer id);
}
