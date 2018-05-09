package com.selenium.com.selenium.practise;

import org.testng.annotations.Test;
import jxl.read.biff.BiffException;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class MultipleCasesUsingExcel {
	public static WebDriver driver = null;

	@Test
	public void Test() throws BiffException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Clicking on My Account Link
		driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
		
		String userName,passWord,actualTitle;
		String[][] tabData = Util.getDataFromExcel(Util.XLPATH);
		
        	for(int i=0; i<tabData.length ; i++) {
			userName = tabData[i][0];
			passWord = tabData[i][1];
			
			driver.findElement(By.xpath("//input[@id='email']")).clear();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
			
			driver.findElement(By.xpath("//input[@id='pass']")).clear();
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(passWord);
			
			driver.findElement(By.xpath("//button[@id='send2']")).click();
			int x = i + 1;
			try {
				actualTitle = driver.getTitle();
				if(actualTitle.contains(Util.FINAL_TITLE) && i == 3) {
					System.out.println("Test case " + x + " Passed");
				}
				
				else if(actualTitle.contains(Util.INTIAL_TITLE)) {
					System.out.println("Test case " + x + " Passed");
				}
				else {
					System.out.println("Test case " + x + " Failed");
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
       }
		}


	@BeforeMethod
	public void beforeMethod() {
		System.setProperty(Util.DRIVER,Util.DRIVER_PATH);
		driver = new ChromeDriver();
		driver.navigate().to(Util.URL);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
