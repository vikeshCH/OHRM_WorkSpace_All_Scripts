package com.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.framework.dataaccess.ExcelUtil;
import com.framework.dataaccess.PropertyUtil;

public class BaseTest {
	private WebDriver driver;

	@BeforeSuite
	public void initialize() {
		PropertyUtil.initializeProperty();
		ExcelUtil.initializeExcel();
	}

	@BeforeMethod
	public void launchBrowser() {

		String browserName = PropertyUtil.readProperty("browserName");
		String path = System.getProperty("user.dir");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", path + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@BeforeMethod(dependsOnMethods = "launchBrowser")
	public void launchApplication() {
		String url = PropertyUtil.readProperty("url");
		driver.get(url);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
