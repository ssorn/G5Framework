package pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 
public class RegistrationPageByAnnotation {
 
 
    private WebDriver driver;
    Logger log;
    
    public RegistrationPageByAnnotation(WebDriver driver)  {
		  this.driver = driver;
		  log = Logger.getLogger(LoginPageByByAnnotation.class);
		  PageFactory.initElements(driver, this);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
 
    /**
     * This method is used to input name in name field
     */
    @FindBy(xpath = ".//*[@id='inputFirst']/input")
    private WebElement nameField;
 
    /**
     * Method below is used to input Surname of user in surname filed
     */
    @FindBy(xpath = ".//*[@id='inputLast']/input")
    private WebElement surNameField;
 
    /**
     * This method is used to input Email in Email field
     */
    @FindBy(xpath = ".//*[@id='inputEmail']/input")
    private WebElement emailField;
      
 
    /**
     * This method is used to input password in password field
     */
    
    @FindBy(xpath = ".//*[@id='inputPassword']/input")
    private WebElement PasswordField;
    
 
    /**
     * This method is used to input confirm password in Confirm password field
     */
    @FindBy(xpath = ".//*[@id='inputConfirmPassword']/input")
    private WebElement ConfirmPasswordField;
    
 
    /*
     * this method is clicking on SignUp button on registration page 
     */
    @FindBy(xpath = ".//*[@class='btn btn-primary btn-block btn-large large padded-btn-block']")
    private WebElement signUpButton;

    
    /*
     * this method is used to input name in name field name by (Using Annotation)
     */
    public void inputName(String name) {
		nameField.clear();
		nameField.sendKeys(name);
		}
    
    /*
     * this method is used to input surname in name field by surname (Using Annotation)
     */
    
    public void inputSurname(String surname)	{
    	surNameField.clear();
    	surNameField.sendKeys(surname);
    }
    
    public void inputEmail(String email)	{
    	emailField.clear();
    	emailField.sendKeys(email);
    }
    
    public void inputPassword(String password)	{
    	PasswordField.clear();
    	PasswordField.sendKeys(password);
    }
    
    public void inputConfirmPassword(String confirmpassword) {
    	ConfirmPasswordField.clear();
    	ConfirmPasswordField.sendKeys(confirmpassword);
    }
}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  