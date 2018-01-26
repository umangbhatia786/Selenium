package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TestCase6 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/";
  @Test
  public void Test6() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //navigating to the given URL
	  driver.navigate().to(baseURL);
	  
	  //Clicking on My Account
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	 
	  
	  //Logging in into the site with a registered account
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("umangbhatia1234@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abcd1234");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  //Clicking on My Wishlist link
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();
	  
	  //Add to Cart
	  driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
	  
	  
	  //Estimate shipping
	  Thread.sleep(2000);
	  Select dlcountry = new Select(driver.findElement(By.xpath("//select[@name='country_id']")));
	  dlcountry.selectByValue("US");
	  
	  Select dlState = new Select(driver.findElement(By.xpath("//select[@id='region_id']")));
	  dlState.selectByValue("43");
	  driver.findElement(By.xpath("//input[@id='postcode']")).clear();
	  driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("542896");
	  driver.findElement(By.xpath("//button[@onclick='coShippingMethodForm.submit()']")).click();
	  
	  //Verifying shipping cost generated
	  
	  String sFlatRate = "Flat Rate";
	    String flatRate = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dt")).getText();	
	    try {
	    	System.out.println("sFlatRate = "+sFlatRate);
	    	System.out.println("flatRate = "+flatRate);
	    	assertEquals(sFlatRate, flatRate);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    String sFlatRatePrice = "Fixed - $5.00";
	    String flatRatePrice = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dd/ul/li/label")).getText();
	    try {	 
	    	System.out.println("sFlatRatePrice = "+sFlatRatePrice);
	    	System.out.println("flatRatePrice = "+flatRatePrice);
	    	assertEquals(sFlatRatePrice, flatRatePrice);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }
	  
	  //Updating Total
	    driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']")).click();
	    driver.findElement(By.xpath("//button[@name='do']")).click();
	    
	  //Verifying if Shipping cost is added
	    String vFlatRatePrice = "$5.00";
	    String shippingCostIncluded = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
	    
	    try {
	    	System.out.println("vFlatRatePrice = "+vFlatRatePrice);
	    	System.out.println("shippingCostIncluded = "+shippingCostIncluded);
	    	assertEquals(vFlatRatePrice, shippingCostIncluded);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }
	    
	   //Click on Proceed to Checkout
	    driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button")).click();
	    
	  //Billing Information
	  driver.findElement(By.xpath("//input[@id='billing:street1']")).clear();
	  driver.findElement(By.xpath("//input[@id='billing:street1']")).sendKeys("ABC");
	  driver.findElement(By.xpath("//input[@id='billing:city']")).clear();
	  driver.findElement(By.xpath("//input[@id='billing:city']")).sendKeys("New York");
	  
	  Select dlProvince = new Select(driver.findElement(By.xpath("//select[@id='billing:region_id']")));
	  dlProvince.selectByVisibleText("New York");
	  
	  driver.findElement(By.xpath("//input[@id='billing:postcode']")).clear();
	  driver.findElement(By.xpath("//input[@id='billing:postcode']")).sendKeys("542896");
	  
	  Select dlCountry = new Select(driver.findElement(By.xpath("//select[@id='billing:country_id']")));
	  dlCountry.selectByVisibleText("United States");
	  
	  driver.findElement(By.id("billing:telephone")).clear();
	  driver.findElement(By.id("billing:telephone")).sendKeys("12345678"); 
	  driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button")).click();
	  
	  // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) {  
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	  //Shipping Method
	  driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/button")).click();
	  
	  //Payment Information
	  driver.findElement(By.xpath("//input[@id='p_method_checkmo']")).click();
	  driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click();
	  
	  //Order Overview
	  driver.findElement(By.xpath("//button[@title='Place Order']")).click();
	  
	  //Verify Oder is generated. Note the order number 
	  String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	
	  System.out.println("*** Your order number for your record = " + orderNum);

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
