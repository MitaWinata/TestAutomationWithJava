package com.veontest.pramita.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class DivisionTests extends AbstractTest {

	public DivisionTests() {}
								
    @Test
    public void positiveResultDivision() {
        app.calculatorPage().divide("120", "60");
        assertTrue(app.calculatorPage().isResultOK("2"));  
    }
    @Test
    public void fractionResultDivision() {
        app.calculatorPage().divide("60", "120");
        assertTrue(app.calculatorPage().isResultOK("0.5"));  
    }
    @Test
    public void negativeResultDivision() {
        app.calculatorPage().divide("120", "-60");
        assertTrue(app.calculatorPage().isResultOK("-2"));  
    }
}
