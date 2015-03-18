package com.kirillrublevsky.dao;

import com.kirillrublevsky.model.Balance;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceDAOImpl implements BalanceDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public BalanceDAOImpl() {}

    @Override
    public void addBalance(Balance balance) {
        sessionFactory.getCurrentSession().save(balance);
    }

    @Override
    public Balance getBalanceById(Integer id){
        Balance balance = (Balance) sessionFactory.getCurrentSession().load(Balance.class, id);
        if (balance != null){
            return balance;
        }
        return null;
    }

    @Override
    public void removeBalance(Integer id) {
        Balance balance = (Balance) sessionFactory.getCurrentSession().load(Balance.class, id);
        if (null != balance) {
            sessionFactory.getCurrentSession().delete(balance);
        }
    }
}
