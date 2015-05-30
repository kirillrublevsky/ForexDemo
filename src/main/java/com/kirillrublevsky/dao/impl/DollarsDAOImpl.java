package com.kirillrublevsky.dao.impl;

import com.kirillrublevsky.dao.DollarsDAO;
import com.kirillrublevsky.dao.entity.Dollars;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DollarsDAOImpl implements DollarsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public DollarsDAOImpl() {}

    @Override
    public void updateDollars(double amount) {
        Dollars dollars = (Dollars) sessionFactory.getCurrentSession().load(Dollars.class, 1);
        dollars.setAmount(amount);    }

    @Override
    public double getDollars(){
        Dollars dollars = (Dollars) sessionFactory.getCurrentSession().load(Dollars.class, 1);
        return dollars.getAmount();
    }

}
