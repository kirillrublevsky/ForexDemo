package com.kirillrublevsky.service.impl;

import com.kirillrublevsky.dao.BalanceDAO;
import com.kirillrublevsky.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceDAO balanceDAO;

    public BalanceServiceImpl() {}

    @Override
    @Transactional
    public void updateBalance(Double amount) {
        balanceDAO.updateBalance(amount);
    }

    @Override
    @Transactional(readOnly = true)
    public Double getBalance() {
        return balanceDAO.getBalance();
    }

}
