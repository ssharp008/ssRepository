package com.bwf.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

import com.bwf.framework.utils.Config;
/**
 * DriverUtils�������ṩservice�ĵ������������ṩƥ�䲻ͬ�������driver����
 * @author lvsharp
 *
 */
public class DriverUtils {
	/**
	 * service�������ڱ�������û����õ�ϵͳ�����������Ĳ�ͬ�������driverservice
	 */
	private static DriverService service;
	/**
	 * browser�ַ��������ڻ�ȡ�������û�������ϵͳ����bwf.test.browser�е�ֵ
	 */
	private static String browser;
	/**
	 * ��̬����(�����Ķ���ģʽ)��service���󣬲�����
	 */
	static {
		browser=System.getProperty("bwf.test.browser","firefox");
		/**
		 * ����browser�������������ͣ��ֱ𴴽�DriverService����Ŀǰchrome��ie��δ�깤
		 */
		Config config = new Config("config.properties");
		if("firefox".equalsIgnoreCase(browser)) {
			service=new GeckoDriverService.Builder().usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")))//ָ����������ִ���ļ�
					.usingAnyFreePort()//ָ��ʹ���������ö˿�
					.usingDriverExecutable(new File(config.getConfig("driver")))//ָ��driver���������λ��
					.build();//��Builder��������DriverService����	
		}else if("chrome".equalsIgnoreCase(browser)) {
			service = new ChromeDriverService.Builder().usingDriverExecutable(new File(config.getConfig("driver")))
					.usingAnyFreePort().build();
		}else if("ie".equalsIgnoreCase(browser)) {
			service = null;
		}else {
			throw new RuntimeException("δ֧�ֵ���������ͣ�����ϵͳ����bwf.test.browser");
		}
		try {
			service.start();//����service
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * getDriver��̬����������ʹ�����ṩ����Ļ�ȡ��ͬ���������driver����
	 * @return
	 */
public static WebDriver getDriver() {
	WebDriver driver = null;
	DesiredCapabilities caps=null;
	/**
	 * ����browser��ֵ�ж�������browser����
	 */
	if("firefox".equalsIgnoreCase(browser)) {
		caps = DesiredCapabilities.firefox();
	}else if("chrome".equalsIgnoreCase(browser)) {
		caps = null;
	}else if("ie".equalsIgnoreCase(browser)) {
		caps = null;
	}else {
		throw new RuntimeException("δ֧�ֵ���������ͣ�����ϵͳ����bwf.test.browser");
	}
	driver = new RemoteWebDriver(service.getUrl(),caps);
	return driver;	
}
/**
 * ֹͣ����
 */
public static void stopService() {
	service.stop();
}
}
