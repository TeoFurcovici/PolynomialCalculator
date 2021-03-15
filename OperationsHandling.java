package com.company.controller;

import com.company.model.MonomReal;
import com.company.model.Polinom;
import com.company.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/*
    In this case I use aggregation relationship between Polinom and OperationsHandling class and between UI and OperationsHandling.
    Inside this class I use the constructor to power on the user interface, by making a new instance in the MAIN class.
    Going deeper, inside the constructor there are the methods from UI for button handling, where inside of each of this method I
    write the code that I want to be executed when the button is pressed.
    Each method has the same skeleton, I mean I create a Polynomial for each operation, where I store the result. Then with the help of
    other methods I display them on the screen.
 */
public class OperationsHandling {
     private UI ui=new UI();
     private Polinom firstPoly=new Polinom();
     private Polinom secondPoly=new Polinom();

    public Polinom getFirstPoly() {
        return firstPoly;
    }

    public void setFirstPoly(Polinom firstPoly) {
        this.firstPoly = firstPoly;
    }

    public Polinom getSecondPoly() {
        return secondPoly;
    }

    public void setSecondPoly(Polinom secondPoly) {
        this.secondPoly = secondPoly;
    }

    public OperationsHandling()
    {
        ui.additionButtonAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom sum=new Polinom();
                firstPoly=firstPoly.transformToPolinom(ui.getFirstPolyText(),0);
                secondPoly=secondPoly.transformToPolinom(ui.getSecondPolyText(),0);
                sum=firstPoly.add(firstPoly,secondPoly);
                sum.sortDecreasing();
                ui.setResultPolyText(sum.displayToStringForPoli());

            }
        });
       ui.clearButtonAction(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if (ui.clearButton.isEnabled())
               {
                   ui.setFirstPolyText("");
                   ui.setSecondPolyText("");
                   ui.setResultPolyText("");
               }
           }
       });
       ui.subtractButtonAction(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Polinom subtract=new Polinom();
               firstPoly=firstPoly.transformToPolinom(ui.getFirstPolyText(),0);
               secondPoly=secondPoly.transformToPolinom(ui.getSecondPolyText(),0);
               subtract=firstPoly.subtract(firstPoly,secondPoly);
               subtract.sortDecreasing();
               ui.setResultPolyText(subtract.displayToStringForPoli());
           }
       });
       ui.derivationButtonActionPoly1(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Polinom derivationForPoly1=new Polinom();
               firstPoly = firstPoly.transformToPolinom(ui.getFirstPolyText(),0);
               derivationForPoly1 = firstPoly.derivation(firstPoly);
               ui.setResultPolyText(derivationForPoly1.displayToStringForPoli());

               secondPoly = secondPoly.transformToPolinom(ui.getFirstPolyText(),0);
               derivationForPoly1=secondPoly.derivation(secondPoly);
               ui.setResultPolyText(derivationForPoly1.displayToStringForPoli());

           }
       });
        ui.derivationButtonActionPoly2(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom derivationPoly2=new Polinom();
                secondPoly = secondPoly.transformToPolinom(ui.getSecondPolyText(),0);
                derivationPoly2=secondPoly.derivation(secondPoly);
                ui.setResultPolyText(derivationPoly2.displayToStringForPoli());

            }
        });
        ui.multiplicationButtonAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom multiplication=new Polinom();
                firstPoly=firstPoly.transformToPolinom(ui.getFirstPolyText(),0);
                secondPoly=secondPoly.transformToPolinom(ui.getSecondPolyText(),0);
                multiplication=firstPoly.multiplication(firstPoly,secondPoly);
                multiplication.sortDecreasing();
                ui.setResultPolyText(multiplication.displayToStringForPoli());
            }
        });
        ui.integrationButtonActionPoly1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom intergrationForPoly1=new Polinom();
                firstPoly=firstPoly.transformToPolinom(ui.getFirstPolyText(),1);
                intergrationForPoly1=firstPoly.integration(firstPoly);
                /*
                I declared an instance of DecimalFormat, because in this way i can choose how to display the real numbers(i.e how many
                decimals to show). Then, i traverse the result polynomial and for each coefficient I format them in such a way that the
                coefficient will be rounded up and displayed with 2 decimals (because I put #.## as a pattern)
                 */
                DecimalFormat decimalFormat=new DecimalFormat("#.##");
                decimalFormat.setRoundingMode(RoundingMode.UP);
                for(int i=0;i<intergrationForPoly1.getRealPolynomList().size();i++){
                    String str=decimalFormat.format(intergrationForPoly1.getRealPolynomList().get(i).getCoeffReal());
                    double d=Double.parseDouble(str);
                    intergrationForPoly1.getRealPolynomList().get(i).setCoeffReal(d);
                }
                intergrationForPoly1.sortDecreasing();
                ui.setResultPolyText(intergrationForPoly1.displayToStringForPoliForReal());
            }
        });
        ui.integrationButtonActionPoly2(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom intergrationForPoly2=new Polinom();
                secondPoly = secondPoly.transformToPolinom(ui.getSecondPolyText(),1);
                intergrationForPoly2=secondPoly.integration(secondPoly);
                /*
                I declared an instance of DecimalFormat, because in this way i can choose how to display the real numbers(i.e how many
                decimals to show). Then, i traverse the result polynomial and for each coefficient I format them in such a way that the
                coefficient will be rounded up and displayed with 2 decimals (because I put #.## as a pattern)
                 */
                DecimalFormat decimalFormat=new DecimalFormat("#.##");
                decimalFormat.setRoundingMode(RoundingMode.UP);
                for(int i=0;i<intergrationForPoly2.getRealPolynomList().size();i++) {
                    String str = decimalFormat.format(intergrationForPoly2.getRealPolynomList().get(i).getCoeffReal());
                    double d1 = Double.parseDouble(str);
                    intergrationForPoly2.getRealPolynomList().get(i).setCoeffReal(d1);
                }
                intergrationForPoly2.sortDecreasing();
                ui.setResultPolyText(intergrationForPoly2.displayToStringForPoliForReal());

            }
        });
        /*ui.divisionButtonAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom[] division=new Polinom[2];
                firstPoly=firstPoly.transformToPolinom(ui.getFirstPolyText(),0);
                secondPoly=secondPoly.transformToPolinom(ui.getSecondPolyText(),0);
                firstPoly.sortDecreasing();
                secondPoly.sortDecreasing();
                if(firstPoly.getPolynomList().get(0).getPower()<secondPoly.getPolynomList().get(0).getPower())
                    JOptionPane.showMessageDialog(null,"Make sure that the first polynomial is greater!");
                division=firstPoly.division(secondPoly);
                ui.setResultPolyText(division[0].displayToStringForPoliForReal()+ division[1].displayToStringForPoliForReal());

            }
        });*/
    }
}
