package AutomationLearning.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AutomationLearning.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElement will take care of Constructing the Driver Argument. 
	}
	
	
	@FindBy(css = ".hero-primary")
	WebElement messageToValidate; 
	
	public void SuccessMessageValidation(String successMessage) {
		String thankYouMessage = messageToValidate.getText();
		Assert.assertEquals(successMessage, thankYouMessage);
		System.out.println(thankYouMessage);	
	}
	

}