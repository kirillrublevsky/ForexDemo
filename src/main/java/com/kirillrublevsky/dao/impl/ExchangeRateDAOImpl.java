package com.kirillrublevsky.dao.impl;

import com.kirillrublevsky.dao.ExchangeRateDAO;
import com.kirillrublevsky.model.ExchangeRate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateDAOImpl implements ExchangeRateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ExchangeRateDAOImpl() {}

    @Override
    public void updateExchangeRate(Double rate) {
        ExchangeRate exchangeRate = (ExchangeRate) sessionFactory.getCurrentSession().load(ExchangeRate.class, 1);
        exchangeRate.setRate(rate);
    }

    @Override
    public Double getExchangeRate(){
        ExchangeRate exchangeRate = (ExchangeRate) sessionFactory.getCurrentSession().load(ExchangeRate.class, 1);
        return exchangeRate.getRate();
    }

}
