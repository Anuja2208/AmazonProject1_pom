package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import Amazon1.AmazonProfileEditPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;
//4 Check if a user can successfully edit their profile information.
@Listeners(ITestListernsForTC.class)
public class TC_4EditYourProfile extends AmazonBaseClass
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
		login.hoveroveraccountandlist(driver);
		
		
		AmazonProfileEditPage profile = new AmazonProfileEditPage(driver);
		profile.goToYourAccount();
		profile.clickingyouraddress();
		profile.clickingoneditaddress();
		profile.settingdefault();
	//	profile.defaultsettingdone();

		
	}

}
