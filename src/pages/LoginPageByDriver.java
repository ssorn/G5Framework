package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static libs.ConfigData.ui;
import libs.CommonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;


public class LoginPageByDriver {
 static WebDriver driver;
 CommonClass webElements;
 WebDriverWait wait;
 Logger log;

 
  
 public LoginPageByDriver(WebDriver driver) throws IOException {
  this.driver = driver;
  log = Logger.getLogger(LoginPageByDriver.class);
  webElements = new CommonClass(driver);
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Waiting for some parameter present
  wait = new WebDriverWait(driver, 5);
  
 }
 
 /*
 *	This Method is used to input email in LoginEmail field
 */
 
 public void inputLoginEmail(String email) throws ReflectiveOperationException, IllegalAccessException, InstantiationException, IOException	{
	 webElements.inputText(email, "LogInPage.emailField");
	// wait.until(ExpectedConditions.textToBePresentInElementLocated(ui("LoginPage.emailField"), email));
 }
 
 /*
  * This method is used to input Password in password field on SignIn Page
 */
 
 public void inputPassword(String password) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
	 webElements.inputText(password, "LogInPage.passwordField");
	 
 }
  
 /*
  * This method is used to click on SignIn button on LoginIn page
  */
 
 public void clickButtonSignIn() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException	{
	 webElements.clickButton("LogInPage.buttonSignin");
	 
 }
 
 /*
  * This method is used to click on checkbox "Remember me" on SignInPage
  */
 
 public void clickCheckBoxRememberMe()	{
	 webElements.selectCheckBox("", "LogInPage.buttonSignin");
 }
 
 /*
  * this method is used to input email in field email and input password in field password, after it 
  * clicking on button SignIn
  */
// public void loginRun(){
//	  inputLoginEmail(email);
//	  inputPassword(password);
//	  clickButtonSignIn();
	 }
