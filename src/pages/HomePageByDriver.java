// вводим какие то данные в конктертное поле
package pages;

import java.io.IOException;

import libs.CommonClass;

import org.openqa.selenium.WebDriver;

public class HomePageByDriver {
	static  WebDriver driver;
	CommonClass webElements;

	public HomePageByDriver(WebDriver driver) throws IOException {
		this.driver = driver;
		 webElements = new CommonClass(driver);
	}
			
	 public void clickButtonSignUp() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		 webElements.clickButton("HomePage.buttonRegistation");
}
	 public void clickButtonSignIn() throws ClassNotFoundException, IllegalAccessException, ReflectiveOperationException, IOException	{
		 webElements.clickButton("HomePage.buttonSignIn");
	 }
	 
	 public void clickButtonRegisterUsingEmail() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException	{
		 webElements.clickButton("HomePage.buttonRegisterUsingEmail");
	 }
}