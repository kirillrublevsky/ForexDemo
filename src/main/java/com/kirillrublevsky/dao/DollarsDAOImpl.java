package com.kirillrublevsky.dao;

import com.kirillrublevsky.model.Dollars;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DollarsDAOImpl implements DollarsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public DollarsDAOImpl() {}

    @Override
    public void addDollars(Dollars dollars) {
        sessionFactory.getCurrentSession().save(dollars);
    }

    @Override
    public Dollars getDollarsById(Integer id){
        Dollars dollars = (Dollars) sessionFactory.getCurrentSession().load(Dollars.class, id);
        if (dollars != null){
            return dollars;
        }
        return null;
    }

    @Override
    public void removeDollars(Integer id) {
        Dollars dollars = (Dollars) sessionFactory.getCurrentSession().load(Dollars.class, id);
        if (null != dollars) {
            sessionFactory.getCurrentSession().delete(dollars);
        }
    }
}
