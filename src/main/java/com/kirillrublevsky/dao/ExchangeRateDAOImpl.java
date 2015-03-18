package com.kirillrublevsky.dao;

import com.kirillrublevsky.model.ExchangeRate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateDAOImpl implements ExchangeRateDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public ExchangeRateDAOImpl() {}

    @Override
    public void addExchangeRate(ExchangeRate exchangeRate) {
        sessionFactory.getCurrentSession().save(exchangeRate);
    }

    @Override
    public ExchangeRate getExchangeRateById(Integer id){
        ExchangeRate exchangeRate = (ExchangeRate) sessionFactory.getCurrentSession().load(ExchangeRate.class, id);
        if (exchangeRate != null){
            return exchangeRate;
        }
        return null;
    }

    @Override
    public void removeExchangeRate(Integer id){
        ExchangeRate exchangeRate = (ExchangeRate) sessionFactory.getCurrentSession().load(ExchangeRate.class, id);
        if (null != exchangeRate) {
            sessionFactory.getCurrentSession().delete(exchangeRate);
        }
    }
}
