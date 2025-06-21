package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//14 Go to orders page and click on your last ordered product and give 5star ratings
@Listeners(ITestListernsForTC.class)
public class TC_14_5StarRatingOnLastOrderProduct extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class)//,retryAnalyzer = IRetryAnalizerforTC.class
	public void givingRatingforLastOrder(String usernameFromExcel, String passwordFromExcel) throws InterruptedException
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
		login.clickingReturnsAndOrders();
		login.ordersSarching();
			
	}
}
