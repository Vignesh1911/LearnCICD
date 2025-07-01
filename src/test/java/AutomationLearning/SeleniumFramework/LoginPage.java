package AutomationLearning.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationLearning.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElement will take care of Constructing the Driver Argument. 
	}

//	WebElement userEmailElement = driver.findElement(By.id("userEmail")); //Declaring in Normal Method
	
	//WebElement userPasswordElement = driver.findElement(By.id("userPassword"));
	
	@FindBy(id = "userEmail")
	WebElement userEmailElement; //PageFactory Method
	
	@FindBy(id = "userPassword")
	WebElement userPasswordElement; 
	
	@FindBy(id = "login")
	WebElement clickLoginButton;
	
	public void openURL(String WebsiteURL) {
		driver.get(WebsiteURL);
	}
	
	public void loginApplication(String userEmail, String userPassword) {
		userEmailElement.sendKeys(userEmail);
		userPasswordElement.sendKeys(userPassword);
		clickLoginButton.click();
	}

}
