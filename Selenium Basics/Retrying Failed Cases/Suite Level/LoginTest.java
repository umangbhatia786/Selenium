package com.retry;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	public static WebDriver driver = null;
	Logger log = Logger.getLogger(LoginTest.class);

	@Test(priority = 0)
	public void TitleTest() {
		log.info("Fetching Page Title");
		String title = driver.getTitle();
		log.debug("Asserting the page title");
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and servic");
	}

	@Test(priority = 1)
	public void LogoTest() {
		log.debug("Asserting the page logo");
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed());
	}

	@BeforeTest
	public void beforeTest() {
		log.info(
				"******************************************FREE CRM Testing Start**************************************");
		log.info("Setting Driver properties");
		System.setProperty("webdriver.chrome.driver", "C:\\UBS\\Dev\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		log.info("Setting up all the required Timeouts");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Navigating to FREE CRM Application");
		driver.navigate().to("https://www.freecrm.com/index.html");
	}

	@AfterTest
	public void afterTest() {
		log.info("Closing the browser session");
		log.info(
				"******************************************FREE CRM Testing End**************************************");
		driver.quit();
	}

}
