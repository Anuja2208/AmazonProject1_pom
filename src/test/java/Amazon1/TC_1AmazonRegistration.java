package Amazon1;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.TestData_Regi;

//1 Test if a new user can successfully register.
//@Listeners(ITestListernsForTC.class)
public class TC_1AmazonRegistration extends AmazonRegiBaseClass
{
	

	@Test()//,retryAnalyzer = IRetryAnalizerforTC.class
	public void registration() throws InterruptedException, EncryptedDocumentException, IOException
	{
		AmazonRegiPage registration  = new AmazonRegiPage(driver);
		registration.addusername(driver, TestData_Regi.stringdata("LoginDetails", 1, 0));
		registration.addphoneno(driver, TestData_Regi.Numericdata("LoginDetails", 1, 3));
		registration.addpassword(driver, TestData_Regi.stringdata("LoginDetails", 1, 1));
		registration.mobileverification();
	//	registration.authenticationpage();
		
	}
	}

