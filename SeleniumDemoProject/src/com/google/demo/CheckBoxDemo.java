package com.google.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Kaushal Mistry/Downloads/NewChromeDriver/chromedriver.exe");
		
		String bookStoreApplicationCard = "//div[@class='category-cards']/div[6]";
		String elementMenu = "//div[@class='accordion']/div[1]";
		String textboxMenu = "//div[@class='accordion']/div[1]/div/ul/li[1]";
		String checkboxMenu = "//div[@class='accordion']/div[1]/div/ul/li[2]";
		String homeExpandToggleButton = "//button[@title='Toggle']";
		String expandToggleButtonOfDesktop = "//ol/li/ol/li[2]/span/button";
		String documentsExpandoggleButton = "//ol/li/ol/li[2]/span/button";
		String expandToggleButtonOfWorkspace = "//ol/li/ol/li[2]/ol/li[1]/ol/li/span"; 
		String ReactCheackbox = "//span[contains(text(),'React')]";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath(bookStoreApplicationCard)).click();
		driver.findElement(By.xpath(elementMenu)).click();
		driver.findElement(By.xpath(checkboxMenu)).click();
		driver.findElement(By.xpath(homeExpandToggleButton)).click();
		driver.findElement(By.xpath(expandToggleButtonOfDesktop)).click();
		driver.findElement(By.xpath(documentsExpandoggleButton)).click();
		driver.findElement(By.xpath(expandToggleButtonOfWorkspace)).click();		
		driver.findElement(By.xpath(ReactCheackbox));
		
		/*
		 * List<WebElement> checkbox = driver.findElements(By.name("vehicle"));
		 * ((WebElement) checkbox.get(0)).click();
		 */
//		driver.close();

	}

}
