package Amazon1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AmazonAddToCartPage 
{
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//button[@id='a-autoid-3-announce']") WebElement cartbutton;
	@FindBy(xpath="//span[@id='nav-cart-count']") WebElement cartcount;
	
	public void addtocart()
	{
		
		String numofcartitems=cartcount.getText();
		int count=Integer.parseInt(numofcartitems);
		Reporter.log( "No of item present in cart Before:" +count);
		wait.until(ExpectedConditions.visibilityOf( cartbutton));
		assertEquals( cartbutton.isDisplayed(),true);
		 cartbutton.click();
		Reporter.log("Add to cart button is clickable");
	}
	public void cartcount()
	{
		wait.until(ExpectedConditions.visibilityOf( cartcount));
		String numofcartitems=cartcount.getText();
		int count=Integer.parseInt(numofcartitems);
		assertEquals( count>0,true);
		Reporter.log("Cart count After product added to the cart: " +count);
	}
	public void cartcountafterdelete()
	{
		wait.until(ExpectedConditions.visibilityOf( cartcount));
		String numofcartitems=cartcount.getText();
		int count=Integer.parseInt(numofcartitems);
		Reporter.log("Cart count After product deleted to the cart: " +count);
	}
	
	public AmazonAddToCartPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

}
