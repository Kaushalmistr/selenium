package com.google.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Kaushal Mistry/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://www.google.com";
		
		driver.get(url);
		driver.close();
	}
}