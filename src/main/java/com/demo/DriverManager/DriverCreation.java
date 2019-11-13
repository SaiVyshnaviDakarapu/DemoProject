package com.demo.DriverManager;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverCreation {
	final long pageLoadTime=20;
	public WebDriver driver=null;
	public static Properties prop=null;
	String configPath=System.getProperty("user.dir")+"\\src\\test\\resources\\com\\demo\\testData\\configurations.properties";
	FileInputStream fis=null;
	
	public DriverCreation(){
		
		try {
		prop=new Properties();
		File f= new File(configPath);
		FileInputStream fis=new FileInputStream(f);
		prop.load(fis);}
		catch(IOException io) {
			System.out.println("Unable to read configuration file");
		}
		
	}
	
	public void initialization( ) {
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver(); 
		}
		else {
			System.out.println("PLease provide valid browser details in configuration file in "+configPath);
			tearDown();
		}
		
	}
	
	public void launchApplication() {
		
		if(prop.getProperty("url")!=null) {
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		}
		else{
			tearDown();
			System.out.println("PLease provide valid application url in configuration file "+configPath);
		}
	}
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
