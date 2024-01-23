package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Log.info(result.getMethod().getMethodName()+"Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info(result.getMethod().getDescription());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("Failed because of:-"+result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("Skipped because of:-"+result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		Log.info("=====onStart:-"+context.getName()+"=====");
	}

	@Override
	public void onFinish(ITestContext context) {
		Log.info("=====onFinish:-"+context.getName()+"=====");
		
	}

}
