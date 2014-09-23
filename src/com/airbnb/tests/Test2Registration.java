package com.airbnb.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.Application;

public class Test2Registration {
 private WebDriver driver;
 Application airBnB;

   @Before
   public void setUp() throws Exception {
     driver = new FirefoxDriver();
     airBnB = new Application(driver);
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }

   @Test
   public void test1() throws Throwable {
	   airBnB.web.open("http://ru.airbnb.com");
	   
        //HomePage
	   airBnB.homePageByDriver.clickButtonSignUp();
	   airBnB.homePageByDriver.clickButtonRegisterUsingEmail();
    
    //RegistrationPage
    
    airBnB.registrationPageByDriver.inputName("biba");
    airBnB.registrationPageByDriver.inputSurname("boba");
    airBnB.registrationPageByDriver.inputEmail("sarnavskyi89+1@gmail.com");
    airBnB.registrationPageByDriver.inputPassword("jajaja");
    airBnB.registrationPageByDriver.inputconfirmPassword("jajaja");
    airBnB.registrationPageByDriver.clickSighUpLink();
        
   }

   @After
   public void tearDown() throws Exception {
	   airBnB.web.quit();
   }
}