package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import Amazon1.AmazonProductDetailPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//8 Check if products can be sorted by relevance, price, rating, etc.
@Listeners(ITestListernsForTC.class)
public class TC_8ProductSort extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)//
	public void loginwithDDT(String usernameFromExcel, String passwordFromExcel) throws InterruptedException
	{
		
		AmazonHomeLoginPage login = new AmazonHomeLoginPage(driver);
	//	login.contshopping();
		login.hoveroveraccountandlist(driver);
		login.signinfromhoverover();
		login.un(driver, usernameFromExcel);
		login.continuefromUN();
		login.pwd(driver, passwordFromExcel);
		login.signin();
		login.verifyAccount();
		login.searching();
		
		//Sort before clicking 1st product
		AmazonProductDetailPage sort = new AmazonProductDetailPage(driver);
		sort.clickingOnSort(driver);
	//	sort.selectingpriceLowTOHigh(driver);
		sort.selectingNewArrival();
	}	
	

}
