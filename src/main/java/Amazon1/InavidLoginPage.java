package Amazon1;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import AmazonUtils.DataForInvalid;

public class InavidLoginPage extends DataForInvalid
{
	WebDriver driver;
	String un2; String pwd2;
    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	SoftAssert soft = new SoftAssert();
	
	//homepage
	@FindBy (xpath = "//button[.='Continue shopping']") WebElement continueshopping;
    @FindBy(xpath = "//span[@class='nav-line-2 ']") WebElement accountandlist;
    @FindBy(xpath = "//a[.='Start here.']") WebElement newuser;
	@FindBy(xpath = "//span[.='Sign in']") WebElement sign_inlink;
	
	//loginpage
	@FindBy(xpath = "//input[@name='email']") WebElement username;	
	@FindBy(className = "a-button-input") WebElement contiunebutton;	
	@FindBy(xpath = "//input[@id='ap_password']") WebElement password;	
	@FindBy(xpath = "//span[@id='auth-signin-button']") WebElement logIn;	
	
	//homepage
	@FindBy(xpath = "//span[.='Hello, Anuja']") WebElement helloAnuja;
	
	//step 2
	public void contshopping()
	{
		try
		{if (driver == null) {
            System.err.println("WebDriver is null in loginwithDDT BEFORE Page Object creation!");
        }
		continueshopping.click();
		}
		catch(java.lang.NullPointerException e)
		{
			Reporter.log("Exception is handaled");
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is handaled");
		}
	}
	public void hoveroveraccountandlist(WebDriver driver)
	{
		wait.until(ExpectedConditions.visibilityOf(accountandlist));
		Actions a1 = new Actions(driver);
		a1.moveToElement(accountandlist).perform();
		//accountandlist.click();
		
	}
	public void signinfromhoverover()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(sign_inlink));
		sign_inlink.click();
		}
		catch(java.lang.NullPointerException e)
		{
			Reporter.log("Exception is handaled");
		}
	}
	
	public void uninvalid(WebDriver driver, String un2) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(username));
	    username.sendKeys(un2+Keys.ENTER);
	}
	public void continuefromUN() throws InterruptedException
	{
		contiunebutton.click();
		Assert.assertTrue(true);
	}
	public void pwdinvalid(WebDriver driver, String pwd2) throws InterruptedException
	{
	    password.sendKeys(pwd2+Keys.ENTER);
	}
	public void signin() throws InterruptedException
	{
		Thread.sleep(2000);
		logIn.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(helloAnuja));
		boolean isHelloAnujaDisplayed = false;
		if(isHelloAnujaDisplayed == false) {
		Assert.assertFalse(isHelloAnujaDisplayed, "Hello Anuja element should not be displayed for invalid account.");
	    }
		else {
			Reporter.log("Login is fail due to invalid password");
		}
		
	}
	
	public void verifyAccountInvalid() throws InterruptedException
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(helloAnuja));
		boolean isHelloAnujaDisplayed = false;
		Assert.assertFalse(isHelloAnujaDisplayed, "Hello Anuja element should not be displayed for invalid account.");
	}
	
	public InavidLoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
