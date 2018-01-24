package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestCase4 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/";
	
  @Test
  public void Test4() throws IOException, InterruptedException {
	//navigating to the given URL
	  driver.navigate().to(baseURL);
	  
	//Clicking on mobile link
	  driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile.html']")).click();
	  Thread.sleep(2000);
	//adding Sony Xperia and Iphone for comparison
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	  Thread.sleep(1000);
	  String mainMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
	  String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
	//Clicking on Compare button
	  driver.findElement(By.xpath("//button[@title='Compare']")).click();
	  Thread.sleep(1000);
	//iterating to popup window , using it and then switching back to the main window
	  
	  for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	driver.manage().window().maximize();
	    	}

	  
	  //Screenshot of compare window
	  File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f,new File("E:\\Guru99 Ecommerce Project\\testEvidence2.jpg"));
	  
	  //validations in popup 
	  String expectedHead = ("COMPARE PRODUCTS");
	  String actualHead = driver.findElement(By.xpath("//*[@id='top']/body/div/div[1]/h1")).getText();
	  
	  String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured is "IPHONE" in uppercase
	  String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured "SONY XPERIA" in uppercase
	  
	  Thread.sleep(1000);
	   
	  try {
		  assertEquals(expectedHead,actualHead);
	  }
	  catch(Exception ex) {
		  ex.printStackTrace();
	  }
	  
	  try {
		  assertEquals(mainMobile1,popupMobile1);
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  try {
		  assertEquals(mainMobile2,popupMobile2);
	  }
	  catch(Exception y) {
		  y.printStackTrace();
	  }
	  //closing popup window
	  driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	  
	  //returning control to main window
	  for (String handle : driver.getWindowHandles()) {
		    driver.switchTo().window(handle);
		    }	
	  
	
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
	  
  }

}
