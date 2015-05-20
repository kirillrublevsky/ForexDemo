package com.kirillrublevsky.service.impl;

import com.kirillrublevsky.dao.DollarsDAO;
import com.kirillrublevsky.service.DollarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DollarsServiceImpl implements DollarsService {

    @Autowired
    private DollarsDAO dollarsDAO;

    public DollarsServiceImpl() {}

    @Override
    @Transactional
    public void updateDollars(Integer amount) {
        dollarsDAO.updateDollars(amount);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getDollars() {
        return dollarsDAO.getDollars();
    }

}
