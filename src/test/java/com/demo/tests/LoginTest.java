package com.demo.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.demo.DriverManager.DriverCreation;
import com.demo.pages.LoginPage;


public class LoginTest extends DriverCreation {
	
	LoginPage loginPage=null;;;
	DriverCreation driverCreation=null;
	
	@BeforeSuite
	void appLaunching() {
		driverCreation=new DriverCreation();
		driverCreation.initialization();
		driverCreation.launchApplication();
		loginPage=new LoginPage(driverCreation.driver);;;
		
		
	}

	@BeforeMethod
	void verifyApplicationLaunched() {
		
		loginPage=new LoginPage(driverCreation.driver);;;
		loginPage.verifyLoginPage();
		System.out.println("Validated successfully");
	}
	@Test
	void loginToApplication() {
		
		loginPage.loginToTheApplication();
		
		
	}
	
	@AfterSuite
	void execution() {
		driverCreation.tearDown();
	}
}
