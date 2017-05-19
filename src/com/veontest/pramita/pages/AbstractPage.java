package com.veontest.pramita.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class AbstractPage{

    protected final AndroidDriver<AndroidElement> driver;

    public AbstractPage(AndroidDriver<AndroidElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void getScreeShots(String imagePath) throws IOException{
    	File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(imageFile, new File(imagePath), true);
    }
}