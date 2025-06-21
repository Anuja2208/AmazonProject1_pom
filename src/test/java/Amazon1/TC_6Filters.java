package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonAfterSearchFilterSortCartWishPage;
import Amazon1.AmazonHomeLoginPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//6 Verify that searching with filters (e.g., category, price range) yields accurate results.
@Listeners(ITestListernsForTC.class)
public class TC_6Filters extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class)//,retryAnalyzer = IRetryAnalizerforTC.class
	public void loginwithDDT(String usernameFromExcel, String passwordFromExcel) throws InterruptedException
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
		
		AmazonAfterSearchFilterSortCartWishPage filter = new AmazonAfterSearchFilterSortCartWishPage(driver);
		filter.selectDeliveryDetails();
		filter.selectBrand();
		filter.selectCategory();

	}


}
