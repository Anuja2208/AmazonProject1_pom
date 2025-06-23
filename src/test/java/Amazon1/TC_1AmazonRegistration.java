package Amazon1;
import org.testng.annotations.Test;

import AmazonUtils.DataSheetForRegistration;
import AmazonUtils.IRetryAnalizerforTC;

//1 Test if a new user can successfully register.
//@Listeners(ITestListernsForTC.class)
public class TC_1AmazonRegistration extends AmazonRegiBaseClass
{

	@Test(dataProvider="loginData1",dataProviderClass = DataSheetForRegistration.class,retryAnalyzer = IRetryAnalizerforTC.class)
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

