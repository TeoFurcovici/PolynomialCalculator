import com.company.model.MonomInt;
import com.company.model.MonomReal;
import com.company.model.Polinom;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class AddOperationTest {
    @Test
    public  void addTest() {
        Polinom poli1= new Polinom();
        poli1.PolinomTest("+3x^6+3x^3+2x^1+5x^0",0);
        Polinom poli2=new Polinom();
        poli2.PolinomTest("+4x^6+3x^5+-4x^1+9x^0",0);
        Polinom resultAddition= new Polinom();
        resultAddition=poli1.add(poli1,poli2);
        resultAddition.sortDecreasing();
        assertEquals ("+7x^6+3x^5+3x^3-2x^1+14x^0",resultAddition.displayToStringForPoli());
    }
   @Test
    public  void subtractionTest() {
        Polinom poli1= new Polinom();
        Polinom poli2= new Polinom();
        poli1.PolinomTest("+3x^6+3x^3+2x^1+5x^0",0);
        poli2.PolinomTest("+4x^6+3x^5+-4x^1+9x^0",0);
        Polinom resultSubtraction= new Polinom();
        resultSubtraction=poli1.subtract(poli1,poli2);
        resultSubtraction.sortDecreasing();
        assertEquals ("-1x^6+3x^5+3x^3+6x^1-4x^0",resultSubtraction.displayToStringForPoli());
    }
   @Test
    public  void multiplicationTest() {
        Polinom poli1= new Polinom();
        Polinom poli2= new Polinom();
        poli1.PolinomTest("+3x^6+3x^3+2x^1+5x^0",0);
        poli2.PolinomTest("+4x^6+3x^5+-4x^1+9x^0",0);
        Polinom resultMulti= new Polinom();
        resultMulti=poli1.multiplication(poli1,poli2);
        resultMulti.sortDecreasing();
        assertEquals ("+12x^12+9x^11+12x^9+9x^8-4x^7+53x^6+15x^5-12x^4+27x^3-8x^2-2x^1+45x^0",resultMulti.displayToStringForPoli());
    }
    @Test
    public  void derivationFirstPolyTest() {
        Polinom poli1= new Polinom();
        poli1.PolinomTest("+3x^6+3x^3+2x^1+5x^0",0);
        Polinom resultDerivation= new Polinom();
        resultDerivation=poli1.derivation(poli1);
        resultDerivation.sortDecreasing();
        assertEquals ("+18x^5+9x^2+2x^0+0 ",resultDerivation.displayToStringForPoli());
    }
    @Test
    public  void derivationSecondPolyTest() {
        Polinom poli1= new Polinom();
        poli1.PolinomTest("+4x^6+3x^5+-4x^1+9x^0",0);
        Polinom resultDerivation1= new Polinom();
        resultDerivation1=poli1.derivation(poli1);
        resultDerivation1.sortDecreasing();
        assertEquals ("+24x^5+15x^4-4x^0+0 ",resultDerivation1.displayToStringForPoli());
    }
    @Test
    public  void integrationFirstPolyTest() {
        Polinom poli1= new Polinom();
        poli1.PolinomTest("+3x^6+3x^3+2x^1+5x^0",1);
        Polinom resultIntegration= new Polinom();
        resultIntegration=poli1.integration(poli1);
        resultIntegration.sortDecreasing();
        resultIntegration.displayToStringForPoliForReal();
        assertEquals ("+0.42857142857142855x^7+0.75x^4+1.0x^2+5.0x^1",resultIntegration.displayToStringForPoli());
    }
    @Test
    public  void integrationSecondPolyTest() {
        Polinom poli1= new Polinom();
        poli1.PolinomTest("+4x^6+3x^5+-4x^1+9x^0",1);
        Polinom resultIntegrationPoly2= new Polinom();
        resultIntegrationPoly2=poli1.integration(poli1);
        resultIntegrationPoly2.sortDecreasing();
        resultIntegrationPoly2.displayToStringForPoliForReal();
        assertEquals ("+0.5714285714285714x^7+0.5x^6-2.0x^2+9.0x^1",resultIntegrationPoly2.displayToStringForPoli());
    }
}

