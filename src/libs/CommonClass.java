// ¬ведение какие данные в какое то поле
package libs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

import static libs.ConfigData.ui;

import java.util.Set;

public class CommonClass {
 WebDriver driver;
 Logger log;

 public CommonClass(WebDriver driver) throws IOException {
  this.driver = driver;
  log = Logger.getLogger(CommonClass.class);
 }
 
 /*
  * This method is used to input some text in some text field
  */
 public void inputText(String text, String xpathLocator) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException	{
	 WebElement textField = driver.findElement(ui(xpathLocator));
	 textField.clear();
	 textField.sendKeys(text);
 }
 
 public void waitForSomeTime (long miliSeconds) throws InterruptedException {
	 Thread.sleep(miliSeconds);
 }

 /*
  * This method is used to click on element and open new tab and switch on it
  */
 public void clickOnElementAndSwitchToNewTab(String locator) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
	  Set<String> oldWindowsSet = driver.getWindowHandles();
	   driver.findElement(ui(locator)).click();
	   Set<String> newWindowsSet = driver.getWindowHandles();
	   newWindowsSet.removeAll(oldWindowsSet);
	   String newWindowHandle = newWindowsSet.iterator().next();
	   String windowHandler = driver.getWindowHandle();
	   driver.switchTo().window(newWindowHandle);
	 }
 
 /*
  *Format of fileLocationAndFormat should be next "c:\\tmp\\screenshot.png"
  **/
 public void makeScreenShot(String fileLocationAndFormat) {
  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  // Now you can do whatever you need to do with it, for example copy somewhere
  try {
   FileUtils.copyFile(scrFile, new File(fileLocationAndFormat));
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
 
 /*
  * This method is used to click on some button
  */
 
 public void clickButton(String buttonLocator) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException	{
	 // WebElement button = driver.findElement(By.xpath(buttonLocator));
	 WebElement button;
	 button = driver.findElement(ui(buttonLocator));
	 button.click();
	  }
 
 
 
 /*
  * This method is used to select radio button block
  */
 
 public void selectRadioButtonfromBlock(String radioButtonName, String radioButtonLocator) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException	{
	 WebElement radioButton = driver.findElement(ui(radioButtonLocator));
	 radioButton.click();
 }
 
 
 /*
  * This method is used to select radiobutton from block
  * */
 public void selectRadiobuttonFromBlock(String radioBtnName, String blockLocator) {
  String radiobuttonXpath = blockLocator+"[contains(text(), '"+radioBtnName+"')]";
  WebElement radioButton = driver.findElement(By.xpath(radiobuttonXpath));
  radioButton.click();
 }
 
 /*
  *This method is used to select from drop-down list by first focus on list 
  * */
 
 public void selectFromListByFocus(String listValue, String listLocator) {
	  WebElement list;
	  list = driver.findElement(By.xpath(listLocator));
	  new Actions(driver).moveToElement(list).perform();
	  new Select(list).selectByVisibleText(listValue);
 }
 
 /*
  * This method is used to click link by text 
 */
 public void clickLinkByText(String linkText) {
  WebElement link;
  link = driver.findElement(By.linkText(linkText));
  link.click();
 }

 
 /*
  * This method is used to select sub menu from main menu of dropdawn list. (used inly xpath_locators)
  */
 
 public void selectSubmenuFromMainMenuByAllXpathes(String dropDownLocator, String mainMenuLocator, 
		   String mainMenuItem, String subMenuLocator, String subMenuItem) {
		  WebElement dropDown;
		  //WebElement mainMenuItem;
		  //WebElement subMenuItem;
		  //List <WebElement> mainMenu = new ArrayList<WebElement>();
		  WebElement mainMenu;
		  WebElement subMenu;
		  
		  dropDown = driver.findElement(By.xpath(dropDownLocator));
		  //mainMenuItem = driver.findElement(By.xpath(mainMenuLocator));
		  mainMenu = driver.findElement(By.xpath(mainMenuLocator));
		  //subMenuItem = driver.findElement(By.xpath(subMenuLocator));
		  subMenu = driver.findElement(By.xpath(subMenuLocator));
		  
		  dropDown.click();
		  
		  new Select(mainMenu).selectByVisibleText(mainMenuItem);
		  //mainMenuItem.click();
		  
		  new Select(subMenu).selectByVisibleText(subMenuItem);
		  //subMenuItem.click();
		 }
 

 /*
  * This method is used to select string from a list
  */
 
 public void selectFromList(String listLocator, String listValue) throws IOException, ClassNotFoundException,
 	InstantiationException, IllegalAccessException {
	WebElement list;
	list = driver.findElement(By.xpath(listLocator));
	new Select(list).selectByVisibleText(listValue);
 }
 
 /*
  * This method is used to select\ unselect checkbox
  */
 
 public void selectCheckBox(String checkboxState, String checkboxLocator) {
	  WebElement checkbox;
	  checkbox = driver.findElement(By.xpath(checkboxLocator));
	  if (checkbox.isSelected() && checkboxState.equals("YES")) {
	   System.out.println("Checkbox is already selected");
	  }
	  if (!checkbox.isSelected() && checkboxState.equals("NO")) {
	   System.out.println("Checkbox isn't selected");
	  }
	  if (checkbox.isSelected() && checkboxState.equals("NO")) {
	   checkbox.click();
	   System.out.println("Checkbox is already selected");
	  }
	  if (!checkbox.isSelected() && checkboxState.equals("YES")) {
	   checkbox.click();
	   System.out.println("Checkbox is already selected");
	  }
 }
 
 
		 
 /*
  * This method is used to click and after focus on a drop dawn sub menu
  */
 
		 public void clickFocusClick(String dropDownLocator, String mainMenuLocator, 
		   String mainMenuText, String subMenuLocator, String subMenuText) {
		  WebElement dropDown;
		  WebElement mainMenu;
		  WebElement mainMenuItem;
		  WebElement subMenu;
		  String mainMenuItemXpath;
		  
		  dropDown = driver.findElement(By.xpath(dropDownLocator));
		  mainMenu = driver.findElement(By.xpath(mainMenuLocator));
		  subMenu = driver.findElement(By.xpath(subMenuLocator));
		  
		  mainMenuItemXpath = mainMenuLocator+"[contains(text(), '"+mainMenuText+"')]"; 
		  mainMenuItem = driver.findElement(By.xpath(mainMenuItemXpath));
		  
		  dropDown.click();
		  new Actions(driver).moveToElement(mainMenuItem).perform();
		  new Select(subMenu).selectByVisibleText(subMenuText);
		 }

				 
		 /*
		  * Method is used to check that element is present on page.
		  */
		 public boolean isElementPresent(By elementLocator) {
		  try {
		   driver.findElement(elementLocator);
		  } catch (org.openqa.selenium.NoSuchElementException Ex) {
		   return false;
		  }
		  return true;
		 }
		 
		 /*
		  * Open URL in a browser 
		  */
		 public void open(String url) throws ClassNotFoundException, IOException,
		   InstantiationException, IllegalAccessException {
		  driver.manage().window().maximize();
		  driver.get(url);
		 // driver.switchTo().frame(o); // if test open frame with application comment this string
		 }
		 
		 /*
		  * this method is used to quit WebDriver
		  */
public void quit()	{
	driver.quit();
}

/*
 * this method is used to upload image on site, if load used to upload JS
 */
public void uploadImageUsingJS(String inputLocator, String pathToImage) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
	  WebElement inputField;
	  // create a WebElement
	  inputField = driver.findElement(ui(inputLocator));
	  // initialize WebElement
	  inputField.sendKeys(pathToImage);
	 }
	 
	 public void uploadProfileImage() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
	  uploadImage("ProfileImage.field", "c:\\Users\\Public\\Pictures\\Sample Pictures\\image.jpeg");
}
	      /*
		  * This method is used to wait for getting response from all Ajax requests
		  */
		 public boolean waitForAjaxResponse(int timeoutSeconds) throws InterruptedException {
		  if (driver instanceof JavascriptExecutor) {
		   JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

		   for (int i = 0; i < timeoutSeconds; i++) {
		    Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");
		    if (numberOfConnections instanceof Long) {
		     log.debug("Number of active jQuery Ajax calls is <" + numberOfConnections + ">");

		     if (numberOfConnections == 0)
		      break;
		    }
		    // stay(1);
		   }
		   return false;
		  } else {
		   log.info("Web Driver: <" + driver + "> cann't execute JavaScript");
		   return false;
		  }
		  }
		  public void uploadImage(String inputLocator, String pathToImage) throws ClassNotFoundException,
		   IllegalAccessException, InstantiationException, IOException {
		  // create a WebElement
		  WebElement inputField;
		  //initialize WebElement
		  inputField = driver.findElement(ui(inputLocator));
		  
		  // create JS executor
		  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		  //make element visible (changing type of element to text)
		  jsExecutor.executeScript("arguments[0].style.type = 'text';", inputField);
		  //send image to input tag
		  inputField.sendKeys(pathToImage);
		 }
}
