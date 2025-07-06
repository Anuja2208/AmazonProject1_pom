package AmazonUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Amazon1.AmazonBaseClass;

public class ITestListernsForTC implements ITestListener
{
	public WebDriver driver;
	
    @Override
    public void onStart(ITestContext context) {
        Reporter.log("Test execution started - Listener");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test case passed: " + result.getMethod().getMethodName());
        
        Object currentClass = result.getInstance();
//	    WebDriver driver = ((AmazonBaseClass).currentClass).driver;
	    String methodName = result.getMethod().getMethodName();
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String screenshotName = methodName + "_" + timeStamp + ".png";
	   
        if(driver!=null){
        	TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		 String className = result.getTestClass().getName();
		    //String methodName = result.getMethod().getMethodName();
		   // String fileName = className + "_" + methodName + " PASS.png";
		// String fileName = className + "  PASS.png";
		    File destination = new File("C:\\Users\\ganesh\\eclipse-workspace\\AmazonProject1\\Screenshots\\Pass\\" + screenshotName);
		try {
			FileHandler.copy(source,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
		Reporter.log("Driver is null so screenshot not captured");
		}
   
    }

    @Override
    public void onTestFailure(ITestResult result) 
    {
        Reporter.log("Test case failed: " + result.getMethod().getMethodName());
        //add screenshot logic to take screenshot
        
        
 /*      TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		 String className = result.getTestClass().getName();
		    //String methodName = result.getMethod().getMethodName();
		    //String fileName = className + "_" + methodName + " FAIL.png";
		    String fileName = className + " FAIL.png";
		    File destination = new File("C:\\Users\\ganesh\\eclipse-workspace\\AmazonProject1\\Screenshots\\Fail\\" + fileName);
		try {
			FileHandler.copy(source,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
  
    }


    @Override
    public void onFinish(ITestContext context) {
        Reporter.log("Test execution finished - Listener");
    }

}
