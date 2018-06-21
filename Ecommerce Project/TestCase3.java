package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
	
public class TestCase3 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/";
	
  @Test
  public void Test3() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //navigating to the given URL
	  driver.navigate().to(baseURL);
	  
	  //Clicking on mobile link
	  driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile.html']")).click();
	  
	  //clicking on Add to cart
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
	  
	  //Clicking on quantity textbox
	  driver.findElement(By.xpath("//input[@class='input-text qty']")).click();
	  //clearing text in text box
	  driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
	  //giving quantity as 1000
	  driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("1000");
	  
	  //clicking on update button
	  driver.findElement(By.xpath("//button[@title='Update']")).click();
	  
	  //Verification of error message
	  String expectedError = ("* The requested quantity for \"Sony Xperia\" is not available.");
	  String actualError = driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p")).getText();	
	  
	  try {
		  
		 assertEquals(expectedError,actualError);
		 
	  }
	  
	  catch(Exception ex) {
		  
		  ex.printStackTrace();
		  
	  }
	  
	  //Verifying message after emptying the cart
	  
	  driver.findElement(By.id("empty_cart_button")).click();
	  String noItemsStg = ("You have no items in your shopping cart.");
	  String noItemsMsg = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div[2]/p[1]")).getText();
	  System.out.println("You have no items msg = " + noItemsMsg);
	    
	  try {
		  
		  assertEquals(noItemsStg, noItemsMsg);
	  }
	  
	  catch(Exception e) {
		  e.printStackTrace();
	
	  } 
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
