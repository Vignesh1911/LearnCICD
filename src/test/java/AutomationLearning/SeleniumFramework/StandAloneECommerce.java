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

public class StandAloneECommerce {
	
	static WebDriver driver;
	static String userEmail = "vignesh.civil1@gmail.com";
	static String userPassword = "Baava@1120";
	static String productName = "ADIDAS ORIGINAL";
	static String countryToClick = "Uruguay";
	static String successMessage = "THANKYOU FOR THE ORDER.";

	public static void OpenWebPage() throws InterruptedException {
		String WebsiteURL = "https://rahulshettyacademy.com/client";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(WebsiteURL);
		
	
		
		driver.findElement(By.id("userEmail")).sendKeys(userEmail);
		driver.findElement(By.id("userPassword")).sendKeys(userPassword);
		driver.findElement(By.id("login")).click();
		
		
		
		List<WebElement> productText = driver.findElements(By.xpath("//div/h5"));
		
		for(int i=0; i<productText.size(); i++) {
			String nameOfProduct = productText.get(i).getText();
			if(nameOfProduct.equalsIgnoreCase("ADIDAS ORIGINAL")) {
				System.out.println(nameOfProduct);
			}
		}
		
		productText.stream().map(getNameOfTheProduct -> getNameOfTheProduct.getText()).forEach(System.out::println);
		
		List<WebElement> productTextStream = driver.findElements(By.cssSelector(".mb-3"));
		WebElement identifiedProductBox = productTextStream.stream().filter(element -> element.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		
		identifiedProductBox.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebElement message = driver.findElement(By.cssSelector(".toast-message"));
		driver.findElement(By.cssSelector(".toast-message")).isDisplayed();
		
		String addMessage = driver.findElement(By.cssSelector(".toast-message")).getText();
		System.out.println(addMessage);
		
		WebDriverWait explicitWaitObject = new WebDriverWait(driver, Duration.ofSeconds(5)); //Implementing EXPLICIT Wait to see if the message is getting displayed
		explicitWaitObject.until(ExpectedConditions.visibilityOf(message));
		
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean productMatch = products.stream().anyMatch(cartProducts -> cartProducts.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(productMatch);
		
		driver.findElement(By.cssSelector(".totalRow .btn")).click(); //Traversing with both Class Elements
		
		//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Uru");
		
		Actions actionClassObject = new Actions(driver);
		actionClassObject.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "Uru").build().perform(); //Sending the Input through ACTION Class Method
		
		
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item .ng-star-inserted")); //Using two CLASS names in a same CSS Selector
		
		countries.stream().filter(countryToSelect -> countryToSelect.getText().equalsIgnoreCase(countryToClick)).findFirst().get().click();
		
//		countries.stream().filter(country -> country.getText().equalsIgnoreCase("Uruguay")).findFirst().ifPresent(WebElement::click);
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		String thankYouMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(successMessage, thankYouMessage);
		System.out.println(thankYouMessage);
		}
	
	public static void main(String[] args) throws InterruptedException {
		OpenWebPage();
		driver.quit();
	}
	
}
