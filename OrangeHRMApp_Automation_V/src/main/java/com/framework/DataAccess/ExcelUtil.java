package com.framework.DataAccess;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
static Sheet sheet;
	
	static Map<String,Map<String,String>> rowData = new HashMap<String,Map<String,String>>();

	public static void initializeExcel() {
		Workbook wbook;
		try {
			String path = System.getProperty("user.dir") + "\\resources\\TestData\\TestData_For_OrangeHRM_Appliction.xlsx";
			File file = new File(path);
			//FileInputStream fis = new FileInputStream(file);
			if (path.endsWith(".xlsx")) {
				wbook = new XSSFWorkbook();
			} else {
				wbook = new HSSFWorkbook();
			}

			sheet = wbook.getSheet("Sheet1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readAllDataFromExcel() {
		
	

		for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {
			String testName = sheet.getRow(rowCount).getCell(0).getStringCellValue();
			//System.out.println(testName);
			Map<String,String> cellData = new HashMap<String,String>();
			for (int cellCount = 1; cellCount < sheet.getRow(rowCount).getLastCellNum(); cellCount++) {
				String key = sheet.getRow(0).getCell(cellCount).getStringCellValue();
				String value = sheet.getRow(rowCount).getCell(cellCount).getStringCellValue();

				//System.out.println(key+"="+value);
				cellData.put(key, value);
				
			}
			rowData.put(testName,cellData);
			//System.out.println(cellData);

		}
		System.out.println(rowData);

	}

	public static String readData(String testName, String colName) {

		return rowData.get(testName).get(colName);
	

	}

	public static void main(String args[]) {
		initializeExcel();
		readAllDataFromExcel();
	}
}
