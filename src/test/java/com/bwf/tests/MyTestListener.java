package com.bwf.tests;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter{
        @Override
        public void onTestFailure(ITestResult tr) {
        	super.onTestFailure(tr);
        	System.out.print("F");
        }
        @Override
        public void onTestSuccess(ITestResult tr) {
            super.onTestSuccess(tr);
            System.out.print(".");
        }
}
