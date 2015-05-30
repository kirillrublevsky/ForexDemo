package com.kirillrublevsky.dao.impl;

import com.kirillrublevsky.dao.ExchangeRateDAO;
import com.kirillrublevsky.dao.entity.ExchangeRate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateDAOImpl implements ExchangeRateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ExchangeRateDAOImpl() {}

    @Override
    public void updateExchangeRate(double rate, int id) {
        ExchangeRate exchangeRate = (ExchangeRate) sessionFactory.getCurrentSession().load(ExchangeRate.class, id);
        exchangeRate.setRate(rate);
    }

    @Override
    public double getExchangeRate(){
        ExchangeRate exchangeRate = (ExchangeRate) sessionFactory.getCurrentSession().load(ExchangeRate.class, 2);
        return exchangeRate.getRate();
    }

    @Override
    public double getOldExchangeRate(){
        ExchangeRate exchangeRate = (ExchangeRate) sessionFactory.getCurrentSession().load(ExchangeRate.class, 1);
        return exchangeRate.getRate();
    }

}
