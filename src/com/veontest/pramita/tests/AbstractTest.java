package com.veontest.pramita.tests;

import java.io.IOException;

import org.junit.*;
import org.junit.rules.TestName;

import com.veontest.pramita.Calculator;
import com.veontest.pramita.utilities.Helper;
import com.veontest.pramita.utilities.MobileDriver;

public abstract class AbstractTest {
      private static MobileDriver mobdriver;
      protected static Calculator app;
      
      private static final String serverAddress = "127.0.0.1";
      private static final String serverPort = "4723";
      private static final String bootstrapPort = "4724";
      private static final String phoneUUID = "4200cb43d3134300";
      private static final String appPackage = "im.getsocial.calc";
      private static final String appActivity = "MainActivity";
      private static final String deviceName = "TestPhone";
  	
      private static final String appLogPath = 
		    		  				System.getProperty("user.dir")
		    		  				+ "\\TestResults\\applicationLog_"
		    		  				+ Helper.getTime()
		    		  				+ ".txt";
      private static final String appiumLog = 
    		  						System.getProperty("user.dir")
    		  						+ "\\TestResults\\appiumLog_"
    		  						+ Helper.getTime()
    		  						+ ".txt";
      
      @Rule 
      public TestName name = new TestName();
       
      @BeforeClass
      public static void setup(){
    	
    	  Helper.StartAppiumServer(serverAddress, 
				    			   serverPort, 
				    			   bootstrapPort,
				    			   phoneUUID, 
				  				   appiumLog);   	  
     	try {
			mobdriver = new MobileDriver(serverAddress,
										serverPort,
										phoneUUID,
										appPackage,
										appActivity,
										deviceName); 
			app = new Calculator(mobdriver.androidDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}		   
      }
      
      @After
      public void afterClass() throws IOException{
    	String imagePath = System.getProperty("user.dir")
					+ "\\TestResults\\"+ name.getMethodName() +".jpg";			
        app.calculatorPage().getScreeShots(imagePath);              
      }
      
      @AfterClass
      public static void tearDown(){
  		mobdriver.dispose();
  		Helper.StopAppiumServer();
  		Helper.GetPhoneLog(appLogPath, appPackage);
      }             
}
