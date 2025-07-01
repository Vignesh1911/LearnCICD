package AutomationLearning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement clickCartButton;
	
	@FindBy(css = "[routerlink='/dashboard/myorders']")
	WebElement clickOrderButton;

	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait explicitWaitObject = new WebDriverWait(driver, Duration.ofSeconds(5)); //Implementing EXPLICIT Wait to see if the message is getting displayed
	    WebElement message = explicitWaitObject.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		explicitWaitObject.until(ExpectedConditions.visibilityOf(message));
	}
	
	public void goToCartPage() {
		clickCartButton.click();
	}
	
	public void goToOrderPage() {
		clickOrderButton.click();
	}


}
