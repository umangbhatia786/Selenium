package Testing;

import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.apache.commons.lang.math.NumberUtils;


public class ConvertExcel {
  @Test(priority = 0)
  public void XLStoCSV() throws IOException, InterruptedException {
	//First we read the Excel file in binary format into FileInputStream
      FileInputStream input_document = new FileInputStream(new File(Util.XLS_FILE_PATH));
      // Read workbook into HSSFWorkbook
      HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document); 
      // Read worksheet into HSSFSheet
      HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
      // To iterate over the rows
      Iterator<Row> rowIterator = my_worksheet.iterator();
      // OpenCSV writer object to create CSV file
      FileWriter my_csv=new FileWriter(Util.CSV_FILE_PATH);
      CSVWriter my_csv_output=new CSVWriter(my_csv); 
      //Loop through rows.
      while(rowIterator.hasNext()) {
              Row row = rowIterator.next(); 
              int i=0;//String array
              //change this depending on the length of your sheet
              String[] csvdata = new String[row.getPhysicalNumberOfCells()];
              Iterator<Cell> cellIterator = row.cellIterator();
                      while(cellIterator.hasNext()) {
                              Cell cell = cellIterator.next(); //Fetch CELL
                              switch(cell.getCellType()) { //Identify CELL type
                                      //you need to add more code here based on
                                      //your requirement / transformations
                              case Cell.CELL_TYPE_STRING:
                                      csvdata[i]= cell.getStringCellValue();                                              
                                      break;
                              case Cell.CELL_TYPE_NUMERIC:
                                  csvdata[i]= ""+ cell.getNumericCellValue();                                           
                                  break;
                              }
                              i=i+1;
                      }
      my_csv_output.writeNext(csvdata);
      }
      my_csv_output.close(); //close the CSV file
      //we created our file..!!
      input_document.close(); //close xls
     
  }
  
  @Test(priority = 1)
  public void CSVtoXLSX() throws IOException {
	  /* Step -1 : Read input CSV file in Java */
      String inputCSVFile = Util.CSV_FILE_PATH;
      CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
      /* Variables to loop through the CSV File */
      String [] nextLine; /* for every line in the file */            
      int lnNum = 0; /* line number */
      /* Step -2 : Define POI Spreadsheet objects */          
      XSSFWorkbook new_workbook = new XSSFWorkbook(); //create a blank workbook object
      XSSFSheet sheet = new_workbook.createSheet("CSV2XLSX");  //create a worksheet with caption score_details
      /* Step -3: Define logical Map to consume CSV file data into excel */
      Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
      /* Step -4: Populate data into logical Map */
      while ((nextLine = reader.readNext()) != null) {
              lnNum++;                        
              excel_data.put(Integer.toString(lnNum), new Object[] {nextLine[0],nextLine[1]});                        
      }
      /* Step -5: Create Excel Data from the map using POI */
      Set<String> keyset = excel_data.keySet();
      int rownum = 0;
      for (String key : keyset) { //loop through the data and add them to the cell
              Row row = sheet.createRow(rownum++);
              Object [] objArr = excel_data.get(key);
              int cellnum = 0;
              for (Object obj : objArr) {
                      Cell cell = row.createCell(cellnum++);
                      if(obj instanceof Double)
                              cell.setCellValue((Double)obj);
                      else if(obj instanceof String)
                              cell.setCellValue((String)obj);
                      else if(obj instanceof Integer)
                    	  cell.setCellValue((Integer)obj);
                    	  
                      }
                    }
      /* Write XLS converted CSV file to the output file */
      FileOutputStream output_file = new FileOutputStream(new File(Util.XLSX_FILE_PATH)); //create XLSX file
      new_workbook.write(output_file);//write converted XLSX file to output stream
      output_file.close(); //close the file
}

@Test(priority = 3)
public void CSVtoExcel2() throws NumberFormatException, IOException {
	SXSSFSheet sheet = null;
	CSVReader reader = null;
	Workbook workBook = null;
	FileOutputStream fileOutputStream = null;
	
	String[] nextLine;
	reader = new CSVReader(new FileReader(Util.CSV_FILE_PATH), ',');
	workBook = new SXSSFWorkbook();
	sheet = (SXSSFSheet) workBook.createSheet("Sheet");
	
	int rowNum = 0;
	while((nextLine = reader.readNext()) != null) {
		                Row currentRow = sheet.createRow(rowNum++);
		                for(int i=0; i < nextLine.length; i++) {
		                    if(NumberUtils.isDigits(nextLine[i])) {
		                        currentRow.createCell(i).setCellValue(Integer.parseInt(nextLine[i]));
		                    } else if (NumberUtils.isNumber(nextLine[i])) {
		                        currentRow.createCell(i).setCellValue(Double.parseDouble(nextLine[i]));
		                    } else {
		                        currentRow.createCell(i).setCellValue(nextLine[i]);
		                    }
		                }
		}
	
	fileOutputStream = new FileOutputStream(Util.XLSX_FILE_PATH2);
	workBook.write(fileOutputStream);
	workBook.close();
	fileOutputStream.close();
	reader.close();


}
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
