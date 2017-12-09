package com.selenium.com.selenium.practise;
import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DownloadandUpload {
	static public WebDriver driver = null;
	
  @Test(priority = 0)
  public void Upload() {
	  driver.navigate().to("http://demo.guru99.com/selenium/upload/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//input[@id='uploadfile_0']")).sendKeys("C:\\Users\\Umang Bhatia\\Documents\\Selenium Notes.txt");
	  
	  driver.findElement(By.xpath("//input[@id='terms']")).click();
	  driver.findElement(By.xpath("//button[@id='submitbutton']")).click();
	  
  }
  @Test(priority = 1)
  public void Download() {
	  driver.navigate().to("http://demo.guru99.com/selenium/yahoo.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  WebElement downloadBtn = driver.findElement(By.xpath("//a[@id='messenger-download']"));
	  String sourceLink = downloadBtn.getAttribute("href");
	  
	  String wget_command = "cmd /c C:\\Wget\\wget.exe -P E: --no-check-certificate " + sourceLink;
	  
	  try {
	        Process exec = Runtime.getRuntime().exec(wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        } 
	  catch (InterruptedException | IOException ex) {
	        System.out.println(ex.toString());
	        }  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
