package com.mercury.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelConfig{
	
	File objFile;
	FileInputStream objFis;
	XSSFWorkbook objWB;
	XSSFSheet objSheet;
	
	@DataProvider(name="TestData")
	public Object[][] readData() throws Exception{
		
		 objFile = new File("G:\\Neon\\workspace\\POM\\TestData\\inputdata.xlsx");
		 objFis = new FileInputStream(objFile);
		 objWB = new XSSFWorkbook(objFis);
		 objSheet = objWB.getSheetAt(0);
		int rownum = objSheet.getPhysicalNumberOfRows();
		System.out.println(rownum);
		Object[][] data = new Object[rownum][13];
	
		for(int i=0;i<rownum;i++){
		
		data[i][0] = objSheet.getRow(i).getCell(0).getStringCellValue().trim();
		data[i][1] = objSheet.getRow(i).getCell(1).getStringCellValue().trim();
		data[i][2] = objSheet.getRow(i).getCell(2).getStringCellValue().trim();
		data[i][3] = objSheet.getRow(i).getCell(3).getStringCellValue().trim();
		data[i][5] = objSheet.getRow(i).getCell(5).getStringCellValue().trim();
		data[i][6] = objSheet.getRow(i).getCell(6).getStringCellValue().trim();
		data[i][7] = objSheet.getRow(i).getCell(7).getStringCellValue().trim();
		data[i][8] = objSheet.getRow(i).getCell(8).getStringCellValue().trim();
		data[i][9] = objSheet.getRow(i).getCell(9).getStringCellValue().trim();
		data[i][10] = objSheet.getRow(i).getCell(10).getStringCellValue().trim();
		data[i][11] = objSheet.getRow(i).getCell(11).getStringCellValue().trim();
		data[i][12] = objSheet.getRow(i).getCell(12).getStringCellValue().trim();
		}
	
	return data;
	}
	
	public void writeData() throws IOException
	{
		FileOutputStream objFOS = new FileOutputStream(objFile);
		objSheet = objWB.getSheetAt(0);
		objSheet.getRow(0).createCell(13).setCellValue("Pass");
		objWB.write(objFOS);
	} 
	
	
}
