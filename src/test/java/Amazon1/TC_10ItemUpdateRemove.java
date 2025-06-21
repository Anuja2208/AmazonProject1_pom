package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//10 Test updating item quantities and removing items from the cart.
@Listeners(ITestListernsForTC.class)
public class TC_10ItemUpdateRemove extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class)//,retryAnalyzer = IRetryAnalizerforTC.class
	public void addRemoveproduct(String usernameFromExcel, String passwordFromExcel) throws InterruptedException
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
		addcart.goToCartBtnClick();
		addcart.clickincreasequantity(driver);
		addcart.clickdecreasequantity(driver);
		
		
	}

}
