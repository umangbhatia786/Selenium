package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestCase9 {
	static public WebDriver driver = null;
	
  @Test
  public void Test9() {
	 
	  
	  //navigating to the given URL
	  driver.navigate().to(Util.URL);
	  
	  //Clicking on MOBILE tab
	  driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();
	  
	  //Adding IPHONE to cart
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button")).click();
	  
	  //Capturing Intitial price 
	  String inPrice = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
	  //Giving coupan code
	  driver.findElement(By.xpath("//input[@id='coupon_code']")).clear();
	  driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("GURU50");
	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
	  
	  //Verifying if discount is applied
	  int originalPrice = Integer.valueOf(inPrice.substring(1,4));
	  int exDiscount = (originalPrice * 5)/100;
	  String discnt = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
	  int actDiscount = Integer.valueOf(discnt.substring(2,4));
	 
	  String actNewPrice = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
	  int newPrice = Integer.valueOf(actNewPrice.substring(1,4));
	  try {
		  Assert.assertEquals(exDiscount, actDiscount);
		  System.out.println("A valid discount of $" + discnt.substring(2,4) + " has been applied");
	  }
	  catch(Exception ex) {
		  System.out.println("Invalid Discount apllied!");
		  ex.printStackTrace();
	  }
	  
	  try {
		  assertNotEquals(originalPrice, newPrice);
		  System.out.println("Valid Discounted amount is not being displayed");
	  }
	  
	  catch(Exception e) {
		  System.out.println("Invalid Discounted amount is being displayed!");
		  e.printStackTrace();
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
