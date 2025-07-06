package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//15 Reach till cart page without login in amazon application
@Listeners(ITestListernsForTC.class)
public class TC_15GoToCartWithOutLogin extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(retryAnalyzer = IRetryAnalizerforTC.class)
	public void GoingToCartwithoutLogin() throws InterruptedException
	{
		AmazonHomeLoginPage cart = new AmazonHomeLoginPage(driver);
	//	cart.contshopping();
		cart.searching();
		
		AmazonSearchResultPage result = new AmazonSearchResultPage(driver);
		result.clickingOnFirstProduct();
		
		AmazonProductDetailPage orderpage = new AmazonProductDetailPage(driver);
		orderpage.addToCartBtnClick();
		orderpage.goToCartBtnClick();
			
	}
}