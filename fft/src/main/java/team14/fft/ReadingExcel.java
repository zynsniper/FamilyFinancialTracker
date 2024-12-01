package team14.fft;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.CellType;

public class ReadingExcel{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String excelFilePath = "/Users/rileylegere/Downloads/2023-11.xlsx";
        //Contributing authors: CS Cheang
        try(FileInputStream inputStream = new FileInputStream(excelFilePath);
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream)){;
            
            XSSFSheet sheet = workBook.getSheetAt(0);

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(1).getLastCellNum();
        
            for(int r = 0; r <= rows ; r++){
                XSSFRow row = sheet.getRow(r);


                XSSFCell cell = row.getCell(0);
                
                String date = row.getCell(0).getDateCellValue().toString();
                String vendor = row.getCell(1).getStringCellValue();

                double debit = 0.0;
                XSSFCell debitCell = row.getCell(2);
                if (debitCell != null && debitCell.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
                    debit = debitCell.getNumericCellValue();
                }

                double credit = 0.0;
                XSSFCell creditCell = row.getCell(3);
                if (creditCell != null && creditCell.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
                    credit = creditCell.getNumericCellValue();
                }

                double balance = row.getCell(4).getNumericCellValue();

                System.out.println(String.format("Date: %s, Vendor: %s, Debit: %.2f, Credit: %.2f, Balance: %.2f%n", date, vendor, debit, credit, balance));
                
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
