package com.selenium.com.selenium.practise;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.File;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterTest;

public class ReadingFromExcel {
  @Test
  public void ReadExcel() throws BiffException, IOException {
	  String FilePath = "C:\\Users\\Umang Bhatia\\Documents\\data_read.xlt";
	  FileInputStream fs = new FileInputStream(FilePath);
	  Workbook wb = Workbook.getWorkbook(fs);
	  
	  //to get access of sheets
	  Sheet sh = wb.getSheet(0);
	  
	  //to get total number of rows present in file
	  
	  int rows = sh.getRows();
	  
	  // to get number of columns
	  
	  int columns = sh.getColumns();
	  
	  //to print the contents of excel
	  
	  for(int i=0 ; i<rows ; i++) {
		  for(int j=0; j<columns ; j++) {
			  System.out.println(sh.getCell(j,i).getContents() + "\t");
		  }
		  System.out.println();
	  }
	  wb.close();
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
