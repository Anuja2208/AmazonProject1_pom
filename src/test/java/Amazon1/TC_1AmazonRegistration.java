package Amazon1;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import Amazon1.AmazonRegiPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//1 Test if a new user can successfully register.
//@Listeners(ITestListernsForTC.class)
public class TC_1AmazonRegistration extends AmazonRegiBaseClass
{

	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)
	public void registration(String usernameFromExcel, String passwordFromExcel, String nameFromExcel, String mobileNoFromExcel) throws InterruptedException
	{
		//AmazonHomeLoginPage home = new AmazonHomeLoginPage(driver);
		//home.contshopping();
		//home.hoveroveraccountandlist(driver);
		
		AmazonRegiPage registration  = new AmazonRegiPage(driver);
		
		registration.addusername(driver, usernameFromExcel);
		registration.addphoneno(driver, mobileNoFromExcel);
		registration.addpassword(driver, passwordFromExcel);
		registration.mobileverification();
		registration.authenticationpage();
		
	}
	}

