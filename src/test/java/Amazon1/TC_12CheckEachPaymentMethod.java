package Amazon1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AmazonUtils.Excelsheet;
import AmazonUtils.IRetryAnalizerforTC;
import AmazonUtils.ITestListernsForTC;

//12 Check if user is able to select each payment method
@Listeners(ITestListernsForTC.class)
public class TC_12CheckEachPaymentMethod extends AmazonBaseClass
{
	@Parameters("browser")
	@Test(dataProvider="loginData1",dataProviderClass = Excelsheet.class,retryAnalyzer = IRetryAnalizerforTC.class)
	public void paymentMethodValidation(String usernameFromExcel, String passwordFromExcel, String nameFromExcel, String mobileNoFromExcel) throws InterruptedException
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
		
		AmazonProductDetailPage orderpage = new AmazonProductDetailPage(driver);
		orderpage.addToCartBtnClick();
		orderpage.goToCartBtnClick();
		orderpage.clickincreasequantity(driver);
		orderpage.clickdecreasequantity(driver);
		orderpage.clickdecreasequantity(driver);
		orderpage.clickdecreasequantity(driver);
		
		AmazonCheckoutPage select = new AmazonCheckoutPage(driver);
		select.clickingProccedToBuy(driver);
		select.selectingamazonPayBalancebox(driver);
		select.selectingcreditdebitcardbox(driver);
		select.selectingnetbankingbox(driver);
		select.selectingotherUPIbox(driver);
		select.selectingCOD(driver);
	//	select.clickOnusethisPayMethodBtn(driver);
		

}
}
