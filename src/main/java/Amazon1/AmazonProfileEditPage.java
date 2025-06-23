package Amazon1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class AmazonProfileEditPage 
{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	SoftAssert soft = new SoftAssert();

	//login and Security Card Edit
	@FindBy(xpath="//div[.='Your Account']") WebElement youraccount;
	@FindBy(xpath="//div[@data-card-identifier=\"SignInAndSecurity\"]") WebElement loginAndSecurityCard;
	@FindBy(id="input-box-otp") WebElement optInput;
	@FindBy(xpath="//span[.=\"Submit code\"]") WebElement submitCodeBtn;
	
	//Edit existing address Your Address
	@FindBy(linkText = "                         Your Addresses                     ") WebElement yourAddress;
	@FindBy(linkText = "Edit") WebElement edit;
	@FindBy(xpath = "//span[.='Edit addresses for orders and gifts']") WebElement editaddress;
	@FindBy(linkText = "Set as Default") WebElement setdefault;
	@FindBy(xpath = "//h4[.='Default address changed']") WebElement defaultselected;//set default address
	
	//to add new address
	@FindBy(linkText = "Add address") WebElement addnewaddress; //to add new address
	

	
	public void goToYourAccount()
	{
		try {
		wait.until(ExpectedConditions.visibilityOf(youraccount));
		youraccount.click();
		}
		catch(java.lang.NullPointerException e) {
			
		}
	}
	public void clickingyouraddress()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(yourAddress));
            yourAddress.click();
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is Handeled");
		}
		catch(java.lang.NullPointerException e)
    	{
    		Reporter.log("Exception is handeled");
    	}
	}
	public void clickingoneditaddress()
	{
		try {
		editaddress.click();
		soft.assertEquals(driver.getTitle(), "Your Addresses");
		}
		catch(org.openqa.selenium.NoSuchElementException e)
    	{
    		Reporter.log("Exception is handeled");
    	}
		catch(java.lang.NullPointerException e)
    	{
    		Reporter.log("Exception is handeled");
    	}
	}
	public void settingdefault()
	{
		try {
		setdefault.click();
		}
		catch(org.openqa.selenium.NoSuchElementException e)
    	{
    		Reporter.log("Exception is handeled");
    	}
	}
	public void defaultsettingdone()
	{
		defaultselected.isDisplayed();
		soft.assertEquals(defaultselected.isDisplayed(), true);
	}
	public void loginAndSecurityCardClick()
	{
		wait.until(ExpectedConditions.visibilityOf(loginAndSecurityCard));
		loginAndSecurityCard.click();
	}
	
	public void optInputSendKeys()
	{
		wait.until(ExpectedConditions.visibilityOf(optInput));

		//optInput.sendKeys("107306");
	}
	
	public void submitCodeBtnClick()
	{
		wait.until(ExpectedConditions.visibilityOf(submitCodeBtn));
		submitCodeBtn.click();
	}
	
	public AmazonProfileEditPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
