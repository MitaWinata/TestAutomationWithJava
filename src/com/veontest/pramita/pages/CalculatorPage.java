package com.veontest.pramita.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculatorPage extends AbstractPage{
	
	 @AndroidFindBy(accessibility = "arg1")
     private MobileElement arg1;
	 
	 @AndroidFindBy(accessibility = "arg2")
     private MobileElement arg2;

	 @AndroidFindBy(accessibility = "result")
     private MobileElement resultField;
	 
	 @AndroidFindBy(accessibility = "division")
     private MobileElement divButton;
	 
	 @AndroidFindBy(accessibility = "subtraction")
     private MobileElement substactButton;
	 
     public CalculatorPage(AndroidDriver<AndroidElement> driver) {
         super(driver);
     }

     public void setArg1(String value) {
    	 arg1.sendKeys(value);
     }
     
     public void setArg2(String value) {
    	 arg2.sendKeys(value);
     }
     
     public void substract(String value1, String value2) {
    	setArg1(value1);
        assertTrue(isArg1OK(value1));
      	setArg2(value2); 
    	assertTrue(isArg2OK(value2));
    	substactButton.click();   	
     }
     
     public void divide(String value1, String value2) {
    	setArg1(value1);
        assertTrue(isArg1OK(value1));
       	setArg2(value2); 
     	assertTrue(isArg2OK(value2));
     	divButton.click();   	
      }
     public void divide(String value) {
    	 arg2.sendKeys(value);
     }
     
     public boolean isArg1OK(String arg1Value) {
         try {
             (new WebDriverWait(driver, 30)).until(
            		 ExpectedConditions.textToBePresentInElement(
            				 arg1, arg1Value));
             return true;
         } catch (TimeoutException e) {

             return false;
         }
     }
     
     public boolean isArg2OK(String arg2Value) {
         try {
             (new WebDriverWait(driver, 30)).until(
            		 ExpectedConditions.textToBePresentInElement(
            				 arg2, arg2Value));
             return true;
         } catch (TimeoutException e) {

             return false;
         }
     }
     public boolean isResultOK(String result) {
         try {
             (new WebDriverWait(driver, 30)).until(
            		 ExpectedConditions.textToBePresentInElement(
            				 resultField, result));
             return true;
         } catch (TimeoutException e) {

             return false;
         }
     }
}
