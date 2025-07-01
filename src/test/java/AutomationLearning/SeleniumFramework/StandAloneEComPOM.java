package AutomationLearning.SeleniumFramework;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationLearning.AbstractComponents.AbstractComponent;
import AutomationLearning.TestComponents.BaseTest;

public class StandAloneEComPOM extends BaseTest {
	

	static WebDriver driver;
	static String WebsiteURL = "https://rahulshettyacademy.com/client";
	static String userEmail = "vignesh.civil1@gmail.com";
	static String userPassword = "Baava@1120";
	static String productName = "ADIDAS ORIGINAL";
	static String countryToClick = "Uruguay";
	static String successMessage = "THANKYOU FOR THE ORDER.";

	
	@Test(dataProvider = "getData")

	public static void OpenWebPage(String userEmail, String userPassword, String productName) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.openURL(WebsiteURL);
		loginPageObject.loginApplication(userEmail, userPassword);
		
		AbstractComponent abstractClassObject = new AbstractComponent(driver);
		abstractClassObject.waitForElementToAppear(By.cssSelector(".mb-3"));
		
		ProductSelectionPage productPageObject = new ProductSelectionPage(driver);
		productPageObject.getProductList();
		productPageObject.getProductName(productName);
		productPageObject.addProductToCart(productName);
		
		CartPage cartPageObject = new CartPage(driver);
		Boolean productMatch = cartPageObject.VerifyProductsSelected(productName);
		Assert.assertTrue(productMatch);
		cartPageObject.ClickCheckOut();
		
		CheckoutPage checkOutPageObject = new CheckoutPage(driver);
		checkOutPageObject.TypeCountryName();
		checkOutPageObject.CountryToClick(countryToClick);
		ConfirmationPage ConfirmationPageObject = checkOutPageObject.clickConfirmButton();
		ConfirmationPageObject.SuccessMessageValidation(successMessage);
		
}

	@Test(dependsOnMethods = {"OpenWebPage"})
	
	public void CheckOrderHistoryTest() throws InterruptedException {
		AbstractComponent abstractClassObject = new AbstractComponent(driver);
		abstractClassObject.goToOrderPage();
	}
	
	
	@AfterTest
	public void TearDownTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"vignesh.civil1@gmail.com", "Baava@1120", "ADIDAS ORIGINAL"},{"vignesh.civil1@gmail.com", "Baava@1120", "IPHONE 13 PRO"}};
	}
	
	public static void main(String[] args) throws InterruptedException {
		//OpenWebPage();
		driver.quit();
	}
	
}
