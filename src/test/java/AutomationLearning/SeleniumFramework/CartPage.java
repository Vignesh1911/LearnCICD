package AutomationLearning.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AutomationLearning.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElement will take care of Constructing the Driver Argument. 
	}

	
	@FindBy(css = ".totalRow .btn")
	WebElement CheckOutButton; //PageFactory Method
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> productTitles; 
	
	
	public boolean VerifyProductsSelected(String productName) {
		Boolean productMatch = productTitles.stream().anyMatch(cartProducts -> cartProducts.getText().equalsIgnoreCase(productName));
		return productMatch;
	}
	
	public void ClickCheckOut() {
		CheckOutButton.click();
	}
	

}
