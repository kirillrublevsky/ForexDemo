package com.kirillrublevsky.controller;

import com.kirillrublevsky.model.Dollars;
import com.kirillrublevsky.service.BalanceService;
import com.kirillrublevsky.service.DollarsService;
import com.kirillrublevsky.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private DollarsService dollarsService;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @RequestMapping(value="/demo", method = RequestMethod.GET)
    public ModelAndView loadPage () {
        ModelAndView model = new ModelAndView("application");
        model.addObject("balance", balanceService.getBalance());
        model.addObject("dollars", dollarsService.getDollars());
        model.addObject("rate", exchangeRateService.getExchangeRate());

        return model;
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public String buyDollars(@ModelAttribute("dollars") Dollars dollars, Model model) {
        Double initialBalance = balanceService.getBalance();
        Double currentRate = exchangeRateService.getExchangeRate();
        Integer dollarsAmount = dollars.getAmount();

//        System.out.println("Balance before operation: " + initialBalance);
//        System.out.println("Dollars bought: " + dollarsAmount);
//        System.out.println("Current rate: " + currentRate);

        balanceService.updateBalance(initialBalance - dollarsAmount * currentRate);
        dollarsService.updateDollars(dollarsService.getDollars() + dollarsAmount);

        Double finalBalance = balanceService.getBalance();
        Integer finalDollarsAmount = dollarsService.getDollars();

//        System.out.println("Balance after operation: " + finalBalance);
//        System.out.println("Dollars after operation: " + finalDollarsAmount);


//        ModelAndView model = new ModelAndView("application");
        model.addAttribute("balance", finalBalance);
        model.addAttribute("dollars", finalDollarsAmount);

        return "application";
    }
}
