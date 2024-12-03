package team14.fft;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransactionListModel {
	private SimpleStringProperty buyerStr;
	private ObservableList<Buyer> buyers;
	private ObservableList<TransactionModel> observableTransactionModelList;
	
	//Contributing authors: R Legere, O Darrah
	public TransactionListModel(Statement transactions) {
		buyerStr = new SimpleStringProperty();
		buyers = FXCollections.observableArrayList();
		observableTransactionModelList = FXCollections.observableArrayList();
		for(Transaction transaction: transactions.getTransactions()){
			TransactionModel temp = new TransactionModel(transaction);
			observableTransactionModelList.add(temp);
		}
	}
	
	//Contributing authors: R Legere
	public SimpleStringProperty buyerStr() {
		return buyerStr;
	}
	
	
	//Contributing authors: R Legere
	public void addBuyer() {
		Buyer buyer = new Buyer(buyerStr.getValue());
		buyers.add(buyer);
		
	}
	
	//Contributing authors: R Legere
	public ObservableList<Buyer> getList(){
		return buyers;
	}
	
	//Contributing authors: O Darrah
	public ObservableList<TransactionModel> getObservableTransactionModels(){
		return observableTransactionModelList;
	}
}
