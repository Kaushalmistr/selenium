package com.google.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraLoginDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Kaushal Mistry/Downloads/chromedriver/chromedriver.exe");
		
		
		String ProfileLogin = "//div[@class='desktop-userIconsContainer']/span[2]";
		String LoginAndSignup = "//div[@class='desktop-getUserInLinks desktop-getInLinks']/a";
		String Login = "//div[@class='form-group ']/input";
		String LoginSubmit = "//div[@class='submitBottomOption']";
		/*
		 * String ClickLoginPassword ="//div[@class='bottomeLink']/span[1]"; String
		 * UserName = "mobileNumberPass"; String UserPassword = "password"; String
		 * LoginSubmitButton = "//div[@class='form-group']/button"
		 */
		

		//Web driver initialization
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://www.myntra.com");
		driver.findElement(By.xpath(ProfileLogin)).click();
		driver.findElement(By.xpath(LoginAndSignup)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath(Login)).sendKeys("9594383754");   //Login mobile Number
		driver.findElement(By.xpath(LoginSubmit)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		 * driver.findElement(By.xpath(ClickLoginPassword)).click(); //Click on Password
		 * driver.findElement(By.id(UserName)).sendKeys("9594383754"); //User Mobile
		 * Number driver.findElement(By.id(UserPassword)); //Login Password
		 * driver.findElement(By.xpath(LoginSubmitButton));//Login Button
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 */		
		
		
	}

}
