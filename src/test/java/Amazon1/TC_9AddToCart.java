package Amazon1;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import Amazon1.AmazonProductDetailPage;
import Amazon1.AmazonSearchResultPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//Verify that items can be added to the shopping cart from product page

@Listeners(ITestListernsForTC.class)
public class TC_9AddToCart extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)
	public void loginwithDDT(String usernameFromExcel, String passwordFromExcel, String nameFromExcel, String mobileNoFromExcel) throws InterruptedException
	{
		if (driver == null) {
            System.err.println("WebDriver is null in loginwithDDT BEFORE Page Object creation!");
        }
		AmazonHomeLoginPage login = new AmazonHomeLoginPage(driver);
		login.contshopping();
		login.hoveroveraccountandlist(driver);
		login.signinfromhoverover();
		login.un(driver, usernameFromExcel);
		login.continuefromUN();
		login.pwd(driver, passwordFromExcel);
		login.signin();
		login.verifyAccount();
		login.searching();
		
		
		AmazonSearchResultPage result = new AmazonSearchResultPage(driver);
		result.clickOnFirstProduct(driver);
		
		AmazonProductDetailPage addcart = new AmazonProductDetailPage(driver);
		addcart.addToCartBtnClick();
		

	}

		
}
