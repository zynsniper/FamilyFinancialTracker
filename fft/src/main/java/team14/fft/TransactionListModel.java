package team14.fft;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class TransactionListModel {
	private SimpleStringProperty buyerStr;
	private ObservableList<Buyer> buyers;
	
	//Contributing authors: R Legere
	public TransactionListModel() {
		buyerStr = new SimpleStringProperty();
		buyers = FXCollections.observableArrayList();
		

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
}
