package AutomationLearning.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationLearning.AbstractComponents.AbstractComponent;

public class ProductSelectionPage extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductSelectionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElement will take care of Constructing the Driver Argument. 
	}

//	List<WebElement> productTextStream = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> productTextStream; //PageFactory Method
	
	By addToCartButton = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".toast-message");


	public List<WebElement> getProductList() {
		return productTextStream;
	}
	
	public WebElement getProductName(String productName) {
		WebElement identifiedProductBox = productTextStream.stream().filter(element -> element.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return identifiedProductBox;
	}
	
	public void addProductToCart(String productName) {
		WebElement identifiedProductBox = getProductName(productName);
		identifiedProductBox.findElement(addToCartButton).click();
		waitForElementToAppear(toastMessage);
		goToCartPage();
	}
	

}
