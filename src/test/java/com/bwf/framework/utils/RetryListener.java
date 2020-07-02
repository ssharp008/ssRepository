package com.bwf.framework.utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IInvokedMethodListener {
         public void beforeInvocation(IInvokedMethod method,ITestResult testResult) {
        	 
         }
         public void afterInvocation(IInvokedMethod method,ITestResult testResult) {
        	 IRetryAnalyzer retry  = method.getTestMethod().getRetryAnalyzer();
        	 if(retry == null) {
        		 method.getTestMethod().setRetryAnalyzer(new RetryAnalysis());
        	 }
         }
}
