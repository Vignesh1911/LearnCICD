package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import PracticeTest.TestCase4ExtentReport;

public class ListenerForExtentReport implements ITestListener {

    ExtentReports extent = ExtentReportManager.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "This Test Case has PASSED");
        System.out.println(result.getName() + " - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        extentTest.get().log(Status.FAIL, "This Test Case has FAILED");
        // Take screenshot
        String screenshotPath = ScreenShotUtilForExtentReport.captureScreenshot(TestCase4ExtentReport.driver, result.getName());
        extentTest.get().addScreenCaptureFromPath(screenshotPath);
        
        System.out.println(result.getName() + " - FAILED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Write everything to the report
    }
}
