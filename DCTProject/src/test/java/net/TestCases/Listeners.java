package net.TestCases;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {	// TestListenerAdapter is a predefined class that contains methods
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped");
	}
	
}
