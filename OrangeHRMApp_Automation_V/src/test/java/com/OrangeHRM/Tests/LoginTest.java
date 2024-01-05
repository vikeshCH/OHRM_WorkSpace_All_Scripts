package com.OrangeHRM.Tests;

import org.testng.annotations.Test;

import com.OrangeHRM.Pages.LoginPage;
import com.framework.Base.BaseTest1;

public class LoginTest extends BaseTest1{
	@Test
	public void verifyLoginWithValidCredentials() {

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login();

	}

	@Test
	public void verifyCopyRightText() {

		LoginPage loginPage = new LoginPage(getDriver());

		//String copyRightText = ExcelUtil.readData(4, 5);
		//loginPage.verifyFooterText(copyRightText);

	}
}
