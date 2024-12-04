package team14.fft;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.layout.Region;

//Contributing Authors: O Darrah, CS Cheang
public class TransactionListController {
	private TransactionListViewBuilder builder;
	
	//Contributing Authors: O Darrah, CS Cheang
	public TransactionListController(String filePath) {
		
		String excelFilePath = filePath;
		Statement statement = new Statement(1000, "Statement1", "20241024");
		try {
            ReadingExcel excelReader = new ReadingExcel();
            ArrayList<Transaction> transactions = excelReader.TransactionReader(excelFilePath);

            for (Transaction transaction : transactions) {
                statement.addTransactions(transaction);
            }

            this.builder = new TransactionListViewBuilder(this::nextPage, statement);
        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + excelFilePath);
        }

		this.builder = new TransactionListViewBuilder(this::nextPage, statement);
	}
	
	//Contributing Authors: O Darrah
	public Region getView() {
		return builder.build();
	}
	
	//Contributing authors: R Legere, O Darrah
	public void nextPage() {
		Main.getMainLayout().setCenter(new CategoryListController(builder.model.getObservableTransactionModels()).getView());
	}
}


