package Amazon1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;
//3 Ensure login fails with incorrect email or password.
@Listeners(ITestListernsForTC.class)
public class TC_3AmazonLoginFail extends AmazonBaseClass
{

	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)
	public void loginWithInvalidEmail(String usernameFromExcel, String passwordFromExcel) throws InterruptedException
	{
		if (driver == null) {
            System.err.println("WebDriver is null in loginwithDDT BEFORE Page Object creation!");
        }
		AmazonHomeLoginPage login = new AmazonHomeLoginPage(driver);
		login.contshopping();
		login.hoveroveraccountandlist(driver);
		login.signinfromhoverover();
		login.uninvalid(driver, usernameFromExcel);
		login.continuefromUN();
		login.pwdinvalid(driver, passwordFromExcel);
		login.signin();
		login.verifyAccountInvalid();
	
		
	}
	

}
