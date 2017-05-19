package com.veontest.pramita.utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileDriver {
	public AndroidDriver<AndroidElement> androidDriver;
	private String deviceName;
	private String appPackage;
	private String appActivity;
	private String phoneUUID;
	private String serverAddress;
	private String portAddress;
	
	public MobileDriver(String serverAddress, 
						String portAddress, 
						String phoneUUID,
						String appPackage,
						String appActivity,
						String deviceName) throws Exception {
		 try{
			 this.serverAddress = serverAddress;
			 this.portAddress = portAddress;
			 this.phoneUUID = phoneUUID;
             this.appPackage = appPackage;
             this.appActivity = appActivity;
             this.deviceName = deviceName;
             createAndroidDriver();
         }
         catch (Exception e){
             dispose();
             throw e;
         }
	}	

    protected void createAndroidDriver() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("uuid", phoneUUID);
        androidDriver =  new AndroidDriver<AndroidElement>(new URL("http://"+serverAddress+":"+portAddress+"/wd/hub"), capabilities);
    }
    
    public void dispose(){
        if (androidDriver != null){
        	androidDriver.closeApp();
        	androidDriver.quit();
        }
    }
}
