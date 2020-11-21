package concepts.framework.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import resources.ExtentReportsNG;

public class TestListeners extends BaseClass implements ITestListener {
	ExtentReports extent=ExtentReportsNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		
		
		String testName=result.getMethod().getMethodName();
		test=extent.createTest(testName);
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());//to attach error logs
		WebDriver driver=null;
		String testcaseName=result.getMethod().getMethodName();
		try
		{
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotOfTestFailures(testcaseName, driver), testcaseName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
