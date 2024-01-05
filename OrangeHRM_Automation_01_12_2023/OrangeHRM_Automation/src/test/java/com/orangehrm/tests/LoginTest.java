package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.dataaccess.ExcelUtil;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {

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
