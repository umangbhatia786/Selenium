package com.selenium.com.selenium.practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DateandTimePicker {
	static public WebDriver driver = null;
  @Test
  public void DateTimePicker() {
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  // Find Date and Time Picker 
	  WebElement dateTimeBox = driver.findElement(By.xpath("//input[@name='bdaytime']"));
	  
	  //Send Date 
	  
	  dateTimeBox.sendKeys("08251993");
	  
	  //Send Tab 
	  
	  dateTimeBox.sendKeys(Keys.TAB);
	  
	  //Sending Time 
	  
	  dateTimeBox.sendKeys("0945AM");
	  
	  //clicking on submit button 
	  
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  //prompt 
	  
	  System.out.println("Date and Time submitted successfully");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("http://demo.guru99.com/selenium/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
