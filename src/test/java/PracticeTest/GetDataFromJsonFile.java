package PracticeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromJsonFile extends DataReaderFromJsonFile {
	
	@Test
    public void runTestWithJsonData() throws IOException, InterruptedException  {
		DataReaderFromJsonFile reader = new DataReaderFromJsonFile();
        List<HashMap<String, String>> gettingDataFromJsonClassFile = reader.getDatafromJsonFile();

        for (HashMap<String, String> data : gettingDataFromJsonClassFile) {
            GettingDataFromHashMap(data);
        }
    }

	public void GettingDataFromHashMap(HashMap<String, String> inputFromHashMap) throws InterruptedException {
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
		Thread.sleep(700);
		driver.quit();
}

	
}