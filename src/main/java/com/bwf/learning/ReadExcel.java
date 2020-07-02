package com.bwf.learning;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ReadExcel��ʹ��POI-XSSFʵ��2007�汾�Ժ�excel�ļ���ָ��Sheetҳ���ݵĶ�ȡ
 * @author lvsharp
 *
 */
public class ReadExcel {
    /**
     * getDataFromExcel��̬�������ڶ�ȡ��resourceĿ¼�µ�xlsx�ļ�ָ��ҳ�����ݣ���һ��������Ϊͷ��Ϣ���Զ�����
     * @param excelFileName ��resourceĿ¼�µ�xlsx�ļ���������Ҫָ��·��
     * @param sheetName�����ȡ���������ڵ�sheetҳ����
     * @return ��������Ϊ��ά���ݷ���
     */
	public static Object[][] getDataFromeExcel(String excelFileName,String sheetName){
		Object[][] obj = null;
		InputStream is = ReadExcel.class.getClassLoader().getResourceAsStream(excelFileName);//�������·���ж�ȡָ�����ļ��������������
		Workbook wb = null;
		Sheet sheet = null;
		try {
			wb = new XSSFWorkbook(is);//ͨ����������ȡexcel�ļ���workbook����
			sheet  = wb.getSheet(sheetName);//��ȡָ����sheetҳ����
			int lastRowNum = sheet.getLastRowNum();//��ȡ���һ�еı��
			int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();//��ȡ���һ����Ԫ��ı��(�к�)����Ҫ��һ
			obj = new Object[lastRowNum][lastCellNum];//ͨ��ѭ�����и�ֵ
			for(int i = 1;i<=lastRowNum; i++) {
				  for(int j = 0;j<=lastRowNum; j++) {
					    String str  = sheet.getRow(i).getCell(j).getStringCellValue(); 
					    if(str.equalsIgnoreCase("<Empty>")) {
					    	      obj[i-1][j] = "";	
					    }else {
					    	      obj[i-1][j] = str;	
					    }
				  }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
