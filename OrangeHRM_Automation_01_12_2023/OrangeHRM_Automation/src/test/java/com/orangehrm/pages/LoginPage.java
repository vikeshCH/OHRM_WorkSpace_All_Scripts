package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	@FindBy(id = "txtUsername")
	WebElement textBox_UserName;
	
	@FindBy(id = "txtPassword")
	WebElement textBox_Password;
	
	@FindBy(id = "btnLogin")
	WebElement button_Login;
	
	@FindBy(id = "spanCopyright")
	WebElement label_CopyRightText;	
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void login() {
		
		
		textBox_UserName.sendKeys("Admin");
		textBox_Password.sendKeys("Admin");
		button_Login.click();
	}
	
	
	public void verifyFooterText(String expectedMsg) {
		
		
		String actualMsg = label_CopyRightText.getText();
		
		
	 
		Assert.assertEquals(actualMsg, expectedMsg,"Verify Copy Right Text");
	
	}
	
	

}
