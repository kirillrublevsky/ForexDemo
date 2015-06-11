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

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView loadPage() {
        double balance = balanceService.getBalance();
        double rate = exchangeRateService.getExchangeRate();

        String trend = "is falling";
        if (exchangeRateService.isGrowing()){
            trend = "is growing";
        }

        ModelAndView model = new ModelAndView("index");
        model.addObject("balance", balance);
        model.addObject("rate", rate);
        model.addObject("dollars", dollarsService.getDollars());
        model.addObject("max", (int) (balance / rate));
        model.addObject("trend", trend);

        return model;
    }

    @RequestMapping(value = "/getRate", method = RequestMethod.GET)
    public @ResponseBody String getRate() {
        return "{\"rate\" : " + exchangeRateService.generateExchangeRate() + "}";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public @ResponseBody String reset() {
        double balance = 5000;
        double dollars = 0;
        double oldRate = 19.85;
        double newRate = 20;

        balanceService.updateBalance(balance);
        dollarsService.updateDollars(dollars);
        exchangeRateService.updateExchangeRate(oldRate, 1);
        exchangeRateService.updateExchangeRate(newRate, 2);

        return "{\"balance\" : " + balance + ", \"dollars\" : " + dollars +  ", \"rate\" : " + newRate + "}";
    }

    @RequestMapping(value = "/buyDollars", method = RequestMethod.POST)
    public @ResponseBody String buyDollars(@RequestParam(value = "amount", required = true) double amount) {
        double finalBalance = balanceService.getBalance() - amount * exchangeRateService.getExchangeRate();
        double finalDollarsAmount = dollarsService.getDollars() + amount;
        finalBalance = exchangeRateService.roundToCents(finalBalance);

        balanceService.updateBalance(finalBalance);
        dollarsService.updateDollars(finalDollarsAmount);

        return "{\"balance\" : " + finalBalance + ", \"dollars\" : " + finalDollarsAmount + "}";
    }

    @RequestMapping(value = "/sellDollars", method = RequestMethod.POST)
    public @ResponseBody String sellDollars(@RequestParam(value = "amount", required = true) double amount) {
        double finalBalance = balanceService.getBalance() + amount * exchangeRateService.getExchangeRate();
        double finalDollarsAmount = dollarsService.getDollars() - amount;
        finalBalance = exchangeRateService.roundToCents(finalBalance);

        balanceService.updateBalance(finalBalance);
        dollarsService.updateDollars(finalDollarsAmount);

        return "{\"balance\" : " + finalBalance + ", \"dollars\" : " + finalDollarsAmount + "}";
    }
}
