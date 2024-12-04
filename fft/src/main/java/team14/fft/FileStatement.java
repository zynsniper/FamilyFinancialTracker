package team14.fft;

import java.io.IOException;

public class FileStatement extends Statement{
	private String filePath;
	private TransactionListModel transcModel;
	private CategoryListModel catModel;
	
	public FileStatement(int statementID, String buyerName, String statementDate, String filePath) {
		super(statementID, buyerName, statementDate);
		this.filePath = filePath;
		loadExcelFile();
	}
	
	public FileStatement(int statementID, String buyerName, String statementDate, String filePath, TransactionListModel model) {
        super(statementID, buyerName, statementDate);
        this.filePath = filePath;
        this.transcModel = model;
        loadExcelFile();
    }
	
	public void loadExcelFile() {
		try{ReadingExcel reader = new ReadingExcel();
			String[][] data = reader.ReadingInput(filePath);
			String buyerNameFromUI = transcModel.buyerStr().getValue();
			String categoryNameFromUI = catModel.catStr().getValue();
			Category category = new Category(categoryNameFromUI);
			
			for(String[] row: data) {
				String date = row[0];
                String vendorName = row[1];
                double debit = Double.parseDouble(row[2]);
                double credit = Double.parseDouble(row[3]);
                double total = Double.parseDouble(row[4]);
                
                Vendor vendor = new Vendor(vendorName, category); 
                Buyer buyer = new Buyer(buyerNameFromUI); 
                
                Transaction transaction = new Transaction(category, vendor, buyer, total);
                addTransactions(transaction);
			}
			
		} catch (IOException e) {
			System.out.println("Error reading the Excel file");
		}
	}
}
