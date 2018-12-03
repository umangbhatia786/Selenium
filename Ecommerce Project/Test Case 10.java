package gu99.eCommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TestCase10 {
	static public WebDriver driver = null;
	public String baseURL = "http://live.guru99.com/index.php/backendlogin/";
	
  @Test
  public void Test10() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//navigating to the given URL
	  driver.navigate().to(baseURL);
	  
   //Logging into the backend admin page
	  driver.findElement(By.id("username")).sendKeys("user01");
	  driver.findElement(By.xpath("//input[@id='login']")).sendKeys("guru99com");
	  driver.findElement(By.xpath("//input[@title='Login']")).click();
	  
   //Closing the incoming message
	  for (String handle : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle);
	    	} 	
	  driver.findElement(By.xpath("//*[@id='message-popup-window']/div[1]/a/span")).click();

   //Choosing Sales --> Orders Menu
	  driver.findElement(By.xpath("//*[@id='nav']/li[1]/a/span")).click();
	  driver.findElement(By.xpath("//*[@id='nav']/li[1]/ul/li[1]/a/span")).click();
	  
		for (String handle : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle);
	    	} 	   
	  
   //Choosing CSV and clicking on export
	  Select dlExport = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_export']")));
	  dlExport.selectByVisibleText("CSV");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@title = 'Export']")).click();
	  Thread.sleep(Util.SLEEP_TIME);
   //Reading the downloaded file in console
	  String filePath = System.getProperty("user.home") + "/Downloads/orders.csv";
	  File f = new File(filePath);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				System.out.println(line);
				line = br.readLine();
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
  public void afterMethod() {
	  driver.quit();
  }

}
