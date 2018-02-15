package com.selenium.com.selenium.practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserTesting {
	static public WebDriver driver = null;

	@Test
	public void f() throws MalformedURLException, IOException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// get all links in a list

		List<WebElement> tagAList = driver.findElements(By.tagName("a"));
		System.out.println("Total number of text links present on in this page are " + tagAList.size());

		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		System.out.println("Total number of image links present on in this page are " + imgList.size());

		// Total number of links
		tagAList.addAll(imgList);
		// get all URLs from taglist and imgList and check if its response code is 200

		HttpURLConnection con = null;

		for (WebElement el : tagAList) {
			String url = el.getAttribute("href");

			if (url != null && !(url.contains("javascript"))) {
				con = (HttpURLConnection) (new URL(url)).openConnection();
				con.connect();
				con.setConnectTimeout(3000);
				int respCode = con.getResponseCode();

				System.out.println("Response code for link with text " + el.getText() + " with link as "
						+ el.getAttribute("href").toString() + " is " + respCode);
			}
		}
	}

	@BeforeTest
	@Parameters("browser")
	public static void beforeMethod(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
			//create Edge instance
			driver = new EdgeDriver();
		}
		driver.navigate().to("https://www.google.co.in/?gws_rd=ssl");
	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
	}

}
