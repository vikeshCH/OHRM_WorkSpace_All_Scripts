package com.OrangeHRMApplicationTestCases;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.OrangeHRMApplicationWebPages.OrangeHRMLogInPage;

public class OrangeHRMLogInPageTest extends BaseTest {
	@Test(priority = 1, description = " OrangeHRM Application LogIn Page - LOGIN Panel Text Validation")
	public void orangeHRMApplicationLogInPage_LogInPanelTextValidationTest() {
		OrangeHRMLogInPage logInPage = new OrangeHRMLogInPage();
		logInPage.validatingLogInPanelText();
	}

	@Test(priority = 2, description = " OrangeHRM Applicatin LogIn Page- Logo Validation")
	public void orangeHRMApplicationLogInPage_LogoValidationTest() {
		OrangeHRMLogInPage logInPage = new OrangeHRMLogInPage();
		logInPage.orangeHRMApplicationLogInPage_LogoValidation();
	}

	@Test(priority = 3, description = " Validating LogIn Functionality of OrangeHRM Application ")
	public void orangeHRMApplication_logInTest() {
		OrangeHRMLogInPage logInPage = new OrangeHRMLogInPage();
		logInPage.orangeHRMApplication_logIn("srini", "Q@Trainer7");
	}

}
