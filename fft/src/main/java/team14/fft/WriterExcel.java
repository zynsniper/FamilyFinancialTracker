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
	
	public void WriteTransactions(ArrayList<Transaction> transactions)  throws Exception {
		Row header = sheet.createRow(0);
		Cell cell1 = header.createCell(0); cell1.setCellValue("Date");
		Cell cell2 = header.createCell(1); cell2.setCellValue("Category");
		Cell cell3 = header.createCell(2); cell3.setCellValue("Vendor");
		Cell cell4 = header.createCell(3); cell4.setCellValue("Buyer");
		Cell cell5 = header.createCell(4); cell5.setCellValue("Total");
		Cell cell6 = header.createCell(5); cell6.setCellValue("DR/CR");
		int rowNum = 1;
		for(Transaction transaction : transactions) {
			Row row = sheet.createRow(rowNum++);
			
			int cellNum = 0;
			for (String value : transaction.toList()) {
				Cell cell = row.createCell(cellNum++);
				cell.setCellValue(value);
				sheet.autoSizeColumn(cellNum);
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
	
	//Contributing authors: R Legere
	public void WriteCatTotals(ArrayList<Transaction> transactions, ArrayList<Category> list) throws IOException {
		Row header = sheet.createRow(sheet.getLastRowNum());
		Cell hCell1 = header.createCell(0); hCell1.setCellValue("Category");
		Cell hCell2 = header.createCell(1); hCell2.setCellValue("Total");
		for(int i=0; i<list.size(); i++) {
			double total = 0;
			for(int j=0; j<transactions.size(); j++) {
				if(transactions.get(j).getCat() == list.get(i)) {
					total+= transactions.get(j).getTotal();
				}
			}
			Row row = sheet.createRow(sheet.getLastRowNum());
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(list.get(i).toString());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(total);
		}
		FileOutputStream fos = new FileOutputStream(filePath.toString());
		workbook.write(fos);
	}
	
	//Contributing authors: R Legere
	public void writeTotal(ArrayList<Transaction> transactions) throws IOException {
		double total = Calculator.calcBalChange(transactions);
		Row row = sheet.createRow(sheet.getLastRowNum());
		Cell cell1 = row.createCell(0); cell1.setCellValue("Total:");
		Cell cell2 = row.createCell(1); cell2.setCellValue(total);
		FileOutputStream fos = new FileOutputStream(filePath.toString());
		workbook.write(fos);
	}

}
