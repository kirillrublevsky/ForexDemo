package com.kirillrublevsky.service;

import com.kirillrublevsky.dao.DollarsDAO;
import com.kirillrublevsky.model.Dollars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DollarsServiceImpl implements DollarsService{

    @Autowired
    private DollarsDAO dollarsDAO;

    public DollarsServiceImpl() {}

    @Transactional
    public void addDollars(Dollars dollars) {
        dollarsDAO.addDollars(dollars);
    }

    @Transactional
    public Dollars getDollarsById(Integer id) {
        return dollarsDAO.getDollarsById(id);
    }

    @Transactional
    public void removeDollars(Integer id) {
        dollarsDAO.removeDollars(id);
    }


}
