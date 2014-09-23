package pages;

import java.io.IOException;
import libs.CommonClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegistrationPageByDriver	{
 static WebDriver driver;
 CommonClass webElements;
 WebDriverWait wait;
 Logger log;
 
//
// public RegistrationPageByDriver(WebDriver driver) throws IOException {
//  this.driver = driver;
//  WebElements = new CommonClass(driver);
// }

 /*
  * This method is used to input name in name field
  */
 public void inputName (String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
// WebElement nameFiled;
//  nameFiled = driver.findElement(By.xpath(".//*[@id='inputFirst']/input"));
//  nameFiled.clear();
//  nameFiled.sendKeys(name);
	 
  webElements.inputText(name, "RegistrationPage.inputName");  // DZ сменить все икспасі на ключи из uamappingfile
 }

 /*
  * Method below is used to input Surname of user in surname filed
  */
 public void inputSurname (String surname) throws ReflectiveOperationException, IllegalAccessException, InstantiationException, Exception	{
//	 WebElement surnameField;
//	 surnameField = driver.findElement(By.xpath(".//*[@id='inputLast']/input"));
//	 surnameField.clear();
//	 surnameField.sendKeys(surname);
	 webElements.inputText(surname, "RegistrationPage.inputSurname");
 }
 
  /*
  * This method is used to input Email in Email field
  */
 
 public void inputEmail (String email) throws Throwable, Exception, Exception, IOException	{
//	 WebElement emailField;
//	 emailField = driver.findElement(By.xpath(".//*[@id='inputEmail']/input"));
//	 emailField.clear();
//	 emailField.sendKeys(email);
	 	 webElements.inputText(email, "RegistrationPage.inputEmail");
 }
 
	 /*
	  * This method is used to input password in password field
	  */
	 
  public void inputPassword (String password) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException	{
//	  WebElement passwordField;
//	  passwordField = driver.findElement(By.xpath(".//*[@id='inputPassword']/input"));
//	  passwordField.clear();
//	  passwordField.sendKeys(password); 
	  	  webElements.inputText(password, "RegistrationPage.inputPassword");
	 }
 
  /*
   * this method is used to input confirm password in Confirm password field
   */
  public void inputconfirmPassword (String confirmpassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException	{
//	  WebElement passwordConfirm;
//	  passwordConfirm = driver.findElement(By.xpath(".//*[@id='inputConfirmPassword']/input"));
//	  passwordConfirm.clear();
//	  passwordconfirm.sendKeys(confirmPassword);
	  
	  webElements.inputText(confirmpassword, "RegistrationPage.inputPasswordConfirm");
  }
  
  
 /*
  * this method is clicking on check box "Tell me about news AirBNB"
  */
  
  public void selectReceivedNewCheckbox (String checkboxState)	{
	  webElements.selectCheckBox(checkboxState, "RegistrationPage.passwordCheckbox.AbootnewsAirbnb");
  }
//	  WebElement checkboxNews;
//	  checkboxNews = driver.findElement(By.xpath(".//*[@name='user_profile_info[receive_promotional_email]']"));
//	  checkboxNews.click();
 //	  WebElements.clickButton(".//*[@name='user_profile_info[receive_promotional_email]']");
	 
 
  /*
   * this method is clicking on SignUp button on registration page 
   */
  
  public void clickSighUpLink () throws ClassNotFoundException, ReflectiveOperationException, ReflectiveOperationException, IOException	{
//	  WebElement signUplink; 
//	  signUplink = driver.findElement(By.xpath(".//*[@class='btn btn-primary btn-block btn-large large padded-btn-block']"));
//	  signUplink.click();
	  webElements.clickButton("RegistrationPage.checkboxSubmitRegistrationButton");
	  
  }
 
 
  
}