package driver;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount=0;
    private static final int MAX_ReTRY_COUNT = 3;
    @Override
    public boolean retry(ITestResult iTestResult){
        return retryCount++ <MAX_ReTRY_COUNT;
    }

}
