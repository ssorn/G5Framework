package com.airbnb.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import libs.ExcelDriver;
import libs.ConfigData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import  pages.Application;

public class TestWithExelData {
 private WebDriver driver;
 Application appName;
 String appUrl;
 static Map<String, String> data = new HashMap<String, String>();

   @Before
   public void setUp() throws Exception {
     driver = new FirefoxDriver();
     appName = new Application(driver);
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     appUrl = ConfigData.getCfgValue("APPLICATION_URL");
     data=ExcelDriver.getData("src/testData.xls", "LoginIntoApp");
   }

   @Test
   public void test1() throws Exception {
    appName.web.open(appUrl);
    
    //HomePage
    appName.homePage.clickMyProfileLink();
    
    //LoginPage
    appName.loginPageByDriver.loginUser(data.get("login"), data.get("password"));
    
   }

   @After
   public void tearDown() throws Exception {
 //   appName.web.quit();
   }
}