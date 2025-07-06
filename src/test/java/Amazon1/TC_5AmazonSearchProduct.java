package Amazon1;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//5 Test searching for products using its name like shoe
@Listeners(ITestListernsForTC.class)
public class TC_5AmazonSearchProduct extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)//
	public void loginwithDDT(String usernameFromExcel, String passwordFromExcel) throws InterruptedException
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
		

	}

}
