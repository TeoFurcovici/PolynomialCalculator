package com.company.model;

public class Monom {
    /*
    In this class I store only the power, because the coefficient can be real after performing integration/division. This class is the
    parent class for the MonomReal and MonomInt
     */

    private int power;

    public Monom() {
    }

    public Monom(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }



}

