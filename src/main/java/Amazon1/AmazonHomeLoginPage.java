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

import AmazonUtils.Excelsheet;

public class AmazonHomeLoginPage extends Excelsheet
{
    WebDriver driver;
    String un1; String pwd1;
	String un2; String pwd2;
	String name;String mob_no;
    
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
	@FindBy(xpath = "//span[.='Sign Out']") WebElement signout;
	@FindBy(id = "twotabsearchtextbox") WebElement searchtextbox; 
	@FindBy(linkText = "Your Account") WebElement youraccount; 
	
	//Your Account page
	@FindBy(xpath = "//span[.='Edit addresses for orders and gifts']") WebElement yourAddress;
	@FindBy(linkText = "Edit") WebElement edit;
	
	//homepage
	@FindBy(xpath = "//span[.='Returns']") WebElement returnsNDorders; 
	@FindBy(xpath = "(//span[.='Search Orders'])[1]") WebElement searchOrders;
   
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
		try
		{wait.until(ExpectedConditions.visibilityOf(accountandlist));
		Actions a1 = new Actions(driver);
		a1.moveToElement(accountandlist).perform();
		//accountandlist.click();
		}
		catch(java.lang.NullPointerException e)
		{
			Reporter.log("Exception is handaled");
		}
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
	public void un(WebDriver driver, String un1) throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(username));
	    username.sendKeys(un1+Keys.ENTER);
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is Handeled");
		}
		catch(java.lang.NullPointerException e)
		{
			Reporter.log("Exception is Handeled");
		}
		
	}
	public void uninvalid(WebDriver driver, String un2) throws InterruptedException
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(username));
	    username.sendKeys(un2+Keys.ENTER);
		}
		catch(java.lang.NullPointerException e)
		{
			Reporter.log("Exception is Handeled");
		}
	}
	public void continuefromUN() throws InterruptedException
	{
		contiunebutton.click();
		Assert.assertTrue(true);
	}
	public void pwd(WebDriver driver, String pwd1) throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(password));
	    password.sendKeys(pwd1+Keys.ENTER);
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is Handeled");
		}
		catch(java.lang.NullPointerException e)
		{
			Reporter.log("Exception is Handeled");
		}
	}
	public void pwdinvalid(WebDriver driver, String pwd2) throws InterruptedException
	{
	    password.sendKeys(pwd2+Keys.ENTER);
	}
	public void signin() throws InterruptedException
	{
		Thread.sleep(2000);
		
		try {
			logIn.click();
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is Handeled");
		}
	}
	
	public void verifyAccount() throws InterruptedException
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(helloAnuja));
		helloAnuja.isDisplayed();
		Assert.assertEquals(helloAnuja.isDisplayed(), true);
		}
		catch(java.lang.NullPointerException e)
		{
			Reporter.log("Exception is Handeled");
		}
	}
	public void verifyAccountInvalid() throws InterruptedException
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(helloAnuja));
		//helloAnuja.isDisplayed();
		Assert.assertEquals(false, true);
	}
	
	public void searching()
	{
		try {
		wait.until(ExpectedConditions.visibilityOf(searchtextbox));
		searchtextbox.sendKeys("Womans Shoe"+Keys.ENTER);
		}
		catch(java.lang.NullPointerException e) {
			Reporter.log("Exception is Handeled");
		}
	}
	public void logout()
	{
		signout.click();
	}
	
	public void movingtoprofileeditpage() throws InterruptedException
	{
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(youraccount));
		youraccount.click();
	}
	
	public void clickingyouraddress()
	{
		yourAddress.click();
	}
	public void clickingonedit()
	{
		edit.click();
		soft.assertEquals(driver.getTitle(), "Your Addresses");
	}
	public void clickingReturnsAndOrders()
	{
		returnsNDorders.click();
		soft.assertEquals(driver.getTitle(), "Your Orders");
	}
	public void ordersSarching()
	{
		returnsNDorders.isDisplayed();
		soft.assertEquals(driver.getTitle(), "Your Orders");
		soft.assertAll();
	}
	
	public AmazonHomeLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
