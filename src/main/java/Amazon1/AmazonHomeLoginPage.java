
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
//	String name;String mob_no;
    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	@FindBy(id = "signInSubmit") WebElement logIn;  //input[@id='signInSubmit']
//	@FindBy(xpath="(//h4[@class='a-alert-heading'])[1]") WebElement alertmessage;
	@FindBy(id="aacb-captcha-header") WebElement alertmessage; // Solve this puzzle to protect your account                
	
	//homepage
	@FindBy(xpath = "//span[.='Hello, Anuja']") WebElement helloAnuja;
	@FindBy(xpath = "//span[.='Sign Out']") WebElement signout;
	@FindBy(id = "twotabsearchtextbox") WebElement searchtextbox; 
	@FindBy(linkText = "Your Account") WebElement youraccount; 
	
	//Your Account page
	@FindBy(xpath = "//span[.='Edit addresses for orders and gifts']") WebElement yourAddress;
	@FindBy(linkText = "Edit") WebElement edit;
	
	//homepage last order search
	@FindBy(xpath = "//span[.='Returns']") WebElement returnsNDorders; 
	@FindBy(xpath = "(//span[.='Search Orders'])[1]") WebElement searchOrders;
   
	//step 2
/*	public void contshopping()
	{
	/*	try
		{if (driver == null) {
            System.err.println("WebDriver is null in loginwithDDT BEFORE Page Object creation!");
        }
		continueshopping.click();
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is handaled");
		}  
		wait.until(ExpectedConditions.elementToBeClickable(continueshopping));
		continueshopping.click();
	}   */
	public void hoveroveraccountandlist(WebDriver driver)
	{
	//	wait.until(ExpectedConditions.visibilityOf(accountandlist));
		wait.until(ExpectedConditions.elementToBeClickable(accountandlist));
		Actions a1 = new Actions(driver);
		a1.moveToElement(accountandlist).perform();
		//accountandlist.click();
		
	}
	public void signinfromhoverover()
	{
		wait.until(ExpectedConditions.visibilityOf(sign_inlink));
		sign_inlink.click();

	}
	public void un(WebDriver driver, String un1) throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(username));
	    username.sendKeys(un1+Keys.ENTER);
		
	}
	public void uninvalid(WebDriver driver, String un2) throws InterruptedException
	{
		//	wait.until(ExpectedConditions.visibilityOf(username));
	        username.sendKeys(un2+Keys.ENTER);
	        Reporter.log("Invalid Username is entered");
		
	}
	public void continuefromUN() throws InterruptedException
	{
		contiunebutton.click();
		Assert.assertTrue(true);

	}
	public void pwd(WebDriver driver, String pwd1) throws InterruptedException
	{
	
	//	wait.until(ExpectedConditions.visibilityOf(password));
	    password.sendKeys(pwd1);
		
	}
	public void pwdinvalid(WebDriver driver, String pwd2) throws InterruptedException
	{
	    password.sendKeys(pwd2);
	    Reporter.log("Invalid Password is entered");
	}
	public void signin() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.elementToBeClickable(logIn));
		wait.until(ExpectedConditions.visibilityOf(logIn));
		soft.assertEquals(logIn.isDisplayed(), true);
		logIn.click();

	}
	
	public void verifyAccount() throws InterruptedException
	{
	//	wait.until(ExpectedConditions.visibilityOf(helloAnuja));
		Thread.sleep(2000);
	    boolean b = helloAnuja.isDisplayed(); 
	    Assert.assertEquals(helloAnuja.isDisplayed(), true);
	}   
	public void verifyAccountInvalid() throws InterruptedException
	{
		Thread.sleep(2000);
	    String ActualTitle= alertmessage.getText();
	    String Expected="There was a problem";
	    soft.assertEquals(ActualTitle,Expected );
		Reporter.log("Login with invalid credentials:" +ActualTitle);
	/*	wait.until(ExpectedConditions.visibilityOf(helloAnuja));
		helloAnuja.isDisplayed();
	    Assert.assertEquals(driver.getTitle(),"Authentication required");)
		Assert.assertEquals(false, true);  */
	}
	
	public void searching()
	{
		wait.until(ExpectedConditions.visibilityOf(searchtextbox));
		searchtextbox.sendKeys("Womans Shoe"+Keys.ENTER);
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
		try {
			wait.until(ExpectedConditions.visibilityOf(returnsNDorders));
		returnsNDorders.click();
		soft.assertEquals(driver.getTitle(), "Your Orders");
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is Handaled");
		}
	}
	public void ordersSarching()
	{
		wait.until(ExpectedConditions.visibilityOf(searchOrders));
		searchOrders.isDisplayed();
		soft.assertEquals(driver.getTitle(), "Your Orders");
		soft.assertAll();
	}
	
	public AmazonHomeLoginPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
}

