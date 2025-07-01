import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportsDemo extends Listeners{
	
	static ExtentReports ExtentReportsObject;
	
	@BeforeTest
	public void config() {
		// Two Important Class to Generate Reports is ExtentReports and ExtentSparkReporter
		String reportPath = System.getProperty("user.dir")+"\\ExtentReports\\index.html"; //ExtentSparkReporter will be expecting to send a path where the report has to be stored. It has to be an HTML File.
		ExtentSparkReporter ExtentSparkReporterObject = new ExtentSparkReporter(reportPath); //Sending the path here through Object Creation. reports Object will be able to do all config changes in the report.
		
		ExtentSparkReporterObject.config().setReportName("Automation Results");
		ExtentSparkReporterObject.config().setDocumentTitle("Test Automation");
		
		//ExtentReports extent = new ExtentReports(); //This class will be responsible for creating all the reports and ExtentSparkReporter is a Sub-Class.
		
		//ExtentReports extent = new ExtentReports();
		ExtentReportsObject = new ExtentReports();
		ExtentReportsObject.attachReporter(ExtentSparkReporterObject);
		ExtentReportsObject.setSystemInfo("Automation Tester", "Vignesh");
	
	}


@Test
	public static ExtentReports OpenWebPage() {
	
		ExtentReportsObject.createTest("Open Web Page"); //Moved to Listener Class. If not, it has to be here.
	
		String WebsiteURL = "https://rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		System.out.println(driver.getTitle());
		driver.close();
		ExtentReportsObject.flush(); //Moved to Listener Class.
		
		return ExtentReportsObject;
	}

}
