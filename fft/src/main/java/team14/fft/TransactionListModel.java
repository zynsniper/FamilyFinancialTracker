package team14.fft;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class TransactionListModel {
	private SimpleStringProperty buyerStr;
	private ArrayList<Buyer> buyers;
	
	//Contributing authors: R Legere
	public TransactionListModel() {
		buyerStr = new SimpleStringProperty();
		buyers = new ArrayList<Buyer>();

	}
	//Contributing authors: R Legere
	public SimpleStringProperty buyerStr() {
		return buyerStr;
	}
	
	
	//Contributing authors: R Legere
	public void addBuyer() {
		Buyer buyer = new Buyer(buyerStr.getValue());
	}
}
