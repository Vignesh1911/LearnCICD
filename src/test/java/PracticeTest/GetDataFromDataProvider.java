package PracticeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromDataProvider {
	
	@Test(dataProvider = "getData")

	public void GettingDataFromDataProvider(String userEmail, String userPassword, String productToSelect) {
		String WebsiteURL = "https://rahulshettyacademy.com/client/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(WebsiteURL);

		driver.findElement(By.id("userEmail")).sendKeys(userEmail);
		driver.findElement(By.id("userPassword")).sendKeys(userPassword);
		driver.findElement(By.id("login")).click();
		
		List<WebElement> productsInBlocks = driver.findElements(By.cssSelector(".mb-3"));
		
		for (WebElement product : productsInBlocks) {
			String productName = product.findElement(By.cssSelector("b")).getText();
			
			if(productName.equalsIgnoreCase(productToSelect)) {
				product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}	
		}
		driver.quit();
}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"vignesh.civil1@gmail.com", "Baava@1120", "ADIDAS ORIGINAL"},{"vignesh.civil1@gmail.com", "Baava@1120", "IPHONE 13 PRO"}};
	}
}