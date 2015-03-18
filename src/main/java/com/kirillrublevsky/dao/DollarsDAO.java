package com.kirillrublevsky.dao;

import com.kirillrublevsky.model.Dollars;

public interface DollarsDAO {

    public void addDollars(Dollars dollars);
    public Dollars getDollarsById(Integer id);
    public void removeDollars(Integer id);
}
