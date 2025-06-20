package AmazonUtils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ITestListernsForTC implements ITestListener
{
	public static WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        Reporter.log("Test execution started - Listener");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test case passed: " + result.getMethod().getMethodName());

   
    }

    @Override
    public void onTestFailure(ITestResult result) 
    {
        Reporter.log("Test case failed: " + result.getMethod().getMethodName());
        //add screenshot logic to take screenshot

   
    }


    @Override
    public void onFinish(ITestContext context) {
        Reporter.log("Test execution finished - Listener");
    }

}
