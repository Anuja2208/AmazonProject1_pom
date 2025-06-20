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
	
	@FindBy(xpath="//div[.='Your Account']") WebElement youraccount;

	@FindBy(xpath="//div[@data-card-identifier=\"SignInAndSecurity\"]") WebElement loginAndSecurityCard;
	
	@FindBy(id="input-box-otp") WebElement optInput;
	
	@FindBy(xpath="//span[.=\"Submit code\"]") WebElement submitCodeBtn;
    
	@FindBy(xpath = "//span[.='Edit addresses for orders and gifts']") WebElement yourAddress;
	
	//@FindBy(linkText = "Edit") WebElement edit;
	
	@FindBy(xpath = "//span[.='Edit addresses for orders and gifts']") WebElement editaddress;
	
	@FindBy(linkText = "Set as Default") WebElement setdefault;
	
	@FindBy(xpath = "//h4[.='Default address changed']") WebElement defaultselected;//h4[.='Default address changed']

	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	SoftAssert soft = new SoftAssert();

	public void goToYourAccount()
	{
		wait.until(ExpectedConditions.visibilityOf(youraccount));
		youraccount.click();
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
	
	}
	public void clickingoneditaddress()
	{
		editaddress.click();
		soft.assertEquals(driver.getTitle(), "Your Addresses");
	}
	public void settingdefault()
	{
		setdefault.click();
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
