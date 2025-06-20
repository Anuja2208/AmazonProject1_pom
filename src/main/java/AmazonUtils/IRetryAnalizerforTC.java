package AmazonUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class IRetryAnalizerforTC implements IRetryAnalyzer 
{

	int initialcount = 0;
	int retrycount = 2;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(initialcount<retrycount)
		{
			initialcount++;
			return true;
		}
		
		return false;
	}
  /*  private int attempt = 0;
    private final int maxRetries = 1;  // Can be set via configuration

    @Override
    public boolean retry(ITestResult result) {
        if (attempt < maxRetries) {
            attempt++;
            Reporter.log("Retrying test: " + result.getName() + " (Attempt " + attempt + ")");
            return true;
        }
        return false;
    }  */
}


