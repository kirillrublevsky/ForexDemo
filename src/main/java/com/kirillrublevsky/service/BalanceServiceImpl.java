package com.kirillrublevsky.service;

import com.kirillrublevsky.dao.BalanceDAO;
import com.kirillrublevsky.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceDAO balanceDAO;

    public BalanceServiceImpl() {}

    @Transactional
    public void addBalance(Balance balance) {
        balanceDAO.addBalance(balance);
    }

    @Transactional
    public Balance getBalanceById(Integer id) {
        return balanceDAO.getBalanceById(id);
    }

    @Transactional
    public void removeBalance(Integer id) {
        balanceDAO.removeBalance(id);
    }

}
