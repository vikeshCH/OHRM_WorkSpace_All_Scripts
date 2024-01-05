package com.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest0 {
	public WebDriver driver;
	String applicationUrlAddress="https://www.timeanddate.com/worldclock/";

	@BeforeTest
	public void setUp(){
	System.setProperty("webdriver.chrome.driver", "C:\\Trainings\\Seleniun-Automation\\WorkSpace\\OrangeHRM_Automation_S\\src\\test\\resources\\chromedriver.exe");
	driver= new ChromeDriver();

	System.out.println(" *** Chrome Browser Launched Successfully *****");

	driver.get(applicationUrlAddress);
	System.out.println(" Sucessfully Navigated to Time And Date Appliction ");

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown()
	{
	driver.quit();
	System.out.println(" **** Chrome Browser along with Application is Closed Successfully ***** ");
	}
}
