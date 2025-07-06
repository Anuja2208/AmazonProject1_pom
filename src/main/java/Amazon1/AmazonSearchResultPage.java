package Amazon1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchResultPage 
{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	//click on first product
	@FindBy(xpath="(//div[@class='a-section aok-relative s-image-tall-aspect'])[1]") WebElement firstproductclick;
/*	@FindBy(xpath="(//div[@class='a-row a-size-medium']//button)[1]") WebElement addToCartBtnOnPopup;
	@FindBy(xpath="//img[@class=\"s-image\"]") List<WebElement> products;
	@FindBy(id="add-to-cart-button") WebElement addToCartBtn;  */
	
	
	//Set<WebElement> averageCustomerReviews
	public void clickingOnFirstProduct()
	{
		wait.until(ExpectedConditions.visibilityOf(firstproductclick));
		firstproductclick.click();
	}
/*	public void clickOnFirstProduct(WebDriver driver)
	{
	//	try{
		wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		System.out.println(products);
		WebElement firstProduct = products.get(0);
		Point p = firstProduct.getLocation();
		int y   = p.getY();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+y+")");
		firstProduct.click();
		
		Set<String> allWindows = driver.getWindowHandles();
		Iterator i1 = allWindows.iterator();
		
		String pWindow =  (String) i1.next();
		String cWindow =  (String) i1.next();
		
		driver.switchTo().window(cWindow);
		addToCartBtn.click();
/*		}
		catch(java.util.NoSuchElementException e)
		{
			Reporter.log("Exception is Handaled");
		}
		catch(java.lang.IndexOutOfBoundsException e)
		{
			Reporter.log("Exception is Handaled");
		}  
	}*/

	//step 3
	public AmazonSearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}