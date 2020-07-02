package com.bwf.framework.utils;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * ��װ��RemoteWebDriver���̳���RemoteWebDriver����дfindElements��findElement������ʵ��Ԫ�ز��ҵ���־��¼
 * @author lvsharp
 *
 */
public class WrappedRemoteWebDriver extends RemoteWebDriver{
	private Logger logger = LogManager.getLogger();
    public WrappedRemoteWebDriver(URL remoteAddress,Capabilities capabilities) {
    	super(remoteAddress,capabilities);   	
    }
    @Override
    protected List<WebElement> findElements(String by,String using){
    	List<WebElement> elements = null;
    	try {
    	      elements = super.findElements(by,using);
    	      logger.info("ͨ��"+by+"��������"+using+"Ԫ�أ����ҵ�"+elements.size()+"��");
    	}catch(Exception e) {
    	      logger.info("ͨ��"+by+"��������"+using+"Ԫ��ʱ�����쳣��ԭ��"+e.getMessage());
    	}
    	return elements;
    	
    }
    @Override
    protected WebElement findElement(String by,String using) {
    	WebElement element  = null;
    	try {
    	       element = super.findElement(by,using);
    	       logger.info("ͨ��"+by+"��������"+using+"Ԫ�أ����ҵ�");
    	}catch(Exception e) {
    		   logger.error("ͨ��"+by+"��������"+using+"Ԫ��ʱ�����쳣��ԭ��"+e.getMessage());
    	}
    	return element;
    }
    public void takeScreenShot(String filename) {
    	File screenShot = ((TakesScreenshot)this).getScreenshotAs(OutputType.FILE);
    	File directory = new File("screenshots");
    	if(!directory.exists()||directory.isDirectory()) {
    		 logger.info("screenshotsĿ¼�����ڣ�������Ŀ¼");
    		 directory.mkdir();
    	}
        File file = new File(directory,filename);
        screenShot.renameTo(file);
        logger.info("���ݱ���ɹ���������"+file.getAbsolutePath());
    }
}
