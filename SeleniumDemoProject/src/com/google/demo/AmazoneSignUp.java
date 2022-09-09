package com.google.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazoneSignUp {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Kaushal Mistry/Downloads/BrowserDriver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		String signUp = "nav-link-accountList-nav-line-1";


		driver.get("https://www.amazon.in/");
		driver.findElement(By.id(signUp)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		
	}

}
