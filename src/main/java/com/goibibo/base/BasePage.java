package com.goibibo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.goibibo.util.TestUtil;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop;
	
	public BasePage () {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream ("C:\\Users\\kriti\\eclipse-workspace1\\GoIbibo\\src\\main\\java\\com\\cucumber\\configuration\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName= prop.getProperty("browser");
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kriti\\eclipse-workspace1\\GoIbibo\\resouces\\drivers\\chromedriver_83.exe");
			driver = new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
}
