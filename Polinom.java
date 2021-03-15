package com.company.model;
import com.company.BadInput;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Polinom {
    private List<MonomInt> intPolynomList=new ArrayList<MonomInt>();
    private List<MonomReal> realPolynomList=new ArrayList<MonomReal>();
    public List<MonomReal> getRealPolynomList() {
        return realPolynomList;
    }
    public void setRealPolynomList(List<MonomReal> realPolynomList) { this.realPolynomList = realPolynomList; }
    public void setPolynom(List<MonomInt> polynomList) { this.intPolynomList = polynomList; }
    public List<MonomInt> getPolynomList() {
        return intPolynomList;
    }
    public Polinom() {}
    /* I added the type argument for the cases when the coefficient after the operation is a real number, and in this
    way I can treat also the case for real numbers.
    And type=1 means that the input can have a real coefficient after performing an operation
    type=1 means that the coefficient is an integer number
    */
    public void PolinomTest(String userTestInput,int type) {
        /*This function main role is to parse the user input and replace all the possible errors that can appear by introducing the wrong input
        And also the regex is constructed in such a way that it can catch the coefficient(with the sign also) and the power.
         */
        String str = new String();
        str = str.replaceAll(" ", "");
        str = str.replaceAll("x\\+ ", "x^1+");
        str = str.replaceAll("\\+-", "-");
        str = str.replaceAll("x", "x^1");
        Pattern pattern = Pattern.compile("([+-]\\d+)[xX]\\^(\\d+)");
        Matcher matcher = pattern.matcher(userTestInput);
        while (matcher.find()) {
            if(type ==0){
            int coeff = Integer.parseInt(matcher.group(1));
            int power = Integer.parseInt(matcher.group(2));
            MonomInt newMonomInt = new MonomInt(coeff, power);
            this.getPolynomList().add(newMonomInt);}
            else
            {
                double coeffD = Double.parseDouble(matcher.group(1));
                 int power = Integer.parseInt(matcher.group(2));
                MonomReal newMonomReal = new MonomReal(coeffD, power);this.getRealPolynomList().add(newMonomReal);
            }
        }
    }
    public void sortDecreasing(){
    /*
    * this function is made for sorting the polynomials in decreasing order by their power*/

        Collections.sort(intPolynomList, new Comparator<Monom>() {
            public int compare(Monom o1, Monom o2) {
                if(o1.getPower()<o2.getPower())
                    return 1;
                else
                        if(o1.getPower()==o2.getPower())
                                return 0;
                return -1;
            }
        });
        //return intPolynomList;
    }
    /* I added the type argument for the cases when the coefficient after the operation is a real number, and in this
  way I can treat also the case for real numbers,otherwise it will message me an error*/
    public Polinom transformToPolinom(String readPolynom,int type) throws BadInput
    {
        /*
        This function helps me to transform the string introduced by the user into the Polinom type. I used regex for deleting all the
        possible spaces in order to be easier to catch the power and the coefficient.
         */
        Polinom polinom=new Polinom();String textPolinom=readPolynom;
        try {
            textPolinom = textPolinom.replaceAll("\\s", "");
            if (textPolinom.charAt(0) == '+') { textPolinom = textPolinom.substring(1);}
            else
                if (textPolinom.charAt(0) == '-'){ textPolinom = textPolinom.substring(0); }
            for(String str:textPolinom.split("\\+")) // here I split the polynomial by the plus sign
            {
                int coeff=0;double coeffReal=0.0;int power=0;
                int varPos=str.indexOf("x");int powPos=str.indexOf("^");//catching the position of ^and x
                coeff=Integer.parseInt(str.substring(0,varPos));power=Integer.parseInt(str.substring(powPos+1));
                coeffReal=Double.parseDouble(str.substring(0,varPos));
                if(coeff==0 && power ==0) {
                    //if these 2 variables are 0 it means that the parsing wasn`t successful
                    JOptionPane.showMessageDialog(null,"Please enter valid data!");throw new BadInput("Baaaad input"); }
                if(coeffReal==0.0 && power==0)
                {
                    JOptionPane.showMessageDialog(null,"Please enter valid data!");throw new BadInput("Baaaad input for real numbers"); }
                if(coeff!=0&& type ==0) {
                    //i checked the type so I can add it to the corresponding list
                    MonomInt currMonom=new MonomInt(coeff,power);polinom.getPolynomList().add(currMonom); }
                else
                    if(coeffReal!=0 && type==1) {
                        MonomReal currMonomReal=new MonomReal(coeff,power);polinom.getRealPolynomList().add(currMonomReal); }
            }
        }
        catch (Exception badInput)
        {
            JOptionPane.showMessageDialog(null,"Please enter valid data!");throw new BadInput("Baaaad Input!!");
        }return polinom; }
    public MonomInt seeIfDegreeExists(int degree)
    {
        /*
            Function used to know if a power is missing or not from a polynomial
         */
        MonomInt degreeMonom=null;
        for(MonomInt monom:this.getPolynomList())
        {
            if(monom.getPower()==degree)
                degreeMonom=monom;
        }
        return degreeMonom;
    }
    List<String> stringList=new ArrayList<String>();
    public String displayToStringForPoli()
    {
        /*
        This function is used for making the polynomial to be displayed as a string.
        I used a list so it is easier to store the monomial we want to transform, then using a regular expression I eliminate the possible
        commas that can appear during printing the polynomial
         */
        for(MonomInt currMonom:this.getPolynomList())
            {
                stringList.add(currMonom.ToStringIntForMonom(currMonom.getPower()));
            }
        String stringListRes;
        stringListRes=stringList.toString().replaceAll("\\, ","");
        return stringListRes.substring(1,stringListRes.length()-1);

    }
    public String displayToStringForPoliForReal()
    {/*
    This function is identical to the other one, just this is for printing real numbers
    */
        for(MonomReal currMonom:this.getRealPolynomList())
        {
            stringList.add(currMonom.ToStringRealForMonom(currMonom.getPower()));
        }
        String stringListRes;
        stringListRes=stringList.toString().replaceAll("\\,","");
        return stringListRes.substring(1,stringListRes.length()-1);

    }
    public Polinom add(Polinom poli1,Polinom poli2)
    {
        /*
            Here i trvaerse the second polynomial to add to the first one. Also,using a function(written above) I verify if the current
            degree from the first polynomial exists in the second one. If yes,then i add them together, otherwise I add to the list just the
            monomial from the second polynomial
         */
        Polinom sum= new Polinom();
        sum=poli1;
        for(MonomInt currMonon:poli2.getPolynomList())
        {
            int degreeSecPoli=currMonon.getPower();
            int coeffSecPoli=currMonon.getCoeffInt();
            MonomInt findMonom=sum.seeIfDegreeExists(degreeSecPoli);
            if(findMonom!=null)
            {
                findMonom.setCoeffInt(findMonom.getCoeffInt()+coeffSecPoli);
            }
            else
            {
                sum.getPolynomList().add(currMonon);
            }
        }
        return sum;
    }
        public Polinom subtract(Polinom poli1,Polinom poli2)
    {
        /*
            Here i trvaerse the second polynomial to subtract from  the first one. Also,using a function(written above) I verify if the current
            degree from the first polynomial exists in the second one. If yes,then i subtract one from another, otherwise I add to the list just the
            monomial from the second polynomial
         */
        Polinom subtract= new Polinom();
        subtract=poli1;
        for(MonomInt currMonon:poli2.getPolynomList())
        {
            int degreeSecPoli=currMonon.getPower();
            int coeffSecPoli=currMonon.getCoeffInt();
            MonomInt findMonom=subtract.seeIfDegreeExists(degreeSecPoli);
            if(findMonom!=null)
            {
                findMonom.setCoeffInt(findMonom.getCoeffInt()-coeffSecPoli);
            }
            else
            {
                currMonon.setCoeffInt(-coeffSecPoli);
                currMonon.setPower(degreeSecPoli);
                subtract.getPolynomList().add(currMonon);

            }
        }
        return subtract;
    }
    public Polinom derivation(Polinom poli1)
    {
        /*
            Here I make three cases(even though the second one is not very possible to happen)
            1.the degree is positive
            2.the degree is negative
            3.the degree is zero.
            For the first two cases the result is interpreted in the same wasy and obeying the same rule.And for the third case we just
            display the coefficient as being zero.
         */
        Polinom derivationPoliom= new Polinom();
        for(MonomInt currMonon:poli1.getPolynomList())
        {
            int degreeSecPoli=currMonon.getPower();
            int coeffSecPoli=currMonon.getCoeffInt();
            if(degreeSecPoli>0) {
                currMonon.setCoeffInt(degreeSecPoli * coeffSecPoli);
                currMonon.setPower(degreeSecPoli - 1);
            }
            else
                if(degreeSecPoli<0) {
                    currMonon.setCoeffInt(degreeSecPoli * coeffSecPoli);
                    currMonon.setPower(degreeSecPoli - 1);
                }
                else
                    currMonon.setCoeffInt(0);
            derivationPoliom.getPolynomList().add(currMonon);
        }
        return derivationPoliom;
    }
    public Polinom multiplication(Polinom poli1,Polinom poli2)
    {
        /*
        Here I traverse the second polynomial, and check if the degree of the current power from the first polynomial is present in the
        second, and if so then we add the power and multiply the coefficients. If the degree is not found, the we simply append it
        to the polynomial list
         */
        Polinom multiplication= new Polinom();
        for(MonomInt currMonon:poli1.getPolynomList())
        {
            int degreeSecPoli=currMonon.getPower();
            int coeffSecPoli=currMonon.getCoeffInt();
            for (MonomInt currMonom1:poli2.getPolynomList()) {
                int degreeCopyPoly1=currMonom1.getPower();
                int coeffCopyPoly1=currMonom1.getCoeffInt();
                int finalPower=degreeSecPoli+degreeCopyPoly1;
                int finalCoeff=coeffSecPoli*coeffCopyPoly1;
                MonomInt findMonom=multiplication.seeIfDegreeExists(finalPower);
                if(findMonom!=null)
                {
                    findMonom.setCoeffInt(findMonom.getCoeffInt()+finalCoeff);
                }
                else
                {
                    multiplication.getPolynomList().add(new MonomInt(finalCoeff,finalPower));
                }
            }

        }
        return multiplication;
    }
    public Polinom integration(Polinom poli1)
    {
        /*
            I traverse the polynomial gave it as argument and in the case of the degree being zero,then the coefficient is not changed ,but in
            the second case we divide the current coefficient by the degree+1 and then add it to the list (the one for real numbers)
         */
        Polinom integrationPolinom= new Polinom();
        for(MonomReal currMonon:poli1.getRealPolynomList())
        {
            int degreeSecPoli=currMonon.getPower();
            double coeffSecPoli=currMonon.getCoeffReal();
            if(degreeSecPoli==0) {
                currMonon.setCoeffReal(coeffSecPoli);
                currMonon.setPower(degreeSecPoli + 1);
            }
            else
            {
                double nextCoeff=coeffSecPoli/(degreeSecPoli+1);
                currMonon.setCoeffReal(nextCoeff);
                currMonon.setPower(degreeSecPoli + 1);
            }
            integrationPolinom.getRealPolynomList().add(currMonon);
        }
        return integrationPolinom;
    }
    /*public  Polinom copy()
    {
        Polinom currPolinom=new Polinom();
        for(MonomInt monom:this.getPolynomList())
            currPolinom.getPolynomList().add(monom);
        return  currPolinom;
    }
    public MonomReal maxDegree()
    {
        int maxPower=-10000;
        double maxCoeff;
        MonomReal newRealMonom=new MonomReal();
        for(MonomReal r:this.getRealPolynomList())
            if((r.getCoeffReal()!=0.0) && (r.getPower()> maxPower))
            {
                maxPower=r.getPower();maxCoeff=r.getCoeffReal();newRealMonom.setCoeffReal(maxCoeff);newRealMonom.setPower(maxPower);
            }
        return  newRealMonom;
    }*/
    }

