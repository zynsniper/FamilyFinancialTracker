package team14.fft;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.layout.Region;
import javafx.util.Builder;

//Contributing Authors: O Darrah, CS Cheang
public class TransactionListController {
	private Builder<Region> builder;
	
	//REMOVE TEST STATEMENTS LATER!!
	//Contributing Authors: O Darrah
	public TransactionListController(/*Statement statement*/) {
		/*Statement sTest = new Statement(01, "Olivia", "20241024");
		
		Category cTest1 = new Category("Groceries");
		Category cTest2 = new Category("Alcohol");
		Vendor vTest1  = new Vendor("WALMART SOUTH", cTest1);
		Vendor vTest2  = new Vendor("ALCOOL NB LIQUOR", cTest2);
		Buyer bTest1 = new Buyer ("Olivia");*/
		String excelFilePath = "G:\\UNB\\Fall2024\\CS2043\\2023-11.xlsx";
		Statement statement = new Statement(1, "Olivia", "20241024");
		try {
            ReadingExcel excelReader = new ReadingExcel();
            ArrayList<Transaction> transactions = excelReader.TransactionReader(excelFilePath);

            for (Transaction transaction : transactions) {
                statement.addTransactions(transaction);
            }

            this.builder = new TransactionListViewBuilder(this::nextPage, statement);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading Excel file: " + excelFilePath);
        }
		//change sTest to statement when removing tests
		this.builder = new TransactionListViewBuilder(this::nextPage, statement);
	}
	
	//Contributing Authors: O Darrah
	public Region getView() {
		return builder.build();
	}
	
	//Contributing authors: R Legere, O Darrah
	public void nextPage() {
		Main.getMainLayout().setCenter(new CategoryListController().getView());
	}
}


