package com.kirillrublevsky.dao.impl;

import com.kirillrublevsky.dao.BalanceDAO;
import com.kirillrublevsky.model.Balance;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceDAOImpl implements BalanceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public BalanceDAOImpl() {}

    @Override
    public void updateBalance(Double amount) {
        Balance balance = (Balance) sessionFactory.getCurrentSession().load(Balance.class, 1);
        balance.setAmount(amount);
    }

    @Override
    public Double getBalance(){
        Balance balance = (Balance) sessionFactory.getCurrentSession().load(Balance.class, 1);
        return balance.getAmount();
    }

}
