package com.kirillrublevsky.controller;

import com.kirillrublevsky.model.Balance;
import com.kirillrublevsky.service.BalanceService;
import com.kirillrublevsky.service.DollarsService;
import com.kirillrublevsky.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private DollarsService dollarsService;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @RequestMapping(value="/demo")
    public String showBalance (Model model) {

        Balance balance = new Balance();
        balance.setAmount(5000);
        balanceService.addBalance(balance);
        model.addAttribute("balance", balanceService.getBalanceById(1));

        return "app";
    }
}
