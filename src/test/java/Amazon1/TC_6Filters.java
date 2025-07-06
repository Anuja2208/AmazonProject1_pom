package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonAfterSearchFilterWishPage;
import Amazon1.AmazonHomeLoginPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//6 Verify that searching with filters (e.g., category, price range) yields accurate results.
@Listeners(ITestListernsForTC.class)
public class TC_6Filters extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)//
	public void applyingFilters(String usernameFromExcel, String passwordFromExcel) throws InterruptedException
	{
		AmazonHomeLoginPage login = new AmazonHomeLoginPage(driver);
//		login.contshopping();
		login.hoveroveraccountandlist(driver);
		login.signinfromhoverover();
		login.un(driver, usernameFromExcel);
		login.continuefromUN();
		login.pwd(driver, passwordFromExcel);
		login.signin();
		login.verifyAccount();
		login.searching();
		
		AmazonAfterSearchFilterWishPage filter = new AmazonAfterSearchFilterWishPage(driver);
		filter.brand();
		filter.price();
		
	}


}
