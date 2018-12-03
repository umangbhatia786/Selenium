package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestCase5 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/";
	public String fName = "Umang";
	public String lName = "Bhatia";
	
  @Test
  public void Test5() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //navigating to the given URL
	  driver.navigate().to(baseURL);
	  
	  //Clicking on Account button
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	    Thread.sleep(2000);
	    
	  
	  //Clicking on CREATE AN ACCOUNT
	    driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	    Thread.sleep(2000);
	    
	  //filling out the form
	    driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(fName);
	    driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lName);
	    driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("umangbhati890@gmail.com");
	    driver.findElement(By.xpath("//input[@id='password']")).clear();
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcd@12345");
	    driver.findElement(By.xpath("//input[@id='confirmation']")).clear();
	    driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("abcd@12345");
	    driver.findElement(By.xpath("//button[@title='Register']")).click();
	    Thread.sleep(2000);

	  //Verifying Registration
	    String exWelcome = ("WELCOME, " + fName.toUpperCase() + " " + lName.toUpperCase() + "!");
	    String actWelcome = driver.findElement(By.className("welcome-msg")).getText();
	    
	    try {
	    	assertEquals(exWelcome,actWelcome);
	    }
	    catch(Exception ex) {
	    	ex.printStackTrace();
	    }
	   
	    //Clicking on TV link
	    driver.findElement(By.xpath("//a[contains(.,'TV')]")).click();
	    
	    
	    //adding LG LCD in your wishlist
	    driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
	  
	    //clicking on share wishlist
	    driver.findElement(By.xpath("//button[@name='save_and_share']")).click();
	    
	    
	    //giving input email
	    driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("umangnitsxr163@gmail.com");
	    
	    //clicking on share wishlist button
	    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
	    Thread.sleep(2000);
	   
	    
	    //Verifying if wishlist has been shared or not
	    
	    String actMsg = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
	    String exMsg = "Your Wishlist has been shared.";
	    
	    try {
	    	assertEquals(actMsg,exMsg);
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
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
	  
  }

}
