package Amazon1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class AmazonBaseClass 
{
   WebDriver driver;
   public String browserName;
   
   @Parameters("browser")
   @BeforeMethod
public void browserLaunch(String browserName)
{
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
	    Reporter.log("Chrome browser is launched succesfully");
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //Synchronization
	
	//Assert.assertEquals(driver.getTitle(), "Amazon.in: Online Shopping India - Buy mobiles, laptops, cameras, books, watches, apparel, shoes and e-Gift Cards. Free Shipping & Cash on Delivery Available.");
}
    @AfterMethod
    public void browserQuit() 
    {
     
          //  driver.quit();
        }

}
