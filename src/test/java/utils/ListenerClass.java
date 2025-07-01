package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import PracticeTest.TestCase3ScreenShotListener;

public class ListenerClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed - " + result.getName());

        WebDriver driver = TestCase3ScreenShotListener.driver; // Must be public static
        ScreenshotUtil.takeScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed - " + result.getName());
    }
}
