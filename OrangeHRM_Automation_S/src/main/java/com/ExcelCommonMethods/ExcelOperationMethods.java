package com.ExcelCommonMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelOperationMethods {
	
	
		public static String getRowOfCellValue
		(String excelFilePath,String sheetName,int rowIndex, int cellIndex) throws IOException {

		FileInputStream excelFile = new FileInputStream(excelFilePath);
		XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = workBook.getSheet(sheetName);

		XSSFRow row =  sheet.getRow(rowIndex);
		XSSFCell rowOfCell=row.getCell(cellIndex);

		String rowOfCellValue = rowOfCell.getStringCellValue();
		return rowOfCellValue;
		
		}

		public static void  setRowOfCellValue(String excelFilePath1, String sheetName1, int rowIndex1,int cellIndex1,String data) throws IOException  
		{
		FileInputStream excelFile1 = new FileInputStream(excelFilePath1);
		XSSFWorkbook workBook1 = new XSSFWorkbook(excelFile1);
		XSSFSheet sheet1 = workBook1.getSheet(sheetName1);

		XSSFRow row1 =  sheet1.getRow(rowIndex1);
		XSSFCell RowOfNewCellCreated=row1.createCell(cellIndex1);

		RowOfNewCellCreated.setCellValue(data);

		FileOutputStream saveFile = new FileOutputStream(excelFilePath1);
		workBook1.write(saveFile);
		saveFile.close();
		
}
}