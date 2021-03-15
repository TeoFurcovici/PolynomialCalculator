package com.company.model;

import com.company.model.Monom;

public class MonomReal extends Monom {
    /*
    Because this class is the child for Monom, in the contructor i set first the power and then the coefficient.
    Regarding the toString method, I display each monomial taking into the consideration the sign of the coefficient and then in another
    class I specify the format of the coefficient
     */
    private double coeffReal;

    public MonomReal() {
    }

    public MonomReal(double coeffReal, int power) {
        super(power);
        this.coeffReal = coeffReal;
    }

    public double getCoeffReal() {
        return coeffReal;
    }

    public void setCoeffReal(double coeffReal) {
        this.coeffReal = coeffReal;
    }
    public String ToStringRealForMonom(int power){
        if(coeffReal>0)
            return ("+"+coeffReal + "x^"+power);
        else
        if(coeffReal<0)
            return (coeffReal+ "x^"+power);
        else
            return ("+" + 0 + " ");
    }
}
