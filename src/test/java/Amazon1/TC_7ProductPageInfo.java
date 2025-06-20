package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Amazon1.AmazonHomeLoginPage;
import Amazon1.AmazonProductDetailPage;
import Amazon1.AmazonSearchResultPage;
import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//7 Ensure that the product detail page displays all necessary information (price, reviews, description).

@Listeners(ITestListernsForTC.class)
public class TC_7ProductPageInfo extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)
	public void loginwithDDT(String usernameFromExcel, String passwordFromExcel, String nameFromExcel, String mobileNoFromExcel) throws InterruptedException
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
		login.searching();
		
		AmazonSearchResultPage result = new AmazonSearchResultPage(driver);
		result.clickOnFirstProduct(driver);
		
		AmazonProductDetailPage pDetails = new AmazonProductDetailPage(driver);
		pDetails.descriptionDivIsDisplayed();
		pDetails.customerReviewsIsDisplayed();
		pDetails.priceIsDisplayed();

	}
	
		
	}


