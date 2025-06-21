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
	@FindBy(linkText="Go to Cart") WebElement goToCartBtn;  //
	
	 @FindBy(xpath = "//span[.='Sort by:']") WebElement sortby;  //Shoes
	 @FindBy(xpath = "//li[.='Price: Low to High']") WebElement pricelowtohigh; 
	 @FindBy(xpath = "//li[.='Newest Arrivals']") WebElement newArrival;
	 //for TC 10
	 @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']") WebElement cart;  //directly cart page
	 @FindBy(xpath = "//button[@aria-label='Increase quantity by one']") WebElement increasequantity;
	 @FindBy(xpath = "//button[@aria-label='Decrease quantity by one']") WebElement decreasequantity;
	    
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
	
	public void goToCartBtnClick()
	{
		try {
		goToCartBtn.click();
		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			
		}
	}
	
	 public void clickingOnSort(WebDriver driver) 
	    {
	        wait.until(ExpectedConditions.visibilityOf(sortby));
	        Actions a1 = new Actions(driver);
	        a1.moveToElement(sortby);
	        //category.click();
	        
	      //  Assert.assertTrue(category.isSelected(), "Category selection done!");
	    }
	    public void selectingpriceLowTOHigh(WebDriver driver) 
	    {
	    	try
	    	{
	        wait.until(ExpectedConditions.visibilityOf(pricelowtohigh));
	        pricelowtohigh.click();
	    	}
	    	catch(java.lang.NullPointerException e)
	    	{
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
	        decreasequantity.isDisplayed();
	        Assert.assertEquals(decreasequantity.isDisplayed(), true);
	        Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
	    	}
	    	catch(org.openqa.selenium.StaleElementReferenceException e)
	    	{
	    		Reporter.log("Exception is handeled");
	    	}
	    }
	
	public AmazonProductDetailPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

}
