package team14.fft;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriterExcel {
	
	private String fileName;
	private Path filePath;
	private Workbook workbook = new XSSFWorkbook();
	private Sheet sheet;
	
	public WriterExcel(String fileName) {
		this.fileName = fileName;
		filePath = Paths.get(fileName);
		sheet = workbook.createSheet();
	}
	
	public void WriteTranactions(ArrayList<Transaction> transactionList) throws Exception {
		
		int rowNum = 0;
		for(Transaction transaction : transactionList) {
			Row row = sheet.createRow(rowNum++);
			
			int cellNum = 0;
			for (String value : transaction.toList()) {
				Cell cell = row.createCell(cellNum++);
				cell.setCellValue(value);
			}
		}
		
		FileOutputStream fos = new FileOutputStream(filePath.toString());
		workbook.write(fos);
	}
	
	public void WriteCategory(ArrayList<Category> categoryList) throws IOException {
		int rowNum = 0;
		for (Category category : categoryList) {
			Row row = sheet.createRow(rowNum++);
			Cell cell = row.createCell(0);
			Cell catCell = row.createCell(1);
			cell.setCellValue(category.toString());
			catCell.setCellValue(category.getX());
		}
		FileOutputStream fos = new FileOutputStream(filePath.toString());
		workbook.write(fos);
		
	}
	
	public void WriteBuyer(ArrayList<Buyer> buyerList) throws IOException {
		int rowNum = 0;
		for (Buyer buyer : buyerList) {
			Row row = sheet.createRow(rowNum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(buyer.toString());
		}
		FileOutputStream fos = new FileOutputStream(filePath.toString());
		workbook.write(fos);
		
	}


}
