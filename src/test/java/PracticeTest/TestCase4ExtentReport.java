package PracticeTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(utils.ListenerForExtentReport.class)
public class TestCase4ExtentReport {
	
	public static WebDriver driver;
	
	@BeforeClass

	public void WebsiteLogin() {
		String WebsiteURL = "https://rahulshettyacademy.com/angularpractice/";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		driver.findElement(By.cssSelector("a[href='/angularpractice/shop']")).click();
}
	
	@Test
	public void TestCase1() {
		WebElement iPhone = driver.findElement(By.cssSelector("app-card:nth-child(1)"));
		String a = iPhone.findElement(By.xpath(".//h4/a")).getText();
		iPhone.findElement(By.className("btn-info")).click();
		System.out.println(a);
	}
	
	@Test
	public void TestCase2() {
		WebElement samsung = driver.findElement(By.cssSelector("app-card:nth-child(2)"));
		String b = samsung.findElement(By.xpath(".//h4/a")).getText();
		samsung.findElement(By.className("btn-inf")).click();
		System.out.println(b);
	}
	
	@Test
	public void TestCase3() {
		WebElement nokia = driver.findElement(By.cssSelector("app-card:nth-child(3)"));
		String c = nokia.findElement(By.xpath(".//h4/a")).getText();
		nokia.findElement(By.className("btn-info")).click();
		System.out.println(c);
	}
	
	@Test
	public void TestCase4() {
		WebElement blackBerry = driver.findElement(By.cssSelector("app-card:nth-child(4)"));
		String d = blackBerry.findElement(By.xpath(".//h4/a")).getText();
		blackBerry.findElement(By.className("btn-inf")).click();
		System.out.println(d);
	}

	
	@AfterClass
	public void tearDown() {
	    driver.quit();
	}
	
}