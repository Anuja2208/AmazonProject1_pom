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

public class AmazonAfterSearchFilterWishPage 
{
	 WebDriver driver;
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
	 
	    @FindBy(xpath="(//span[@class='a-size-base a-color-base'])[5]") WebElement brand;
		@FindBy(xpath="	(//span[@class='a-size-base a-color-base'])[46]") WebElement price2;
		//@FindBy(xpath="	(//span[@class='a-size-base a-color-base'])[74]") WebElement womencategory;
		@FindBy(xpath="	(//span[@class='a-size-base a-color-base'])[99]") WebElement shoematerial;
		
		public void brand()
		{
			wait.until(ExpectedConditions.elementToBeClickable(brand));
			Assert.assertEquals(brand.isDisplayed(), true);
			brand.click();
			
			Reporter.log(brand.getText() +" is selected");
		}

		public void price()
		{
			wait.until(ExpectedConditions.elementToBeClickable( price2));
			Assert.assertEquals(price2.isDisplayed(),true);
			price2.click();
			Reporter.log(price2.getText() +"  price is selected");
		}
		
		/*public void material()
		{
			wait.until(ExpectedConditions.elementToBeClickable(shoematerial));
			 Assert.assertEquals(shoematerial.isDisplayed(),true);
			 shoematerial.click();
					Reporter.log(shoematerial.getText() +" is selected");
		}*/
		

	/*    @FindBy(id = "add-to-cart-button") WebElement button_AddtoCart;
	    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//span") WebElement text_AddedToCart;
	    //filter
	    @FindBy(xpath = "//span[.='Get It Today']") WebElement deliveryDay; //Get It Today
	    @FindBy(xpath = "//span[.='Top Brands']") WebElement brand; //Top Brands
	    @FindBy(xpath = "//span[.='Shoes']") WebElement category;  //Shoes
	    @FindBy(xpath = "//span[.='Shoes']") WebElement specialFeatures;  //Lightweight 
	    
/*	    public void addToCart() 
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
	        wait.until(ExpectedConditions.visibilityOf(deliveryDay));
	        deliveryDay.click();
	        Reporter.log("Delivery day is selected");
	        Assert.assertTrue(deliveryDay.isSelected(), "Delivery option is selected!");
	    }

	    public void selectBrand() 
	    {
	        wait.until(ExpectedConditions.visibilityOf(brand));
	        brand.click();
	        Reporter.log("Brand is selected");
	        Assert.assertTrue(brand.isSelected(), "Brand selection done!");
	    }

	    public void selectCategory() 
	    {
	        wait.until(ExpectedConditions.visibilityOf(category)).click();
	        Reporter.log("Category is selected");
	        Assert.assertTrue(category.isSelected(), "Category selection done!");
	    }
	    public void selectSpecialFeature() 
	    {
	        wait.until(ExpectedConditions.visibilityOf(specialFeatures)).click();
	        Reporter.log("Special Features Lightweight is selected");
	        Assert.assertTrue(specialFeatures.isSelected(), "Special Features selection done!");
	    }
	   */
	    // Constructor
	    public AmazonAfterSearchFilterWishPage(WebDriver driver) 
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


}