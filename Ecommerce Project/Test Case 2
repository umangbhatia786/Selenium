package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class TestCase2 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/";
	public StringBuffer verificationErrors = new StringBuffer();
	
  @Test
  public void Test2() {
	  
	  //navigating to the given URL
	  
	  driver.navigate().to(baseURL);
	  
	  //Clicking on 'Mobile' menu
	  
	  driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile.html']")).click();
	  
	  //getting the price of Sony Xperia on list item page
	  
	  String listPrice = driver.findElement(By.xpath("//*[@id='product-price-1']/span")).getText();
	  System.out.println(listPrice);
	  
	  //clicking on Sony Xperia phone link
	  
	  driver.findElement(By.className("product-image")).click();
	  
	  //getting the price of Sony Xperia in product page
	  
	  String productPrice = driver.findElement(By.xpath("//*[@id='product-price-1']/span")).getText();
	  System.out.println(productPrice);
	  
	  //Verifying whether both the prices are same or not
	  
	  try {
		  AssertJUnit.assertEquals(listPrice, productPrice);
		  System.out.println("Test Case 2 : Passed");
		  
	  }
	  
	  catch(Exception e) {
		  System.out.println(e.getMessage());
		  System.out.println("Test Case 2 : Failed");
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
