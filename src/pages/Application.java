package pages;

import java.io.IOException;

import libs.CommonClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application {
	 static WebDriver driver;
	 CommonClass webElements;
	 WebDriverWait wait;
	 Logger log;
     public CommonClass web;

 public LoginPageByDriver loginPageByDriver;
 public LoginPageByByAnnotation loginPageByAnnotation;
 public RegistrationPageByDriver registrationPageByDriver;
 public RegistrationPageByAnnotation registrationPageByAnnotation;
 public HomePageByDriver homePageByDriver;

 public Application(WebDriver driver) throws IOException {
  web = new CommonClass(driver);
  loginPageByDriver = new LoginPageByDriver(driver);
  loginPageByAnnotation = new LoginPageByByAnnotation(driver);
  registrationPageByAnnotation = new RegistrationPageByAnnotation(driver);
  registrationPageByDriver = new RegistrationPageByDriver();
  homePageByDriver = new HomePageByDriver(driver);
 
  
 }
}

