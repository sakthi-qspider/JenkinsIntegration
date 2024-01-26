package assertions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
public class AssertionLogListener extends TestListenerAdapter {
	 private static final Logger logger = LogManager.getLogger(AssertionLogListener.class);

	    @Override
	    public void onTestFailure(ITestResult tr) {
	        Throwable throwable = tr.getThrowable();
	        if (throwable instanceof AssertionError) {
	            AssertionError assertionError = (AssertionError) throwable;
	            logger.error("Assertion failed: " + assertionError.getMessage());
	        }
	    }

}
