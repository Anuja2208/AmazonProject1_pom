package Amazon1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AmazonCheckoutPage 
{
	WebDriver driver;

	@FindBy(name="quantityBox")  WebElement quantityBox; //quantityBox
	@FindBy(xpath="//div[@data-action=\"delete-active") WebElement deleteFromCart;
	@FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']") WebElement cart;  //directly cart page
	@FindBy(xpath = "//button[@aria-label='Increase quantity by one']") WebElement increasequantity;
	@FindBy(xpath = "//button[@aria-label='Decrease quantity by one']") WebElement decreasequantity;
	
	@FindBy(name = "proceedToRetailCheckout") WebElement proceedToBuy;
	@FindBy(xpath = "//a[@aria-label='Change delivery address']") WebElement changeAddress;
	@FindBy(xpath = "//span[@id='checkout-primary-continue-button-id-announce']") WebElement delivertothisaddress;
	@FindBy(xpath = "//input[@id='pp-9AxRON-152']") WebElement cod;
	@FindBy(xpath = "//span[@id='checkout-secondary-continue-button-id-announce']") WebElement usethisPayMethodBtn;
	
	@FindBy(xpath = "//input[@id='pp-Fw6YVp-101']") WebElement amazonPayBalancebox;
	@FindBy(xpath = "//input[@id='pp-Fw6YVp-108']") WebElement creditdebitcardbox;
	@FindBy(xpath = "//input[@id='pp-Fw6YVp-114']") WebElement netbankingbox;
	@FindBy(xpath = "//input[@id='pp-Fw6YVp-134']") WebElement otherUPIbox;
	@FindBy(xpath = "//input[@id='pp-Fw6YVp-139']") WebElement emibox;

	 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	SoftAssert soft = new SoftAssert();
	
	public void decreaseQuantityClick()
	{
		//decreaseQuantity.click();
	}
	public void increaseQuantityClick()
	{
		//increaseQuantity.click();
	}
	public void quantityBoxSendKeys(WebDriver driver)
	{
		int quantity = Integer.parseInt(quantityBox.getDomAttribute("value"));
		System.out.println(quantity);
		if(quantity==10)
		{
			Actions a1 = new Actions(driver);
			a1.doubleClick(quantityBox).perform();	
		}
		else
		{
			quantityBox.sendKeys("7");
		}
	}
	public void deleteFromCartClick()
	{
		deleteFromCart.click();
	}
	public void goTOMyCart(WebDriver driver) 
    {
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
    }
    public void clickincreasequantity(WebDriver driver) 
    {
        wait.until(ExpectedConditions.visibilityOf(increasequantity));
        increasequantity.click();
    }
    public void clickdecreasequantity(WebDriver driver) 
    {
        wait.until(ExpectedConditions.visibilityOf(decreasequantity));
        decreasequantity.click();
        decreasequantity.isDisplayed();
        Assert.assertEquals(decreasequantity.isDisplayed(), true);
        Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
    }
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
    public void selectingCOD(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(cod));
        cod.click();
    }
    public void selectingamazonPayBalancebox(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(amazonPayBalancebox));
    	amazonPayBalancebox.isEnabled();
    	soft.assertEquals(amazonPayBalancebox.isEnabled(), true);
    	//amazonPayBalancebox.click();	
    }
    public void selectingcreditdebitcardbox(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(creditdebitcardbox));
    	creditdebitcardbox.isEnabled();
    	soft.assertEquals(creditdebitcardbox.isEnabled(), true);
    //	creditdebitcardbox.click();
    }
    public void selectingnetbankingbox(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(netbankingbox));
    	netbankingbox.click();
        soft.assertEquals(netbankingbox.isEnabled(), true);
      //netbankingbox.click() ; 
    }
    public void selectingotherUPIbox(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(otherUPIbox));
    	otherUPIbox.isEnabled();
        soft.assertEquals(otherUPIbox.isEnabled(), true);
      //  otherUPIbox.click();
    }
    public void selectingemibox(WebDriver driver) 
    {
    	wait.until(ExpectedConditions.visibilityOf(emibox));
    	emibox.isEnabled();
        soft.assertEquals(emibox.isEnabled(), true);
      //  emibox.click();
    }
    public void clickOnusethisPayMethodBtn(WebDriver driver) 
    {
    	usethisPayMethodBtn.click();
    	wait.until(ExpectedConditions.titleContains("         Place Your Order - Amazon Checkout     "));
    	assertEquals(driver.getTitle(), "         Place Your Order - Amazon Checkout     ");
    }
    
	public AmazonCheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
