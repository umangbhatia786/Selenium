package guru99.project.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestUsingPhantomJS {
	public static WebDriver driver = null;
  @Test(dataProvider="getInputData")
  public void TestCase(String username,String password) throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	  driver.findElement(By.name("uid")).clear();
	  driver.findElement(By.name("uid")).sendKeys(username);
	  
	   		  //Inputting password
	
	   		  driver.findElement(By.name("password")).clear(); 
	 		  driver.findElement(By.name("password")).sendKeys(password); 
	   		   
	   		  //Clicking on login button 
	   		  driver.findElement(By.name("btnLogin")).click(); 
	   		   
	   		  try { 
	   			  Alert alert = driver.switchTo().alert(); 
	   			  String actualBoxTitle = alert.getText(); 
	   			  alert.accept(); 
	   			  Assert.assertEquals(actualBoxTitle, Util.EXPECT_ERROR);
	   			  
	   		  } 
	   		   
	  		  catch(NoAlertPresentException ex) { 
	  			  String actualTitle = driver.getTitle(); 
	  			  Assert.assertEquals(actualTitle, Util.EXPECTED_TITLE);
	  			   
	  		  } 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty(Util.WEBDRIVER_NAME,Util.CHROME_PATH);
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("headless");
	  options.addArguments("windows-size=1200x600");
	  
	  driver = new ChromeDriver(options);
	  driver.navigate().to(Util.BASE_URL);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  @DataProvider(name="getInputData")
  public Object[][] getcrdentials() {
	  return new Object[][] {
		  {Util.USER_NAME,Util.PASSWORD},
		  {Util.USER_NAME,"Invalid"},
		  {"Invalid",Util.PASSWORD},
		  {"Invalid1","Invalid2"}
	  };
  }
}
