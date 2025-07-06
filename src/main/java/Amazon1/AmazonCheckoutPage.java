package Amazon1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
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

public class AmazonCheckoutPage 
{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	SoftAssert soft = new SoftAssert();
	
	//select address-select payment method
	@FindBy(name = "proceedToRetailCheckout") WebElement proceedToBuy;
	@FindBy(xpath = "//a[@aria-label='Change delivery address']") WebElement changeAddress;
	@FindBy(xpath = "//span[@id='checkout-primary-continue-button-id-announce']") WebElement delivertothisaddress;
	@FindBy(xpath="//input[@name='ppw-instrumentRowSelection']") List<WebElement> paymentoptions;
	@FindBy(xpath = "//input[contains(@value, 'COD')") WebElement cod;
	@FindBy(xpath = "//span[@id='checkout-primary-continue-button-id-announce']") WebElement usethisPayMethodBtn;
	@FindBy(xpath="//a[@class='a-link-normal expand-panel-button']") WebElement revieworder;
	
	//validate payment method
//	@FindBy(xpath = "//input[@type='radio' and contains(@value, 'APB')]\") W") WebElement amazonPayBalancebox;
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[1]") WebElement amazonPayBalancebox;
	@FindBy(xpath = "//div[@class='a-row a-spacing-top-small']/input") WebElement enterCode;  //amazonPayBalanceboxpayment code
	@FindBy(xpath = "//input[@name='ppw-claimCodeApplyPressed']") WebElement apply;   //Applying amazon coupon code 
	@FindBy(xpath = "(//div[@class='a-alert-content'])[2]") WebElement errormsgAfterapply;   
	@FindBy(xpath = "(//input[contains(@value, 'SelectableAddCreditCard'") WebElement creditdebitcardbox;
	@FindBy(xpath="//input[contains(@value, 'NetBanking')]") WebElement netbankingbox;
	@FindBy(xpath="//input[contains(@value, 'UnifiedPaymentsInterface')]") WebElement otherUPIbox;
	@FindBy(xpath="//input[contains(@value, 'EMI')]") WebElement emibox;	
//	@FindBy(xpath="//span[@id='checkout-primary-continue-button-id']") WebElement usethispaymentmethod;


	
    public void clickingProccedToBuy(WebDriver driver) 
    {
        proceedToBuy.click();
    }
    public void clickingChangeAdderess(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(changeAddress));
        changeAddress.click();
    }
    public void clickingDelivertoThisAdderess(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(delivertothisaddress));
    	delivertothisaddress.click();
    }
    public void paymentmethods()
	{  
		int paymentoptionssize=paymentoptions.size();
		Reporter.log("Total payment options : " +paymentoptionssize);
		for(int i=0;i<paymentoptionssize;i++)
		{
			 WebElement option = paymentoptions.get(i);
			 wait.until(ExpectedConditions.visibilityOf(option));
			 if (option.isDisplayed() && option.isEnabled()) {
	                option.click();
	                wait.until(ExpectedConditions.elementToBeClickable(option));
	               Reporter.log( "Payment option " +i +" is clickable");
			 }
		}     
		}
    public void selectingCOD(WebDriver driver) 
    {
    //	wait.until(ExpectedConditions.visibilityOf(cod));
    	boolean b = cod.isDisplayed();
    	boolean b1 = cod.isEnabled();
    	if(b&&b1 == true) {
    		 cod.click();
    		 Reporter.log("COD payment option is selected");
    	}
    	else {
    		Reporter.log("The cod is not selected");
    	}
       
    }
    public void selectingamazonPayBalancebox(WebDriver driver) throws InterruptedException 
    {
    	wait.until(ExpectedConditions.visibilityOf(amazonPayBalancebox));
    	amazonPayBalancebox.isEnabled();
    	soft.assertEquals(amazonPayBalancebox.isEnabled(), true);
    	amazonPayBalancebox.click();
    	boolean b = amazonPayBalancebox.isSelected();
    	if(b == true) {
    	//	wait.until(ExpectedConditions.visibilityOf(enterCode));
    	//	Assert.assertEquals(enterCode.isDisplayed(), true);
    		Thread.sleep(1000);
        	enterCode.sendKeys("123456");
        	Thread.sleep(1000);
        	apply.click();
        	errormsgAfterapply.isDisplayed();
        	String erroractual = errormsgAfterapply.getText();
        	String errorexpected = "The promotional code you entered is not valid.";
        //	Assert.assertEquals(errormsgAfterapply.isDisplayed(), true);
        	//Assert.assertEquals(erroractual, errorexpected);
        	}
    	else {
    		Thread.sleep(1000);
    		amazonPayBalancebox.click();
    		Thread.sleep(1000);
        	Assert.assertEquals(enterCode.isDisplayed(), true);
        //	enterCode.sendKeys("123456");
        	Thread.sleep(1000);
        	apply.click();
        	errormsgAfterapply.isDisplayed();
        	String erroractual = errormsgAfterapply.getText();
        	String errorexpected = "The promotional code you entered is not valid.";
        //	Assert.assertEquals(errormsgAfterapply.isDisplayed(), true);
       // 	Assert.assertEquals(erroractual, errorexpected);
    	}
    }
    public void couponcode()
	{
		wait.until(ExpectedConditions.visibilityOf(amazonPayBalancebox));
	//	amazonPayBalancebox.click();
		Assert.assertEquals(enterCode.isDisplayed(), true);
	//	enterCode.sendKeys("123456");
		apply.click();
		errormsgAfterapply.isDisplayed();
    	Assert.assertEquals(errormsgAfterapply.isDisplayed(), true);
	}
 
    public void selectingcreditdebitcardbox() 
    {
    	creditdebitcardbox.isEnabled();
    	soft.assertEquals(creditdebitcardbox.isEnabled(), true);
    //	creditdebitcardbox.click();
    }
    public void selectingnetbankingbox(WebDriver driver) 
    {
    //	wait.until(ExpectedConditions.visibilityOf(netbankingbox));
    	netbankingbox.click();
        soft.assertEquals(netbankingbox.isEnabled(), true);
      //netbankingbox.click() ; 
    }
    public void selectingotherUPIbox(WebDriver driver) 
    {
    //	wait.until(ExpectedConditions.visibilityOf(otherUPIbox));
    	otherUPIbox.isEnabled();
        soft.assertEquals(otherUPIbox.isEnabled(), true);
      //  otherUPIbox.click();
    }
    public void selectingemibox(WebDriver driver) 
    {
    //	wait.until(ExpectedConditions.visibilityOf(emibox));
    	emibox.isEnabled();
        soft.assertEquals(emibox.isEnabled(), true);
      //  emibox.click();
    }
    public void clickOnusethisPayMethodBtn(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(usethisPayMethodBtn));
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", usethisPayMethodBtn);
    //	usethisPayMethodBtn.click();
    }
    public void reviewingorder1()
	{
		wait.until(ExpectedConditions.visibilityOf(  revieworder));
		assertEquals(  revieworder.isDisplayed(),true);
		revieworder.click();
	}
    
	public AmazonCheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}