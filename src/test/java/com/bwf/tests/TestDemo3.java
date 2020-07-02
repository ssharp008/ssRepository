package com.bwf.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo3 {
	@BeforeTest
	public void beforeTestM() {
		System.out.println("---------Before Test2-----");
	}
	@AfterTest
	public void afterTestM() {
		System.out.println("---------Before Test2-----");
	}
	@BeforeClass
	public void beforeClassM() {
		System.out.println("------------Before Class TestDemo3-----");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("------------After Class TestDemo3-----");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("--------------Before Method in TestDemo3-----");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("--------------After Method in TestDemo3-----");
	}
    @Test(invocationCount=2)
    public void myTest31Func() {
    	System.out.println("-------------->testMethod - myTest31Func");
    }
    @Test(dependsOnMethods={"myTest31Func"})
    public void myTest32Func() {
    	System.out.println("-------------->testMethod - myTest32Func");
    }
}
