package com.OrangeHRMApplicationTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;

public class AddEmployeeTest  extends BaseTest{
	// Validating LogIn Page

	WebElement welComeAdmin;

	@Test(priority = 1, description = " Validating LogIn Functionality Test ")
	public void logInTest() throws IOException {
		FileInputStream orangeHRMApplicationLogInTestDataFile = new FileInputStream(
				"./src/main/resources/TestData_For_OrangeHRM_Appliction.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(orangeHRMApplicationLogInTestDataFile);
		XSSFSheet logInTestDataSheet = workBook.getSheet("OrangeHRMData");

		Row LogInTestDataRow = logInTestDataSheet.getRow(5);
		Cell logInTestDataRowOfUserNameCell = LogInTestDataRow.getCell(1);

		String userNameTestData = logInTestDataRowOfUserNameCell.getStringCellValue();

		// String userNameTestData="srini";
		By userNameProperty = By.id("txtUsername"); // Identifying the property of an element
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		
	
		// finding an element with the property in the current webpage
		WebElement userName = driver.findElement(userNameProperty);

		// Operation should be performed on the element - userName
		userName.sendKeys(userNameTestData);

		// Identifying properties of Password Element
		// <input name="txtPassword" autocomplete="off" type="password">

		Cell logInTestDataRowOfPasswordCell = LogInTestDataRow.getCell(2);
		String passwordTestData = logInTestDataRowOfPasswordCell.getStringCellValue();

		// String passwordTestData="Q@Trainer7";

		// identify the property of Password Element
		By passwordProperty = By.id("txtPassword");
		// identifying the element password with its property
		WebElement password = driver.findElement(passwordProperty);
		// Performing an operation on the WebElement Password
		password.sendKeys(passwordTestData);

		// <input type="submit" class="button" value="LOGIN">
		By logInButtonProperty = By.className("button");
		WebElement logInButton = driver.findElement(logInButtonProperty);
		logInButton.click();

		// Validating OrangeHRM Application HomePage
		String expected_OrangeHRMApplicationHomePageText = "Admin";
		System.out.println(" The Expected Text of OrangeHRM Application HomePage is :- "
				+ expected_OrangeHRMApplicationHomePageText);

		// id="welcome" - Property of WelCome Admin Element
		By welComeAdminProperty = By.id("welcome");
		welComeAdmin = driver.findElement(welComeAdminProperty);

		String actual_OrangeHRMApplicationHomePageText = welComeAdmin.getText();
		System.out.println(
				" The actual Text of OrangeHRM Application HomePage is :- " + actual_OrangeHRMApplicationHomePageText);

		// Validating HomePage
		if (actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText)) {
			System.out.println(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

			// Row logInTestResultRow=logInTestDataSheet.createRow(1);
			// Cell logInTestResultRowOfCell=logInTestResultRow.createCell(2);
			// of the same first ROw -- only creating a New CEll to save the Test Result
			Cell logInTestResultRowOfCell = LogInTestDataRow.createCell(3);
			logInTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		} else {
			System.out.println(" Failed to Navigat to OrangeHRM Application HomePage - FAIL");
			// Row logInTestResultRow=logInTestDataSheet.createRow(1);
			// Cell logInTestResultRowOfCell=logInTestResultRow.createCell(2);

			Cell logInTestResultRowOfCell = LogInTestDataRow.createCell(2);
			logInTestResultRowOfCell.setCellValue("Failed to Navigat to OrangeHRM Application HomePage - FAIL");

		}

		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream(
				"./src/main/resources/TestData_For_OrangeHRM_Appliction.xlsx");
		workBook.write(orangeHRMApplicationLogInTestResultFile);

	}

	@Test(priority = 2, description = " Validating PIM Functionality in OrangeHRM Application HomePage Test ")
	public void pimTest() {
		// id="menu_pim_viewPimModule"
		By pimProperty = By.id("menu_pim_viewPimModule");
		WebElement pim = driver.findElement(pimProperty);
		
		Actions pimAction = new Actions(driver);
		pimAction.moveToElement(pim).build().perform();

	}

    @Test(priority = 3, description = " Validating AddEmployee Functionality Test  in OrangeHRM Application HomePage ")
	public void addEmployeeTest() {
		// id="menu_pim_addEmployee"
		By addEmployeeProperty = By.id("menu_pim_addEmployee");

		WebElement addEmployee = driver.findElement(addEmployeeProperty);
		addEmployee.click();

	}

	// Validating AddEmployee WebPage - expected text "Add Employee"

	@Test(priority=3,description=" Validating Add New Employee Functionality Test  in OrangeHRM Application  ")
	public void newAddEmployeeTest() throws InterruptedException, IOException
	{
	// Test Data should be updated from external file Excel
	By firstNameProperty=By.id("firstName");
	WebElement firstName=driver.findElement(firstNameProperty);
	firstName.sendKeys("Srini007");

	// ACtions Class - is used to perform operations related to both Mouse and KeyBoard

	// Performing the "TAB" key Operation
	Actions keyBoardActions = new Actions(driver);
	keyBoardActions.sendKeys(Keys.TAB).build().perform();

	// withOut identifying the property of the MiddleName Element - directly automating it
//	    since the Actions Class Object(keyBoardActions) focus is now at the MiddleName
//	      directly using the same Object Performing the Opeation to send the Test Data
	keyBoardActions.sendKeys("Hello0007").build().perform();

	// shifting the focus from the Middle Name to LastName
	keyBoardActions.sendKeys(Keys.TAB).build().perform();

	keyBoardActions.sendKeys("Chello0007").build().perform();

	keyBoardActions.sendKeys(Keys.TAB).build().perform(); // will move to EmployeeId

	keyBoardActions.sendKeys(Keys.TAB).build().perform(); // will move to Photograph

	keyBoardActions.sendKeys(Keys.ENTER).build().perform();

	Thread.sleep(5000);

	java.lang.Runtime.getRuntime().exec("D:\\Professional Images of vikesh\\KohliPhotoFile.exe");


	
	/*
	 * By middleNameProperty=By.id("middleName"); WebElement
	 * middleName=driver.findElement(middleNameProperty);
	 * middleName.sendKeys("Hello007");
	 * 
	 * By lastNameProperty=By.id("lastName"); WebElement
	 * lastName=driver.findElement(lastNameProperty);
	 * lastName.sendKeys("Chello007");
	 */
	


	
	//<input class="formInputText" maxlength="10" type="text"
	//name="employeeId" value="0298" id="employeeId">
	

	// get the EmployeeId from the Application and export to ExcelSheet

	By employeeIdProperty=By.id("employeeId");
	WebElement employeeId=driver.findElement(employeeIdProperty);
	String expected_applicationEmployeeId=employeeId.getAttribute("value");
	System.out.println("The Expected EmployeeId is :- "+ expected_applicationEmployeeId);


	Thread.sleep(10000);

	// id="btnSave"
	By saveButtonProperty=By.id("btnSave");
	WebElement saveButton=driver.findElement(saveButtonProperty);
	saveButton.click();
	}

	// Validating Person Details Webpage - Expected Text is "Personal Details"

	// Validating FirstName, MiddleName , LastName and EmployeeID

	// Validating FistName whether existing in the WebPage above the Employee
	// PhotoGraph image

	@Test(priority = 4, description = " Validating WelComeAdmin Functionality Test ")
	public void welComeAdminTest() {
		// id="welcome" - Property of WelCome Admin Element
		By welComeAdminProperty = By.id("welcome");
		welComeAdmin = driver.findElement(welComeAdminProperty);

		welComeAdmin.click();

	}

	@Test(priority = 5, description = " Validating LogOut Functionality Test ")
	public void logOutTest() {
		// By logOutProperty=By.partialLinkText("Log");
		By logOutProperty = By.linkText("Logout");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(logOutProperty));

		WebElement logOut = driver.findElement(logOutProperty);
		logOut.click();

		// Validation of LogIn Page
	}
}
