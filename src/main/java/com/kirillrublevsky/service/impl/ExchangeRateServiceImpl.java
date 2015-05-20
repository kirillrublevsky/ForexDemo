package com.kirillrublevsky.service.impl;

import com.kirillrublevsky.dao.ExchangeRateDAO;
import com.kirillrublevsky.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateDAO exchangeRateDAO;

    public ExchangeRateServiceImpl() {}

    @Override
    @Transactional
    public void updateExchangeRate(Double rate) {
        exchangeRateDAO.updateExchangeRate(rate);
    }

    @Override
    @Transactional(readOnly = true)
    public Double getExchangeRate() {
        return exchangeRateDAO.getExchangeRate();
    }

}
