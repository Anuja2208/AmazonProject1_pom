package Amazon1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;
import AmazonUtils.TestData_Regi;

//2 Verify login is successful with correct email and password.
@Listeners(ITestListernsForTC.class)
public class TC_2AmazonLogin extends AmazonBaseClass  
{
	@Parameters("browser")
	@Test//(retryAnalyzer = IRetryAnalizerforTC.class)//dataProvider="loginData1",dataProviderClass = Excelsheet.class,
	public void loginwithDDT() throws InterruptedException, EncryptedDocumentException, IOException
	{
		AmazonHomeLoginPage login = new AmazonHomeLoginPage(driver);
	//	login.contshopping();
		login.hoveroveraccountandlist(driver);
		login.signinfromhoverover();
		login.un(driver, TestData_Regi.stringdata("LoginDetails", 1, 0));
		login.continuefromUN();
		login.pwd(driver, TestData_Regi.stringdata("LoginDetails", 1, 1));
		login.signin();
    	login.verifyAccount();

	}
}
