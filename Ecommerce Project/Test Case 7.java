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

public class TestCase7 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/";
	
  @Test
  public void Test7() throws InterruptedException, IOException {
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //navigating to the given URL
	  driver.navigate().to(baseURL);
	  
	  //Clicking on My Account
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	  
	  //Logging in into the site with a registered account
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("umangbhatia1234@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abcd1234");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  //Verification of Orders Table
	  String exHead = "RECENT ORDERS";
	  String actHead = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div/div[3]/div/h2")).getText();
	  
	  String exStatus = "Pending";
	  String actStatus = driver.findElement(By.xpath("//*[@id='my-orders-table']/tbody/tr/td[5]/em")).getText();
	  
	  try {
		  assertEquals(exHead,actHead);
		  System.out.println("****RECENT ORDERS has been confirmed to be the correct page****");
	  }
	  
	  catch (Exception ex) {
		  System.out.println("**** RECENTS ORDERS failed to get displayed ****");
		  ex.printStackTrace();
	  }
	  
	  try {
		  assertEquals(exStatus,actStatus);
		  System.out.println("*** Order status is correctly displayed as Pending ***");
	  }
	  
	  catch (Exception e) {
		  System.out.println("*** Order status not displayed as Pending");
		  e.printStackTrace();
	  }
	  //Clicking on My Orders
	  driver.findElement(By.xpath("//a[contains(.,'My Orders')]")).click();
	  
	  
	  //Clicking on View Orders
	  driver.findElement(By.xpath("//*[@id='my-orders-table']/tbody/tr/td[6]/span/a[1]")).click();
	  
	  //Clicking on Print Order
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]")).click();
	  
	  //Switching to another window
	  for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	  
	  Thread.sleep(3000);
	  
	  //Taking Screenshot as evidence that option to save receipt as PDF is coming
	  
	  File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f,new File("E:\\Guru99 Ecommerce Project\\testEvidence3.jpg"));
	  
	  Thread.sleep(2000);
	  
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
