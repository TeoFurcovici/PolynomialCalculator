package com.company.model;

import com.company.model.Monom;

public class MonomInt extends Monom {
    /*
    Because this class is the child for Monom, in the contrcutor i set first the power and then the coefficient.
    Regarding the toString method, I display each monomial taking into the consideration the sign of the coefficient
     */
    private int coeffInt;

    public MonomInt(int coeffInt, int power) {
        super(power);
        this.coeffInt = coeffInt;
    }

    public int getCoeffInt() {
        return coeffInt;
    }

    public void setCoeffInt(int coeffInt) {
        this.coeffInt = coeffInt;
    }
    Monom monom=new Monom();
    public String ToStringIntForMonom(int power){
        if(coeffInt>0)
            return ("+"+coeffInt + "x^"+power);
        else
        if(coeffInt<0)
            return (coeffInt+ "x^"+power);
        else
            return ("+" + 0 + " ");
    }
}
