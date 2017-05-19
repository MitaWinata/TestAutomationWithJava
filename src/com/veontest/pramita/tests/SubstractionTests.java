package com.veontest.pramita.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstractionTests extends AbstractTest {
    public SubstractionTests(){}
    
    @Test
    public void positiveResultSubtraction() {
        app.calculatorPage().substract("70", "50");
        assertTrue(app.calculatorPage().isResultOK("20")); 
    }       
 
    @Test
    public void negativeResultSubtraction() {
        app.calculatorPage().substract("50", "70");
        assertTrue(app.calculatorPage().isResultOK("-20")); 
    }
    
    @Test
    public void fractionResultSubtraction() {
        app.calculatorPage().substract("70.8", "50.5");
        assertTrue(app.calculatorPage().isResultOK("20.3")); 
    }
}
