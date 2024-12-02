package team14.fft;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ReadingExcel{
	//Contributing authors: CS Cheang
    public String[][] ReadingInput(String yourFilePath) throws IOException{
    	
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
}
