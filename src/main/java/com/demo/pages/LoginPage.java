package com.demo.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.DriverManager.DriverCreation;

public class LoginPage extends DriverCreation {
	WebDriver driver=null;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement userIdField;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement resetButton;
	
	@FindBy(xpath="//h2[@class='barone']")
	WebElement appHeader;
	
	
	String appName="Gtpl Bank";
	String titleName="GTPL Bank Home Page";
	public void loginToTheApplication() {
		userIdField.sendKeys(prop.getProperty("userName"));
		passwordField.sendKeys(prop.getProperty("password"));
		loginButton.click();
	}
	
	public void verifyLoginPage() {
		
		Assert.assertEquals(appHeader.getText(), appName);
		Assert.assertEquals(driver.getTitle(),titleName);
		
	}
}
