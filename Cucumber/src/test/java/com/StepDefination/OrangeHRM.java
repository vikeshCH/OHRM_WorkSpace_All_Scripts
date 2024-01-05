package com.StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class OrangeHRM {
	public static WebDriver driver;
	@Test
	@Given("Launch ChromeBrowser")
	public void launch_chrome_browser() {
	System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
	driver=new ChromeDriver();
	
	    	}

	@Given("Enter OrangeHRM URL")
	public void enter_orange_hrm_url() {
	   driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login"); 
	}

	@When("Enter username,password and click on Login")
	public void enter_username_password_and_click_on_login() {
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("vikesh@123.com");
	  driver.findElement(By.id("btnLogin")).click();

	}
}
