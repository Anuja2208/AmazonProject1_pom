package Amazon1;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import AmazonUtils.TestData_Regi;

public class AmazonRegiPage extends TestData_Regi
{
	WebDriver driver;
	SoftAssert soft = new SoftAssert();
//	String un1; String pwd1;
//	String name;String mob_no;

	@FindBy(xpath = "//input[@id='ap_customer_name']") WebElement username;
	@FindBy(xpath = "//input[@id='ap_phone_number']") WebElement phonenumber;
	@FindBy(xpath = "//input[@id='ap_password']") WebElement password;
	@FindBy(xpath = "//span[@id='auth-continue']") WebElement verifymobileno;
//	@FindBy(xpath = "//span[@id='auth-continue']") WebElement authenticationiframe;
	@FindBy(linkText = "            Privacy Notice") WebElement privacyNotice;
	@FindBy(id="aacb-captcha-header") WebElement alertmessage; // Solve this puzzle to protect your account 

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public void addusername(WebDriver driver,String un1)
	{
		username.sendKeys(un1+Keys.ENTER);

	}
	public void addphoneno(WebDriver driver,String mob_no)
	{
		phonenumber.sendKeys(mob_no+Keys.ENTER);
	}
	public void addpassword(WebDriver driver,String pwd1)
	{
		password.sendKeys(pwd1);
	}
	public void mobileverification() throws InterruptedException
	{
		Thread.sleep(1000);
		verifymobileno.click();
		wait.until(ExpectedConditions.visibilityOf(alertmessage));
		String ActualTitle= alertmessage.getText();
		 String Expected="Solve this puzzle to protect your account";                //"There was a problem";
		 soft.assertEquals(ActualTitle,Expected );
	}
	public void authenticationpage()
	{
	//	privacyNotice.isDisplayed();
	//	Assert.assertEquals(privacyNotice.isDisplayed(), true);
	}
	

	public AmazonRegiPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
