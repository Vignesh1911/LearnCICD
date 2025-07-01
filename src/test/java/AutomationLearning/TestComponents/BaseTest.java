package AutomationLearning.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import AutomationLearning.SeleniumFramework.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	
	public void DriverInitializing() throws IOException {
		
		Properties propObject = new Properties();
		FileInputStream fileInpStreamObject = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\AutomationLearning\\resources\\GlobalData.properties");
		propObject.load(fileInpStreamObject);
		String browserName = propObject.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.out.println("Executing in firefox Browser");
		}	

		else if(browserName.equalsIgnoreCase("edge")) {
			System.out.println("Executing in edge Browser");
		}
}

}