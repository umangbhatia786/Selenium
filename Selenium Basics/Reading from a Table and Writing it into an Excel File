package com.selenium.com.selenium.practise;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ReadingFromTableWritingonExcel {
	static public WebDriver driver = null;
  @Test
  public void Test() throws BiffException, IOException, InterruptedException, RowsExceededException, WriteException {
	  
	  
	  WritableWorkbook workbook = Workbook.createWorkbook(new File("C:\\Users\\Umang Bhatia\\Documents\\xyz.xlt"));
	  WritableSheet sheet = workbook.createSheet("Bussiness Post", 1);
	  
	  Thread.sleep(2000);
	  WebElement table = driver.findElement(By.xpath("//*[@id='ctl00_PlaceHolderMain_StaticContent2__ControlWrapper_RichHtmlField']/div[1]/table"));
	  List<WebElement> rows = table.findElements(By.tagName("tr"));
	  
	  for(int i = 0 ; i <rows.size() ; i++) {
		  List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
		  
		  for(int j = 0 ; j<columns.size() ; j++) {
			  WritableCell cell = new Label(j,i,columns.get(j).getText());
			  
			  sheet.addCell(cell);
			  
		  }
		  
	  }
	  workbook.write();
	  workbook.close();
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umang Bhatia\\Documents\\Selenium Drivers\\chrome driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("https://www.indiapost.gov.in/MBE/Pages/Content/Business-Post.aspx");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
