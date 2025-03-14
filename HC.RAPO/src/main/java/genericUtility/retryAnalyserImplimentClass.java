package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyserImplimentClass implements IRetryAnalyzer{

	int count = 0;
	int limitCount = 2;
	
	public boolean retry(ITestResult result) {
		
		if(count < limitCount) {
			count++;
			return true;
		}
		return false;
	}
}
