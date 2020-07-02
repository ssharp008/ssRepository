package com.bwf.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo1 {
	@BeforeSuite
	public void beforeSuiteM() {
		System.out.println("-----Before Suite-----");
	}
	@AfterSuite
	public void afterSuiteM() {
		System.out.println("-----After Suite-----");
	}
	@BeforeTest
	public void beforeTestM() {
		System.out.println("---------Before Test1-----");
	}
	@AfterTest
	public void afterTestM() {
		System.out.println("---------After Test1-----");
	}
	@BeforeClass
	public void beforeClassM() {
		System.out.println("------------Before Class TestDemo1-----");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("------------After Class TestDemo1-----");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("--------------Before Method in TestDemo1-----");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("--------------After Method in TestDemo1-----");
	}
    @Test(groups={"firstlevel"})
    public void myTest11Func() {
    	System.out.println("-------------->testMethod - myTest11Func");
    }
    @Test(groups={"secondlevel"},dependsOnGroups={"firstlevel"})
    public void myTest12Func() {
    	System.out.println("-------------->testMethod - myTest12Func");
    }
}
