package com.bwf.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
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
	 * ������־����
	 */
	private static final Logger logger = LogManager.getLogger();
	/**
	 * ��̬����(�����Ķ���ģʽ)��service���󣬲�����
	 */
	static {
		browser=System.getProperty("bwf.test.browser","firefox");//��ȡbwf.test.browserϵͳ���ԣ����δ���ã���Ĭ��Ϊfirefox
		logger.info("��ȡϵͳ����bwf.test.browser��ֵΪ"+browser);//ʹ����־��¼��ȡ�Ĳ���ֵ
		/**
		 * ����browser�������������ͣ��ֱ𴴽�DriverService����Ŀǰchrome��ie��δ�깤
		 */
		Config config = new Config("config.properties");
		String driverFile = config.getConfig("driver");
		logger.info("��ȡ�����ļ���driver����·�����ļ�����ֵΪ"+driverFile);//ʹ����־��¼��ȡ�Ĳ���ֵ
		if("firefox".equalsIgnoreCase(browser)) {
			service=new GeckoDriverService.Builder().usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")))//ָ����������ִ���ļ�
					.usingAnyFreePort()//ָ��ʹ���������ö˿�
					.usingDriverExecutable(new File("C:\\Users\\lvsharp\\eclipse-workspace\\training\\geckodriver.exe"))//ָ��driver���������λ��
					.build();//��Builder��������DriverService����	
		}else if("chrome".equalsIgnoreCase(browser)) {
			service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\lvsharp\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe"))
					.usingAnyFreePort()//ָ��ʹ����һ���ö˿�
					.build();
		}else if("ie".equalsIgnoreCase(browser)) {
			//not yet implement
			service = null;
		}else {
			logger.error("δ֧�ֵ���������ͣ�����ϵͳ����bwf.test.broswer");//ͨ����־��¼�����������Ϣ�Ƿ�����
			throw new RuntimeException("δ֧�ֵ���������ͣ�����ϵͳ����bwf.test.browser");
		}
		try {
			service.start();//����service
			logger.info("driver��������");//ͨ����־��¼�����Ƿ���������
		} catch (IOException e) {
			logger.error("δ�ܳɹ�����service��ԭ��:"+e.getMessage());
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
