package Amazon1;

import java.time.Duration;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class AmazonProfileEditPage 
{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	SoftAssert soft = new SoftAssert();
	

	//login and Security Card Edit
	@FindBy(xpath="//span[.='Your Account']") WebElement youraccount;
	@FindBy(xpath="//div[@data-card-identifier=\"SignInAndSecurity\"]") WebElement loginAndSecurityCard;
	@FindBy(xpath="//a[@aria-label='Edit name']") WebElement editName;
	@FindBy(id="ap_customer_name") WebElement editingName;
	@FindBy(xpath="//span[@id='a-autoid-0']") WebElement saveChange;
	@FindBy(id="SUCCESS_MESSAGES") WebElement nameUpdated;  //verify
	@FindBy(id="input-box-otp") WebElement optInput;
	@FindBy(xpath="//span[.=\"Submit code\"]") WebElement submitCodeBtn;
	
/*	//Edit existing address Your Address
	@FindBy(linkText = "(//div[@class='a-column a-span9 a-span-last'])[4]") WebElement yourAddress;
	@FindBy(xpath = "Edit") WebElement edit;
	@FindBy(xpath = "//span[.='Edit addresses for orders and gifts']") WebElement editaddress;
	@FindBy(linkText = "Set as Default") WebElement setdefault;
	@FindBy(xpath = "//h4[.='Default address changed']") WebElement defaultselected;//set default address
	
	//to add new address
	@FindBy(linkText = "Add address") WebElement addnewaddress; //to add new address
	
	*/
	public void goToYourAccount(WebDriver driver)
	{
		wait.until(ExpectedConditions.visibilityOf(youraccount));
		youraccount.click();
	}
/*	public void clickingyouraddress()
	{
	//	wait.until(ExpectedConditions.visibilityOf(yourAddress));
        yourAddress.click();
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
	}   */
	public void loginAndSecurityCardClick()
	{
	//	wait.until(ExpectedConditions.visibilityOf(loginAndSecurityCard));
		loginAndSecurityCard.click();
	}
	public void clickOneditName()
	{
	//	wait.until(ExpectedConditions.visibilityOf(editName));
		editName.click();
		
	}
	public void editingNewName()
	{
	//	wait.until(ExpectedConditions.visibilityOf(editingName));
		editingName.clear();
		editingName.sendKeys("Anuja");
		
	}
	public void savingNameChange()
	{
		saveChange.click();
		
	}
	public void verifyNameUpdated()
	{
		boolean b = nameUpdated.isDisplayed();
		Assert.assertEquals(nameUpdated.isDisplayed(), true);
		
	}
/*	public void optInputSendKeys()
	{
		wait.until(ExpectedConditions.visibilityOf(optInput));
		//optInput.sendKeys("107306");
	}
	
	public void submitCodeBtnClick()
	{
		wait.until(ExpectedConditions.visibilityOf(submitCodeBtn));
		submitCodeBtn.click();
	}
	*/
	public AmazonProfileEditPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}