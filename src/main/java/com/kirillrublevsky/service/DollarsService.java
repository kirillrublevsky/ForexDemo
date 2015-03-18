package com.kirillrublevsky.service;

import com.kirillrublevsky.model.Dollars;

public interface DollarsService {

    public void addDollars(Dollars dollars);
    public Dollars getDollarsById(Integer id);
    public void removeDollars(Integer id);
}
