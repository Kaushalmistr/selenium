package com.google.demo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Scenario 1 : Add to cart
//Scenario 2 : Remove from cart
//Scenario 3 : Add to saveForLater
//Scenario 4 : Remove from saveToLater

public class AmazoneProductCart {

	public static void main(String[] args) {

		AmazoneProductCart amazonTest = new AmazoneProductCart();

//		 amazonTest.addProductToCartTest();
//		amazonTest.removeProductFromCartTest();
//		amazonTest.addProductToSaveToLaterTest();
		amazonTest.removeProductFromSaveToLaterTest();

	}

	public WebDriver webDriverInitialization() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Kaushal Mistry/Downloads/BrowserDriver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		return driver;
	}

	public void addProductToCartTest() {

		WebDriver driver = webDriverInitialization();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locators of element
		String searchTextBox = "//form/div[2]/div/input";
		String searchIcon = "//form/div[3]/div";
		String firstResult = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-4']/descendant::div[4]";
		String productTitle = "productTitle";
		String productPriceToPay = "//span[@data-a-color='base']/descendant::span[4]";
		String productDecimalPrice = "//span[@data-a-color='base']/descendant::span[6]";
		String addToCartButton = "//span[@id='sw-gtc']/span";
		String addToCartSuccesMsg = "//div[@id='attachDisplayAddBaseAlert']/span";

		// Steps
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath(searchTextBox)).sendKeys("Iphone XR");
		driver.findElement(By.xpath(searchIcon)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath(firstResult)).click();

		String currentPageId = driver.getWindowHandle();

		Set<String> windowsIds = driver.getWindowHandles();

		// Switching to new tab
		for (String tabIds : windowsIds) {
			if (!currentPageId.equals(tabIds)) {
				driver.switchTo().window(tabIds);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			}
		}

		String productName = driver.findElement(By.id(productTitle)).getText();
		System.out.println("Product Name : " + productName);

		String productPrice = driver.findElement(By.xpath(productPriceToPay)).getText();
		String decValues = driver.findElement(By.xpath(productDecimalPrice)).getText();
		System.out.println("Product price to pay : " + productPrice + "." + decValues);

		WebElement addToCartBtn = driver.findElement(By.id(addToCartButton));
		js.executeScript("arguments[0].scrollIntoView();", addToCartBtn);
		addToCartBtn.click();

		WebElement sucessMsg = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToCartSuccesMsg)));

		System.out.println("SuccessMsg : " + sucessMsg.getText());
		driver.quit();
	}

	public void removeProductFromCartTest() {

		WebDriver driver = webDriverInitialization();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locators
		String searchTextBox = "//form/div[2]/div/input";
		String searchIcon = "//form/div[3]/div";
		String firstResult = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-4']/descendant::div[4]";
		String productTitle = "productTitle";
		String productPriceToPay = "//span[@data-a-color='base']/descendant::span[4]";
		String productDecimalPrice = "//span[@data-a-color='base']/descendant::span[6]";
		String addToCartButton = "add-to-cart-button";
		String addToCartSuccesMsg = "//div[@id='attachDisplayAddBaseAlert']/span";
		String viewCart = "//span[@id='attach-sidesheet-view-cart-button']";
//		String goToCartButton = "//span[@id='sw-gtc']/span";

		String deleteLink = "//span[@class='a-size-small sc-action-delete']/span/input";
		String deleteSucessMsg = "//div[@class='a-row sc-cart-header']/div";

		// Steps
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath(searchTextBox)).sendKeys("Iphone XR");
		driver.findElement(By.xpath(searchIcon)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath(firstResult)).click();

		String currentPageId = driver.getWindowHandle();

		Set<String> windowsIds = driver.getWindowHandles();

		// Switching to new tab
		for (String tabIds : windowsIds) {
			if (!currentPageId.equals(tabIds)) {
				driver.switchTo().window(tabIds);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			}
		}

		String productName = driver.findElement(By.id(productTitle)).getText();
		System.out.println("Product Name : " + productName);

		String productPrice = driver.findElement(By.xpath(productPriceToPay)).getText();
		String decValues = driver.findElement(By.xpath(productDecimalPrice)).getText();
		System.out.println("Product price to pay : " + productPrice + "." + decValues);

		WebElement addToCartBtn = driver.findElement(By.id(addToCartButton));
		js.executeScript("arguments[0].scrollIntoView();", addToCartBtn);
		addToCartBtn.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement sucessMsg = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToCartSuccesMsg)));

		System.out.println("SuccessMsg : " + sucessMsg.getText());

		driver.findElement(By.xpath(viewCart)).click();

//		driver.findElement(By.xpath(goToCartButton)).click();
		// driver.findElement(By.linkText("viewCart")).submit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath(deleteLink)).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement del = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteSucessMsg)));

		System.out.println("DeleteMsg : " + del.getText());

		driver.quit();

	}

	public void addProductToSaveToLaterTest() {

		WebDriver driver = webDriverInitialization();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locators
		String searchTextBox = "//form/div[2]/div/input";
		String searchIcon = "//form/div[3]/div";
		String firstResult = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-4']/descendant::div[4]";
		String productTitle = "productTitle";
		String productPriceToPay = "//span[@data-a-color='base']/descendant::span[4]";
		String productDecimalPrice = "//span[@data-a-color='base']/descendant::span[6]";
		String addToCartButton = "add-to-cart-button";
		String addToCartSuccesMsg = "//div[@id='attachDisplayAddBaseAlert']/span";
		String viewCart = "//span[@id='attach-sidesheet-view-cart-button']";
//		String goToCartButton = "//span[@id='sw-gtc']/span";

		String saveLaterLink = "//span[@class='a-size-small sc-action-save-for-later']/span/input";
		String saveForLaterMssg = "//div[@class='a-padding-medium'][2]/span[1]";

		// Steps
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath(searchTextBox)).sendKeys("Iphone XR");
		driver.findElement(By.xpath(searchIcon)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath(firstResult)).click();

		String currentPageId = driver.getWindowHandle();
		Set<String> windowsIds = driver.getWindowHandles();

		// Switching to new tab
		for (String tabIds : windowsIds) {
			if (!currentPageId.equals(tabIds)) {
				driver.switchTo().window(tabIds);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			}
		}

		String productName = driver.findElement(By.id(productTitle)).getText();
		System.out.println("Product Name : " + productName);

		String productPrice = driver.findElement(By.xpath(productPriceToPay)).getText();
		String decValues = driver.findElement(By.xpath(productDecimalPrice)).getText();
		System.out.println("Product price to pay : " + productPrice + "." + decValues);

		WebElement addToCartBtn = driver.findElement(By.id(addToCartButton));
		js.executeScript("arguments[0].scrollIntoView();", addToCartBtn);
		addToCartBtn.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement sucessMsg = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToCartSuccesMsg)));

		System.out.println("SuccessMsg : " + sucessMsg.getText());

		driver.findElement(By.xpath(viewCart)).click();

//		driver.findElement(By.xpath(goToCartButton)).click();
		// driver.findElement(By.linkText("viewCart")).submit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath(saveLaterLink)).click();

		WebElement saveLaterMssg = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveForLaterMssg)));

		System.out.println("" + saveLaterMssg.getText());

		driver.quit();

	}

	public void removeProductFromSaveToLaterTest() {

		WebDriver driver = webDriverInitialization();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locators
		String searchTextBox = "//form/div[2]/div/input";
		String searchIcon = "//form/div[3]/div";
		String firstResult = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-4']/descendant::div[4]";
		String productTitle = "productTitle";
		String productPriceToPay = "//span[@data-a-color='base']/descendant::span[4]";
		String productDecimalPrice = "//span[@data-a-color='base']/descendant::span[6]";
		String addToCartButton = "add-to-cart-button";
		String addToCartSuccesMsg = "//div[@id='attachDisplayAddBaseAlert']/span";
		String viewCart = "//span[@id='attach-sidesheet-view-cart-button']";
//		String goToCartButton = "//span[@id='sw-gtc']/span";

		String saveLaterLink = "//span[@class='a-size-small sc-action-save-for-later']/span/input";
		String saveForLaterMssg = "//div[@class='a-padding-medium'][2]/span[1]";
		String deleteProductFromSaveToLater = "//span[@class='a-size-small sc-action-delete']/span/input";
		String deleteProductFromSaveToLaterMssg = "//div[@class='sc-list-item-removed-msg']/div[2]/span/a";

		// Steps
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath(searchTextBox)).sendKeys("Iphone XR");
		driver.findElement(By.xpath(searchIcon)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath(firstResult)).click();

		String currentPageId = driver.getWindowHandle();
		Set<String> windowsIds = driver.getWindowHandles();

		// Switching to new tab
		for (String tabIds : windowsIds) {
			if (!currentPageId.equals(tabIds)) {
				driver.switchTo().window(tabIds);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			}
		}

		String productName = driver.findElement(By.id(productTitle)).getText();
		System.out.println("Product Name : " + productName);

		String productPrice = driver.findElement(By.xpath(productPriceToPay)).getText();
		String decValues = driver.findElement(By.xpath(productDecimalPrice)).getText();
		System.out.println("Product price to pay : " + productPrice + "." + decValues);

		WebElement addToCartBtn = driver.findElement(By.id(addToCartButton));
		js.executeScript("arguments[0].scrollIntoView();", addToCartBtn);
		addToCartBtn.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement sucessMsg = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToCartSuccesMsg)));

		System.out.println("SuccessMsg : " + sucessMsg.getText());

		driver.findElement(By.xpath(viewCart)).click();

//		driver.findElement(By.xpath(goToCartButton)).click();
		// driver.findElement(By.linkText("viewCart")).submit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath(saveLaterLink)).click();

		WebElement saveLaterMssg = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveForLaterMssg)));

		System.out.println("" + saveLaterMssg.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath(deleteProductFromSaveToLater)).click();

		WebElement removeProductFromSaveToLater = new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteProductFromSaveToLaterMssg)));

		System.out.println("" + removeProductFromSaveToLater.getText());

		driver.quit();

	}
}
