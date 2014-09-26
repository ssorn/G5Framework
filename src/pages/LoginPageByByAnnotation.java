package pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static libs.ConfigData.ui;

public class LoginPageByByAnnotation {
	
	private WebDriver driver;
	Logger log;
	
	public LoginPageByByAnnotation(WebDriver driver)  {
		  this.driver = driver;
		  log = Logger.getLogger(LoginPageByByAnnotation.class);
		  PageFactory.initElements(driver, this);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
	

	 /**
     * This method is used to click on button enter from Facebook
     */
    @FindBy(xpath = ".//a[@class='fb-button fb-blue btn icon-btn btn-block btn-large large padded-btn-block row-space-1 btn-facebook']")
    private WebElement buttonEnterFromFacebook;
	
    /**
     * This method is used to click on button enter from Google Plus
     */
    @FindBy(xpath = ".//a[@class='btn icon-btn btn-block btn-large large padded-btn-block row-space-1 btn-google']")
    private WebElement buttonEnterFromGooglePlus;
	
	/**
     * This method is used to input email in email field
     */
    @FindBy(xpath = ".//a[@class='fb-button fb-blue btn icon-btn btn-block btn-large large padded-btn-block row-space-1 btn-facebook']")
    private WebElement fieldEmail;
    
    
    /**
     * This method is used to input password in password field
     */
    @FindBy(xpath = ".//*[@id='signin_password']")
    private WebElement fieldPassword;
    
    /**
     * This method is used to click on SignIn button
     */
    @FindBy(xpath = ".//*[@class='btn btn-block btn-primary large btn-large padded-btn-block']")
    private WebElement buttonSignIn;
   
    /**
     * This method is used to click on checkbox Remember Me
     */
    @FindBy(xpath = ".//*[@id='remember_me2']")
    private WebElement checkboxRememberMe;
   
    
}
