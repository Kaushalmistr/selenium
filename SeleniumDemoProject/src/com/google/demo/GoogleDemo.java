package com.google.demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDemo {

	public static void main(String[] args) {

		System.out.println("Hello World");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Kaushal Mistry/Downloads/BrowserDriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
