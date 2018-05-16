package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

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
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class TestCase1 {
	static public WebDriver driver = null;
	public StringBuffer verificationErrors = new StringBuffer();
	public String baseURL = "http://live.guru99.com/index.php/";
  @Test
  public void Test1() throws IOException {
	  //navigating to the given URL
	  
	  driver.navigate().to(baseURL);
	  
	  //Verifying Title of the first page
	  
	  String pageTitle1 = driver.findElement(By.xpath("//h2[contains(.,'This is demo site for   ')]")).getText();
	  System.out.println(pageTitle1);
	  
	  try {
		  AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", pageTitle1);
	  }
	  catch(Exception e) {
		  
		  verificationErrors.append(e.toString());
	  }
	  
	  //Clicking on 'Mobile' menu
	  
	  driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile.html']")).click();
	  
	  //Selecting 'SORT BY' from the dropdown list
	  
	  Select sortBy = new Select(driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
	  sortBy.selectByIndex(1);
	  
	  //Taking a screenshot to verify that the items have been sorted by name 
	  
	  File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f,new File("E:\\Guru99 Ecommerce Project\\testEvidence1.jpg"));
	  
	  
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
	  driver.close();
	  
  }
  
}


