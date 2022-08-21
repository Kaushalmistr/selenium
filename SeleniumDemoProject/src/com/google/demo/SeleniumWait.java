package com.google.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWait {

	public static void main(String args[]) {
		seleniumwait1();
	}

	public static void seleniumwait1() {
				
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Kaushal Mistry/Downloads/chromedriver/chromedriver.exe");
			WebDriver driver = new ChromeDriver(); 
			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://Google.com");
			driver.findElement(By.name("q")).sendKeys("Automation Testing");
			driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
			
			
			
			/*
			 * public WebDriverWait(WebDriver driver, Duration timeout) { this( driver,
			 * timeout, Duration.ofMillis(DEFAULT_SLEEP_TIMEOUT), Clock.systemDefaultZone(),
			 * Sleeper.SYSTEM_SLEEPER); }
			 */
			
			

			
						
			driver.close();
			driver.quit();
			
			
		}
}
