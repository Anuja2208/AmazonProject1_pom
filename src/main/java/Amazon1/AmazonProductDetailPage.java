package Amazon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AmazonProductDetailPage 
{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	//product discription-add to cart
	@FindBy(id="title_feature_div") WebElement titleDiv;
	@FindBy(id="averageCustomerReviews_feature_div") WebElement CustomerReviews;
	@FindBy(id="corePriceDisplay_desktop_feature_div") WebElement price;
	@FindBy(id="add-to-cart-button") WebElement addToCartBtn;
	@FindBy(xpath = "//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") WebElement addedToCart;
	@FindBy(linkText="Go to Cart") WebElement goToCartBtn;  //
	
	//Sort application
	 @FindBy(xpath = "//span[.='Sort by:']") WebElement sortby;  //Shoes
	 @FindBy(xpath = "//li[.='Price: Low to High']") WebElement pricelowtohigh; 
	 @FindBy(xpath = "//a[@id='s-result-sort-select_4']") WebElement newArrival;
	 
	 //for add-remove-delete
	 @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']") WebElement cart;  //directly cart page
	 @FindBy(xpath = "//button[@aria-label='Increase quantity by one']") WebElement increasequantity;
	 @FindBy(xpath = "//button[@data-a-selector='decrement']") WebElement decreasequantity;      //button[@aria-label='Decrease quantity by one']
	// @FindBy(xpath = "//input[@name='submit.delete-active.bedbdee4-16ee-4a95-9a67-ed81bf2be72a']") WebElement delete; //remove from cart  //input[@name='submit.delete-active.bedbdee4-16ee-4a95-9a67-ed81bf2be72a']
	 @FindBy(xpath="(//input[@data-feature-id='item-delete-button'])[1]")  WebElement delete_button;
	 @FindBy(xpath = "//input[@name='quantityBox']") WebElement quantityBox; //remove from cart
	 @FindBy(linkText = "//span[@id='sc-list-item-removed-msg-text-delete-08754d7c-b286-4102-a9de-43c6784bed8e']") WebElement removed; //check item is removed
	//cart button
	 @FindBy(xpath="//button[@id='a-autoid-3-announce']") WebElement cartbutton;
	 @FindBy(xpath="//span[@id='nav-cart-count']") WebElement cartcount;  
	
	//Go to Cart 
	
	public void descriptionDivIsDisplayed()
	{
		boolean b = titleDiv.isDisplayed();
		if(b==true) {
			Reporter.log("Product discription is Displayed");
		Assert.assertEquals(titleDiv.isDisplayed(), true);
		}
	}
	public void customerReviewsIsDisplayed()
	{
			boolean b = CustomerReviews.isDisplayed();
			if(b==true) {
				Reporter.log("Customer Reviews is Displayed");
		Assert.assertEquals(CustomerReviews.isDisplayed(), true);
			}
	}
	public void priceIsDisplayed()
	{
		boolean b = price.isDisplayed();
		if(b==true) {
			Reporter.log("Product price is Displayed");
	Assert.assertEquals(price.isDisplayed(), true);
		}
	}
	
	public void addToCartBtnClick()
	{
		addToCartBtn.click();
	}
	public void addingToCartBtnClick()
	{
		boolean b = addedToCart.isDisplayed();
		if(b==true) {
		Assert.assertEquals(b, true);
		Reporter.log("Product Added To Cart");
		}
	}
	public void goToCartBtnClick()
	{
		goToCartBtn.click();
		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
	}
	 public void clickingOnSort(WebDriver driver) 
	    {
	       wait.until(ExpectedConditions.visibilityOf(sortby));
	       sortby.click();

	    }
	    public void selectingpriceLowTOHigh(WebDriver driver) 
	    {
	     //   wait.until(ExpectedConditions.visibilityOf(pricelowtohigh));
	        pricelowtohigh.click(); 
	    }
	    public void selectingNewArrival() 
	    {
	     //   wait.until(ExpectedConditions.visibilityOf(newArrival));
	        newArrival.click(); 
	    }
	    public void addtocart()
		{
			
			String numofcartitems=cartcount.getText();
			int count=Integer.parseInt(numofcartitems);
			Reporter.log( "No of item present in cart Before:" +count);
			wait.until(ExpectedConditions.visibilityOf( cartbutton));
			Assert.assertEquals(cartbutton.isDisplayed(),true);
			 cartbutton.click();
			Reporter.log("Add to cart button is clickable");
		}
	    public void goTOMyCart(WebDriver driver) 
	    {
	        wait.until(ExpectedConditions.visibilityOf(cart));
	        cart.click();
	    }
	    public void clickincreasequantity() 
	    {
	    	String numofcartitems=cartcount.getText();
			int count=Integer.parseInt(numofcartitems);
			Assert.assertEquals( count>0,true);
			Reporter.log("Cart count Before increasing quantity: " +count);
	        wait.until(ExpectedConditions.visibilityOf(increasequantity));
	        increasequantity.click();
	    }
	    public void clickdecreasequantity(WebDriver driver) 
	    {
	    //	wait.until(ExpectedConditions.elementSelectionStateToBe(decreasequantity, true));
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-a-selector='decrement']")));
	        decreasequantity.click();
	    }
	    public void romovingfromCart() throws InterruptedException
	    {
	    //	wait.until(ExpectedConditions.stalenessOf(delete));	      //  delete.click();
	    	Thread.sleep(2000);
	    	delete_button.click();
	    }
	    public void cartItemCount()
		{
			wait.until(ExpectedConditions.visibilityOf( cartcount));
			String numofcartitems=cartcount.getText();
			int count=Integer.parseInt(numofcartitems);
			Assert.assertEquals( count>0,true);
			Reporter.log("Cart count After product added to the cart: " +count);
		}
	    public void quantityBoxSendKeys(WebDriver driver)
		{
			int quantity = Integer.parseInt(quantityBox.getDomAttribute("value"));
			System.out.println(quantity);
			if(quantity!=1)
			{
				Actions a1 = new Actions(driver);
				a1.doubleClick(quantityBox).perform();	
			}
			else
			{
				quantityBox.sendKeys("1");
			}
		}
		public void cartItemCountAfterDelete()
		{
			wait.until(ExpectedConditions.visibilityOf( cartcount));
			String numofcartitems=cartcount.getText();
			int count=Integer.parseInt(numofcartitems);
			Reporter.log("Cart count After product deleted to the cart: " +count);
		}
	    public void verifyRemoved(WebDriver driver)
	    {
	    	 wait.until(ExpectedConditions.visibilityOf(removed));
	          boolean b1 = removed.isDisplayed();
	           if(b1==true) {
	    	   Assert.assertEquals(b1, true);
	            }
	    }
	public AmazonProductDetailPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

}