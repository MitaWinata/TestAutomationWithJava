package com.veontest.pramita;

import com.veontest.pramita.pages.CalculatorPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Calculator {

    private final AndroidDriver<AndroidElement> driver;

    public Calculator(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public CalculatorPage calculatorPage(){ 
    	return new CalculatorPage(driver);
   }
}