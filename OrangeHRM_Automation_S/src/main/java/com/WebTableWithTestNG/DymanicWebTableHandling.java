package com.WebTableWithTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.BaseTest.BaseTest0;

public class DymanicWebTableHandling extends BaseTest0 {

	//@Test(priority = 1, description = " Getting the complete WebTable Data ")
	public void capturingDynamicWebTableData() {
		// Identifying the WebTable
		// /html/body/div[5]/section[1]/div

		By webTableProperty = By.xpath("/html/body/div[5]/section[1]/div");
		WebElement webTable = driver.findElement(webTableProperty);

		// Row is identified by the tag name as "tr"

		By rowProperty = By.tagName("tr");
		// Going to the WebTable and finding the Number of Rows in it
		List<WebElement> rows = webTable.findElements(rowProperty);

		// in the WebTable - should goto every Row of the WebTable
		for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
			// Going to a particular Row
			WebElement webTableRow = rows.get(rowIndex);

			// IN the current ROw - identifying the number of its corresponding Cells
			// Row of a Cell is identified in a webTable by tagName as "td"

			By rowOfCellProperty = By.tagName("td");

			// Going to a Particular Row and identifying all its Cells
			List<WebElement> rowOfCells = webTableRow.findElements(rowOfCellProperty);

			// To goto every Row of all its Corresponding Cells
			for (int rowOfCellIndex = 0; rowOfCellIndex < rowOfCells.size(); rowOfCellIndex++) {
				WebElement rowOfCell = rowOfCells.get(rowOfCellIndex);
				String data = rowOfCell.getText();
				System.out.print(data + " | ");

			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		DymanicWebTableHandling obj = new DymanicWebTableHandling();
		obj.setUp();
		obj.capturingDynamicWebTableData();
		obj.tearDown();
	}
}
