package com.OrangeHRMApplicationWebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class OrangeHRMLogInPage extends BaseTest {
	// Its an "Object Repository" Class

	public OrangeHRMLogInPage() // This called as Constructor - when the Java Class name is
								// similar to Method Name
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "logInPanelHeading") // id="logInPanelHeading"
	WebElement logInPanel; // @FindBy is an annotation of POM ,used to locate an Element.
							// 1. Identifying the element of the WebPage

	// 2. Performing an Operation on the Element of the WebPage
	public void validatingLogInPanelText() // Business Logic
	{

		String expected_OrangeHRMApplicationLogInPageText = "LOGIN Panel";
		Log.info(" The expected Text of the OrangeHRM Application LogIn Page is :- "
				+ expected_OrangeHRMApplicationLogInPageText);

		String actual_OrangeHRMApplicationLogInPageText = logInPanel.getText();
		Log.info(" The actual Text of the OrangeHRM Application LogIn Page is :- "
				+ actual_OrangeHRMApplicationLogInPageText);

		if (actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)) {
			Log.info(" OrangeHRM Application LogIn Page Text Validation Successfull - PASS ");
		} else {
			Log.info(" OrangeHRM Application LogIn Page Text Validation UNSuccessfull - FAIL ");
		}
	}

	@FindBy(xpath = "//*[@id=\"divLogo\"]/img")
	WebElement orangeHRMApplicationLogInPageImage;

	public void orangeHRMApplicationLogInPage_LogoValidation() {

		boolean flag = orangeHRMApplicationLogInPageImage.isDisplayed();
		if (flag) {
			Log.info("OrangeHRM Application LogIn Page Image Existing - PASS ");
		} else {
			Log.info("OrangeHRM Application LogIn Page Image NOT Existing - FAIL ");
		}

	}

         //  id="txtUsername"

	@FindBy(id = "txtUsername")
	WebElement userName;

          // id="txtPassword"
	@FindBy(id = "txtPassword")
	WebElement password;

             // name="Submit"
	@FindBy(name = "Submit")
	WebElement logInButton;

       // user-defined method with parameters
	public void orangeHRMApplication_logIn(String UserName, String Password) {
		userName.sendKeys(UserName);
		password.sendKeys(Password);
		logInButton.click();
	}

}
