package Amazon1;

import java.time.Duration;

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

public class AmazonAfterSearchFilterSortCartWishPage 
{
	 WebDriver driver;
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    @FindBy(id = "add-to-cart-button") WebElement button_AddtoCart;
	    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//span") WebElement text_AddedToCart;
	    @FindBy(xpath = "//span[.='Get It Today']") WebElement deliveryDay; //Get It Today
	    @FindBy(xpath = "//span[.='Top Brands']") WebElement brand; //Top Brands
	    @FindBy(xpath = "//span[.='Shoes']") WebElement category;  //Shoes
	    
	    @FindBy(xpath = "//span[.='Sort by:']") WebElement sortby;  //Shoes
	    @FindBy(xpath = "//li[.='Price: Low to High']") WebElement pricelowtohigh; 
	    @FindBy(xpath = "//li[.='Newest Arrivals']") WebElement newArrival;
	    

	    public void addToCart() 
	    {
	        // Switch to last opened window
	        driver.switchTo().window(driver.getWindowHandles().stream().reduce((first, last) -> last).orElse(driver.getWindowHandle()));
	        wait.until(ExpectedConditions.elementToBeClickable(button_AddtoCart));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button_AddtoCart);
	        button_AddtoCart.click();
	    }

	    public void verifyItemAdded() 
	    {
	        wait.until(ExpectedConditions.visibilityOf(text_AddedToCart));
	        Assert.assertTrue(text_AddedToCart.isDisplayed(), "Item not added to cart!");
	    }

	    public void selectDeliveryDetails() 
	    {
	    	try {
	        wait.until(ExpectedConditions.visibilityOf(deliveryDay)).click();
	     //   deliveryDay.click();
	        //Assert.assertTrue(deliveryDay.isSelected(), "Delivery option is selected!");
	    	}
	    	catch(java.lang.NullPointerException e)
	    	{
	    		Reporter.log("Exception is handeled");
	    	}
	    }

	    public void selectBrand() 
	    {
	    	try {
	        wait.until(ExpectedConditions.visibilityOf(brand)).click();
	        brand.click();
	        Assert.assertTrue(brand.isSelected(), "Brand selection done!");
	    	}
	    	catch(java.lang.NullPointerException e)
	    	{
	    		Reporter.log("Exception is handeled");
	    	}
	    }

	    public void selectCategory() 
	    {
	    	try {
	        wait.until(ExpectedConditions.visibilityOf(category)).click();
	        category.click();
	        Assert.assertTrue(category.isSelected(), "Category selection done!");
	    	}
	        catch(java.lang.NullPointerException e)
	    	{
	    		Reporter.log("Exception is handeled");
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
	    	try {
	        wait.until(ExpectedConditions.visibilityOf(pricelowtohigh));
	        pricelowtohigh.click();
	    	}
	    	catch(java.lang.NullPointerException e)
	    	{
	    		Reporter.log("Exception is handeled");
	    	}
	       
	    }
	    // Constructor
	    public AmazonAfterSearchFilterSortCartWishPage(WebDriver driver) 
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


}
