package com.selenium.com.selenium.practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class RegisterPage {
	static public WebDriver driver = null;
  @Test
  public void Test() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Umang");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Bhatia");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9538898365");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("umangbhatia786@gmail.com");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("154/10, Vijay Nagar");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Kanpur");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Uttar Pradesh");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("411057");
	  Thread.sleep(1000);
	  Select drpCountry = new Select(driver.findElement(By.name("country")));
	  drpCountry.selectByVisibleText("INDIA");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("umang.bhatia2508");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("chloroplast16");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("chloroplast16");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='submit']")).click();
	  Thread.sleep(1000);
	  
	  
	
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("http://demo.guru99.com/selenium/newtours/register.php");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Registered Successfully!");
	  driver.close();
  }

}
