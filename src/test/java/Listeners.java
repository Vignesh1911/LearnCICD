import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	
	ExtentReports ExtentReportsObject = ExtentReportsDemo.OpenWebPage();
	ExtentTest ExtentTestObject ;
	
	@Override
	public void onTestStart(ITestResult result) {
//		ExtentReportsObject.createTest("Open Web Page");
		ExtentReportsObject.createTest(result.getMethod().getMethodName());

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I have successfully Passed"+ result.getName());
		ExtentTestObject.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestObject.log(Status.FAIL, "Test Failed");
		ExtentTestObject.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportsObject.flush();
	}

}
