package com.airbnb.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty7.util.log.Log;

import  pages.Application;

public class Test1SignIn {
 private WebDriver driver;
 //вводим конкретные данные в конкретное поле
 Application airBnB;
 String appURL;

   @Before
   public void setUp() throws Exception {
     driver = new FirefoxDriver();
     airBnB = new Application(driver);
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
   }

   @Test
   public void test1() throws Exception {
	airBnB.web.open("http://airbnb.com");
    
    //HomePage
	airBnB.homePageByDriver.clickButtonSignIn();
    
    //LoginPage
	airBnB.loginPageByDriver.inputLoginEmail("email");
    Log.info("Enter Your Email");
    airBnB.loginPageByDriver.inputPassword("pass");
    airBnB.loginPageByDriver.clickButtonSignIn();
    
   }

   @After
   public void tearDown() throws Exception {
	   airBnB.web.quit();
   }
}