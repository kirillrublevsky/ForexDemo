package com.kirillrublevsky.service;

import com.kirillrublevsky.dao.ExchangeRateDAO;
import com.kirillrublevsky.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateDAO exchangeRateDAO;

    public ExchangeRateServiceImpl() {}

    @Transactional
    public void addExchangeRate(ExchangeRate exchangeRate) {
        exchangeRateDAO.addExchangeRate(exchangeRate);
    }

    @Transactional
    public ExchangeRate getExchangeRateById(Integer id) {
        return exchangeRateDAO.getExchangeRateById(id);
    }

    @Transactional
    public void removeExchangeRate(Integer id) {
        exchangeRateDAO.removeExchangeRate(id);
    }
}
