package com.kirillrublevsky.service.impl;

import com.kirillrublevsky.dao.ExchangeRateDAO;
import com.kirillrublevsky.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;


@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateDAO exchangeRateDAO;

    public ExchangeRateServiceImpl() {}

    @Override
    @Transactional(readOnly = true)
    public double getExchangeRate() {
        return exchangeRateDAO.getExchangeRate();
    }

    @Override
    @Transactional
    public double generateExchangeRate() {
        Double currentRate = exchangeRateDAO.getExchangeRate();
        Random random = new Random();
        boolean isGrowing = getTrend(currentRate, exchangeRateDAO.getOldExchangeRate(), random.nextDouble());
        double coefficient = getCoefficient(random.nextDouble());
        double newRate = roundToCents(getNewRate(isGrowing, coefficient, currentRate));

        exchangeRateDAO.updateExchangeRate(currentRate, 1);
        exchangeRateDAO.updateExchangeRate(newRate, 2);
        return newRate;
    }

    @Override
    public double roundToCents(double rate){
        BigDecimal roundedRate = new BigDecimal(rate);
        roundedRate = roundedRate.setScale(2, BigDecimal.ROUND_CEILING);
        return roundedRate.doubleValue();
    }


    private double getNewRate(boolean isGrowing, double coefficient, double currentRate){
        double newRate;
        if (isGrowing){
            newRate = currentRate * coefficient;
        }
        else {
            newRate = currentRate / coefficient;
        }
        return newRate;
    }

    private boolean getTrend(double currentRate, double oldRate, double probability){
        boolean isGrowing = false;
        if (currentRate >= oldRate){
            isGrowing = true;
        }
        if(probability >= 0.5){
            isGrowing = !isGrowing;
        }
        return isGrowing;
    }

    private double getCoefficient(double probability){
        return 1 + probability / 10;
    }

}
