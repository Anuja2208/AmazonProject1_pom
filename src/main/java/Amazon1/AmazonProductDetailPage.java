package Amazon1;

import java.time.Duration;

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
	@FindBy(id="title_feature_div") WebElement titleDiv;
	@FindBy(id="averageCustomerReviews_feature_div") WebElement CustomerReviews;
	@FindBy(id="corePriceDisplay_desktop_feature_div") WebElement price;
	@FindBy(id="add-to-cart-button") WebElement addToCartBtn;
	@FindBy(xpath = "//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") WebElement addedToCart;
	@FindBy(linkText="Go to Cart") WebElement goToCartBtn;  //
	
	//Sort application
	 @FindBy(xpath = "//span[.='Sort by:']") WebElement sortby;  //Shoes
	 @FindBy(xpath = "//li[.='Price: Low to High']") WebElement pricelowtohigh; 
	 @FindBy(xpath = "//li[.='Newest Arrivals']") WebElement newArrival;
	 //for TC 10
	 @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']") WebElement cart;  //directly cart page
	 @FindBy(xpath = "//button[@aria-label='Increase quantity by one']") WebElement increasequantity;
	 @FindBy(xpath = "//button[@aria-label='Decrease quantity by one']") WebElement decreasequantity;
	 @FindBy(xpath = "//span[@class='sc-quantity-stepper']") WebElement delete; //remove from cart
	 @FindBy(linkText = " was removed from Shopping Cart. ") WebElement removed; //check item is removed
	    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//Go to Cart 
	
	public void descriptionDivIsDisplayed()
	{
		try {
		boolean b = titleDiv.isDisplayed();
		if(b==true) {
			Reporter.log("Product discription is Displayed");
		Assert.assertEquals(titleDiv.isDisplayed(), true);
		}
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			
		}

	}
	public void customerReviewsIsDisplayed()
	{
		try {
			boolean b = CustomerReviews.isDisplayed();
			if(b==true) {
				Reporter.log("Customer Reviews is Displayed");
		Assert.assertEquals(CustomerReviews.isDisplayed(), true);
			}
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			
		}
	}
	public void priceIsDisplayed()
	{
		try {
			boolean b = price.isDisplayed();
			if(b==true) {
				Reporter.log("Product price is Displayed");
		Assert.assertEquals(price.isDisplayed(), true);
			}
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			
		}
	}
	
	public void addToCartBtnClick()
	{
		try {
		addToCartBtn.click();
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			Reporter.log("Exception is handaled");
		}
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
		try {
		goToCartBtn.click();
		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			
		}
	}
	
	 public void clickingOnSort(WebDriver driver) {
		 try {
	        wait.until(ExpectedConditions.visibilityOf(sortby));
	        Actions a1 = new Actions(driver);
	        a1.moveToElement(sortby);
	        //sortby.click();
		 }
	    catch(java.lang.NullPointerException e){
	    		Reporter.log("Exception is Handaled");
	    	}
	    }
	    public void selectingpriceLowTOHigh(WebDriver driver) 
	    {
	    	try{
	        wait.until(ExpectedConditions.visibilityOf(pricelowtohigh));
	        pricelowtohigh.click();
	    	}
	    	catch(java.lang.NullPointerException e){
	    		Reporter.log("Exception is Handaled");
	    	}
	       
	    }
	    public void selectingNewArrival(WebDriver driver) 
	    {
	        wait.until(ExpectedConditions.visibilityOf(newArrival));
	        newArrival.click();
	       
	    }
	    public void goTOMyCart(WebDriver driver) 
	    {
	        wait.until(ExpectedConditions.visibilityOf(cart));
	        cart.click();
	    }
	    public void clickincreasequantity(WebDriver driver) 
	    {
	    	try {
	        wait.until(ExpectedConditions.visibilityOf(increasequantity));
	        increasequantity.click();
	        Reporter.log("Quantity incresed by 1");
	    	}
	    	catch(java.lang.NullPointerException e)
	    	{
	    		Reporter.log("Exception is handeled");
	    	}
	    }
	    public void clickdecreasequantity(WebDriver driver) 
	    {
	    	try
	    	{
	        wait.until(ExpectedConditions.visibilityOf(decreasequantity));
	        decreasequantity.click();
	        Reporter.log("Quantity Decreased By 1");
	        decreasequantity.isDisplayed();
	        Assert.assertEquals(decreasequantity.isDisplayed(), true);
	        Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
	    	}
	    	catch(org.openqa.selenium.StaleElementReferenceException e)
	    	{
	    		Reporter.log("Exception is handeled");
	    	}
	    	catch(java.lang.NullPointerException e)
	    	{
	    		Reporter.log("Exception is handeled");
	    	}
	    }
	    public void romovingfromCart()
	    {
	    	try {
	          delete.click();
	            boolean b1 =	removed.isDisplayed();
	            if(b1==true) {
	    	   Assert.assertEquals(b1, true);
	           }
	    	}
	    	catch(org.openqa.selenium.NoSuchElementException e) {
	    		
	    	}    
	    }
	    
	public AmazonProductDetailPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

}
