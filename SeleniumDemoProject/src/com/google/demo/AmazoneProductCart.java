package com.google.demo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazoneProductCart  {

		public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Kaushal Mistry/Downloads/BrowserDriver/chromedriver.exe");
			
			//Locators of element
			String searchTextBox = "//form/div[2]/div/input";
			String searchIcon = "//form/div[3]/div";
			String firstResult = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-4']/descendant::div[4]";
			String productTitle = "productTitle";
			String productPriceToPay = "//span[@data-a-color='base']/span[@class='a-offscreen']";
			
			//Web driver initialization
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
			//tab 1
			driver.get("https://www.amazon.in/");
			driver.findElement(By.xpath(searchTextBox)).sendKeys("Iphone XR");
			driver.findElement(By.xpath(searchIcon)).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.findElement(By.xpath(firstResult)).click();
			
			String currentPageId = driver.getWindowHandle();
			System.out.println("Current page Id : " + currentPageId);
			
			Set<String> windowsIds = driver.getWindowHandles();
			
			System.out.println("No of tabs opened : " + windowsIds.size());
			
			for (String tabIds : windowsIds) {
				System.out.println("Id's for tabs : " + tabIds);
			}
			
			driver.switchTo();
			//tab 2
			String productName = driver.findElement(By.id(productTitle)).getText();
			System.out.println("Product Name : " + productName);
			
			String productPrice = driver.findElement(By.xpath(productPriceToPay)).getText();
			System.out.println("Product price to pay : " + productPrice);
		}
	}
	
	
