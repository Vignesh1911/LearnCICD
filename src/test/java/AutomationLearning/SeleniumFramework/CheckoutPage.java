package AutomationLearning.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationLearning.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElement will take care of Constructing the Driver Argument. 
	}

	
	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement selectCountry;
	
	public void TypeCountryName() {
		Actions actionClassObject = new Actions(driver);
		actionClassObject.sendKeys(selectCountry, "Uru").build().perform(); //Sending the Input through ACTION Class Method
	}
	
	public void CountryToClick(String countryToClick) {
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item .ng-star-inserted"));
		countries.stream().filter(countryToSelect -> countryToSelect.getText().equalsIgnoreCase(countryToClick)).findFirst().get().click();
	}
	
	public ConfirmationPage clickConfirmButton() {
		placeOrderButton.click();
		return new ConfirmationPage(driver);
	}
}
