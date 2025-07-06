package Amazon1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import AmazonUtils.ITestListernsForTC;

public class AmazonBaseClass 
{
   public WebDriver driver;
   public String browserName;
   
   @Parameters("browser")
   @BeforeMethod
public void browserLaunch(@Optional("Edge")String browserName)
{
	   
	//   ITestListernsForTC.driver = driver;
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
	    Reporter.log("INFO: Chrome browser initialized.", true);
	}
	if(browserName.equalsIgnoreCase("Edge"))
	{
		driver = new EdgeDriver();
	    Reporter.log("Edge browser is launched succesfully");
	}
	if(browserName.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	    Reporter.log("Firefox browser is launched succesfully");
	}
	driver.get("https://www.amazon.in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Synchronization
	
	//Assert.assertEquals(driver.getTitle(), "Amazon.in: Online Shopping India - Buy mobiles, laptops, cameras, books, watches, apparel, shoes and e-Gift Cards. Free Shipping & Cash on Delivery Available.");
}
    @AfterMethod
    public void browserQuit() 
    {
    	if(driver!=null) {
        //   driver.quit();
    	}
    }

}
