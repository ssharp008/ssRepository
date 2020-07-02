package com.bwf.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class TestRunner {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		//testng.setTestClasses(new Class[] {TestDemo1.class});
		XmlSuite suite = new XmlSuite();
		List<String> files = new ArrayList<String>();
		files.add("testngDemo.xml");
		suite.setSuiteFiles(files);
		List<XmlSuite> suites =new ArrayList();
		suites.add(suite);
		testng.setXmlSuites(suites);
		testng.run();
	}

}
