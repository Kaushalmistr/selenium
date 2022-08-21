package com.google.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolqaDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting property for chromedriver
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Kaushal Mistry/Downloads/NewChromeDriver/chromedriver.exe");

		// Setting locators
		String bookStoreApplicationCard = "//div[@class='category-cards']/div[6]";
		String elementMenu = "//div[@class='accordion']/div[1]";
		String textboxMenu = "//div[@class='accordion']/div[1]/div/ul/li[1]";
		String checkboxMenu = "//div[@class='accordion']/div[1]/div/ul/li[2]";
		String homeExpandToggleButton = "//button[@title='Toggle']";
		String expandToggleButtonOfDesktop = "//ol/li/ol/li[1]/span/button";
		String commandCheckbox = "//span[contains(text(),'Commands')]";
		String result1 = "//div[@id='result']/span[1]";
		String result2 = "//div[@id='result']/span[2]";

		// Initializing the chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath(bookStoreApplicationCard)).click();
		driver.findElement(By.xpath(elementMenu)).click();
		driver.findElement(By.xpath(checkboxMenu)).click();
		driver.findElement(By.xpath(homeExpandToggleButton)).click();
		driver.findElement(By.xpath(expandToggleButtonOfDesktop)).click();
		driver.findElement(By.xpath(commandCheckbox)).click();
		String result = driver.findElement(By.xpath(result1)).getText();
		result += driver.findElement(By.xpath(result2)).getText();

		System.out.println("The result = " + result);

		driver.close();

//		String commands = "You have selected: commands ";

		// Test case 1

		/*
		 * //Step 1 : Launch the browser WebDriver driver = new ChromeDriver();
		 * driver.manage().window().maximize();
		 * 
		 * //Step 2 : Navigate to the DemoQA landing page String mainLandingPageUrl =
		 * "https://demoqa.com/"; driver.get(mainLandingPageUrl);
		 * System.out.println("URL : " + driver.getCurrentUrl());
		 * 
		 * //Step 3 : Click on "Book Store" card
		 * 
		 * // xpath for book store application text - //h5[contains(text(),'Book Store
		 * Application')]
		 * driver.findElement(By.xpath("//div[@class='category-cards']/div[6]")).click()
		 * ; System.out.println("New URL : " + driver.getCurrentUrl());
		 * 
		 * //Step 4 : Verify the header of Book store page //xpath for Book store header
		 * - //div[@class='main-header'] String bookStoreHeader =
		 * driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		 * System.out.println("Header for book store application : " + bookStoreHeader);
		 */

		// Test case 2
		/*
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 * 
		 * driver.get("https://demoqa.com/");
		 * driver.findElement(By.xpath("//div[@class='category-cards']/div[6]")).click()
		 * ; driver.findElement(By.xpath("//div[@class='accordion']/div[4]")).click();
		 * 
		 * List<WebElement> listOfElements; listOfElements =
		 * driver.findElements(By.xpath(
		 * "//div[@class='accordion']/div[4]/div/ul/li/span"));
		 * 
		 * for (WebElement webElement : listOfElements) {
		 * System.out.println("Name of elements : " + webElement.getText());
		 * 
		 * }
		 */

		/*
		 * driver.findElement(By.id("userName")).sendKeys("Kaushal is great");
		 * 
		 * 
		 * driver.findElement(By.id("userName")).clear();
		 * 
		 * driver.findElement(By.id("userName")).sendKeys("Selenium is great");
		 */

		/*
		 * WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(100))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		 */
		// driver.close();

		/*
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) .withTimeout(30,
		 * TimeUnit.SECONDS)
		 */

	}

}
