package com.bwf.learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {
        public static void main(String[] args) throws IOException {
        	  Workbook wb = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\lvsharp\\eclipse-workspace\\training\\src\\test\\resources\\loginTestData.xls")));
        	  Sheet sheet = wb.getSheet("Sheet1");
        	  int lastRowNum = sheet.getLastRowNum();
        	  int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
        	  System.out.println(lastRowNum);
        	  System.out.println(lastCellNum);
        	  for(int i=0;i<lastRowNum;i++) {
        		  for(int j=0;j<lastRowNum;j++) {
        			  System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
        	  }
        	  System.out.println();  
        }
                     wb.close();
}
}
