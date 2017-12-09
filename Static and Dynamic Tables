package com.selenium.com.selenium.practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class StaticandDynamicTables {
	static public WebDriver driver = null;
	
  @Test(priority=0)
  public void DynamicTable() {
	  driver.navigate().to("http://demo.guru99.com/selenium/table/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  //Finding the Table
	  
	  WebElement table = driver.findElement(By.xpath("html/body/table/tbody"));
	  
	  //Finding number of rows
	  List<WebElement> rows = table.findElements(By.tagName("tr"));
	  //Finding number of rows in a table 
	  
	  int row_count = rows.size();
	  
	  //Finding value of column of each row 
	  
	  for(int j=0 ; j< row_count ; j++) {
		  List<WebElement> columns = rows.get(j).findElements(By.tagName("td"));
		  int k = 0;
		  k = j + 1;
		  System.out.println("Number of cells in row " + k + " are " + columns.size());
		  
		  for(int m = 0 ; m<columns.size() ; m++) {
			  int x = 0;
			  x = m + 1;
			  System.out.println("Cell value of row number " + k + " and column number " + x  + " is " + columns.get(m).getText());
		  }
		  System.out.println("**********************************************");
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
