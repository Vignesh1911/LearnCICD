package PracticeTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromHashMap {
	
	@Test(dataProvider = "getData")

	public void GettingDataFromHashMap(HashMap<String, String> inputFromHashMap) {
		String WebsiteURL = "https://rahulshettyacademy.com/client/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(WebsiteURL);

		driver.findElement(By.id("userEmail")).sendKeys(inputFromHashMap.get("userEmail"));
		driver.findElement(By.id("userPassword")).sendKeys(inputFromHashMap.get("userPassword"));
		driver.findElement(By.id("login")).click();
		
		List<WebElement> productsInBlocks = driver.findElements(By.cssSelector(".mb-3"));
		
		for (WebElement product : productsInBlocks) {
			String productName = product.findElement(By.cssSelector("b")).getText();
			
			if(productName.equalsIgnoreCase(inputFromHashMap.get("productToSelect"))) {
				product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}	
		}
		driver.quit();
}
	
	@DataProvider
	public Object[][] getData() {
		
		HashMap<String, String> hashMapObjectTestOne = new HashMap<String, String>();
		hashMapObjectTestOne.put("userEmail", "vignesh.civil1@gmail.com");
		hashMapObjectTestOne.put("userPassword", "Baava@1120");
		hashMapObjectTestOne.put("productToSelect", "ADIDAS ORIGINAL");
		
		HashMap<String, String> hashMapObjectTestTwo = new HashMap<String, String>();
		hashMapObjectTestTwo.put("userEmail", "vignesh.civil1@gmail.com");
		hashMapObjectTestTwo.put("userPassword", "Baava@1120");
		hashMapObjectTestTwo.put("productToSelect", "IPHONE 13 PRO");
		
		return new Object[][] {{hashMapObjectTestOne},{hashMapObjectTestTwo}};
	}
}