package com.kirillrublevsky.controller;

import com.kirillrublevsky.service.BalanceService;
import com.kirillrublevsky.service.DollarsService;
import com.kirillrublevsky.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private DollarsService dollarsService;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @RequestMapping(value="/ForexDemo", method = RequestMethod.GET)
    public ModelAndView loadPage() {
        double balance = balanceService.getBalance();
        double rate = exchangeRateService.getExchangeRate();

        ModelAndView model = new ModelAndView("index");
        model.addObject("balance", balance);
        model.addObject("rate", rate);
        model.addObject("dollars", dollarsService.getDollars());
        model.addObject("max", balance / rate);

        return model;
    }

    @RequestMapping(value = "/getRate", method = RequestMethod.GET)
    public @ResponseBody String buyDollars() {
        Double newRate = exchangeRateService.generateExchangeRate();
        return "{\"rate\" : " + newRate + "}";
    }

    @RequestMapping(value = "/buyDollars", method = RequestMethod.POST)
    public @ResponseBody String buyDollars(@RequestParam(value = "amount", required = true) double amount) {
        Double finalBalance = balanceService.getBalance() - amount * exchangeRateService.getExchangeRate();
        Double finalDollarsAmount = dollarsService.getDollars() + amount;
        finalBalance = exchangeRateService.roundToCents(finalBalance);
        finalDollarsAmount = exchangeRateService.roundToCents(finalDollarsAmount);

        balanceService.updateBalance(finalBalance);
        dollarsService.updateDollars(finalDollarsAmount);

        return "{\"balance\" : " + finalBalance + ", \"dollars\" :" + finalDollarsAmount + "}";
    }

    @RequestMapping(value = "/sellDollars", method = RequestMethod.POST)
    public @ResponseBody String sellDollars(@RequestParam(value = "amount", required = true) double amount) {
        Double finalBalance = balanceService.getBalance() + amount * exchangeRateService.getExchangeRate();
        Double finalDollarsAmount = dollarsService.getDollars() - amount;
        finalBalance = exchangeRateService.roundToCents(finalBalance);
        finalDollarsAmount = exchangeRateService.roundToCents(finalDollarsAmount);

        balanceService.updateBalance(finalBalance);
        dollarsService.updateDollars(finalDollarsAmount);

        return "{\"balance\" : " + finalBalance + ", \"dollars\" :" + finalDollarsAmount + "}";
    }
}
