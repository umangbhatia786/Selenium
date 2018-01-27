package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TestCase8 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/";
	
  @Test
  public void Test8() throws InterruptedException, IOException {
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //navigating to the given URL
	  driver.navigate().to(baseURL);
	  
	  //Clicking on My Account
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	  
	  //Logging in into the site with a registered account
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("umangbhatia1234@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abcd1234");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  //Clicking on Reorder
	  driver.findElement(By.xpath("//*[@id='my-orders-table']/tbody/tr/td[6]/span/a[2]")).click();
	  
	  //Capturing initial GRAND TOTAL
	  String inTotal = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
	  System.out.println("Initial Grand Total is " + inTotal);
	  
	  //Updating quantity of order
	  driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).click();
	  driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();
	  driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("10");
	  
	  driver.findElement(By.xpath("//button[@title='Update']")).click();
	  
	  //Verifying final Grand Total
	  String finTotal = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
	  
	  try {
		  System.out.println("Updated Grand Total is " + finTotal);
		  assertNotEquals(inTotal,finTotal);
		  System.out.println("**** GRAND TOTAL has been updated ***");
	  }
	  
	  catch(Exception ex) {
		  System.out.println("*** GRAND TOTAL has not been updated ***");
		  ex.printStackTrace();
	  }
	  
	//Click on Proceed to Checkout
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button")).click();
	  
	//Billing Information
	  
	  Select dlAddress = new Select(driver.findElement(By.xpath("//select[@id='billing-address-select']")));
	  dlAddress.selectByValue("2624");
	  driver.findElement(By.xpath("//input[@id='billing:use_for_shipping_yes']")).click();
	  driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button")).click();
	  Thread.sleep(2000);
	//Shipping Information
	  driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/button")).click();
	  Thread.sleep(2000);
	//Payment Information
	  driver.findElement(By.xpath("//input[@id='p_method_checkmo']")).click();
	  driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click();
	  Thread.sleep(2000);
	  
	 //Order Overview
	  driver.findElement(By.xpath("//button[@title='Place Order']")).click();
	  Thread.sleep(2000);
	 //Verify Oder is generated. Note the order number 
	  String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	
	  System.out.println("*** Your order number for your record = " + orderNum);
	  
	  File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f,new File("E:\\Guru99 Ecommerce Project\\testEvidence4.jpg"));
	  
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
