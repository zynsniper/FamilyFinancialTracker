package team14.fft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ReadingExcel{
	//Contributing authors: CS Cheang
	public ReadingExcel() {}

    public static String[][] ReadingInput(String yourFilePath) throws IOException{
    	
	    try(FileInputStream inputStream = new FileInputStream(yourFilePath);
	        XSSFWorkbook workBook = new XSSFWorkbook(inputStream)){;
	        
	        XSSFSheet sheet = workBook.getSheetAt(0);
	
	        int rows = sheet.getPhysicalNumberOfRows();
	        String[][] arr = new String[rows][5];
	    
	        for(int r = 0; r <= rows ; r++){
	            XSSFRow row = sheet.getRow(r);
	            if (row == null) continue;
	
	            arr[r][0] = row.getCell(0).getDateCellValue().toString();
	            arr[r][1] = row.getCell(1).getStringCellValue();
	
	            XSSFCell debitCell = row.getCell(2);
	            if (debitCell != null) {
	                arr[r][2] = String.valueOf(debitCell.getNumericCellValue());
	            }
	
	            XSSFCell creditCell = row.getCell(3);
	            if (creditCell != null) {
	                arr[r][3] = String.valueOf(creditCell.getNumericCellValue());
	            }
	
	            arr[r][4] = String.valueOf(row.getCell(4).getNumericCellValue());
	            
	        }
	        
	        return arr;
	    }
    }
    
    
  //Contributing authors: R Legere
    public static String[][] readCategories(String filePath) throws IOException {
    	String[][] arr;
    	FileInputStream stream = new FileInputStream(filePath);
    	XSSFWorkbook book = new XSSFWorkbook(stream);
    	XSSFSheet sheet = book.getSheetAt(0);
    	int rows = sheet.getLastRowNum();
    	arr = new String[rows][2];
    	for(int i=0; i<rows; i++) {
    		XSSFRow row = sheet.getRow(i);
    			arr[i][0] = row.getCell(0).getStringCellValue();
    			int multiplier = (int)row.getCell(1).getNumericCellValue();
    			String s = "" + multiplier;
    			arr[i][1] = s;
    	}
    	return arr;
    }
    

    	
    
    
  //Contributing authors: W Elliott, O Darrah

    public ArrayList<Transaction> TransactionReader(String filePath) throws IOException {

        String fileName = "target/transactionList.XLSX";
        //Path filePath = Paths.get(fileName);
        ArrayList<Transaction> output = new ArrayList<Transaction>();

        try(FileInputStream inputStream = new FileInputStream(filePath.toString());
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream)){;
            XSSFSheet sheet = workBook.getSheetAt(0);


            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            for(Row row: sheet) {
                Cell dateCell = row.getCell(0);
                Cell debitCell = row.getCell(2);
                Cell creditCell = row.getCell(3);
                double amount = 0.0;

                //Contributing authors: CS Cheang, R Legere
                String formattedDate = dateFormat.format(dateCell.getDateCellValue());
                String vendorName = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "Unknown Vendor";
                String buyerName = "Unassigned Buyer";
                if (debitCell != null) {
                    amount = debitCell.getNumericCellValue();
                } else {
                    amount = creditCell.getNumericCellValue() * -1;
                }

                output.add(new Transaction(formattedDate, new Vendor(vendorName), new Buyer(buyerName), amount));
            }
        }
        return output;
    }
	
}
