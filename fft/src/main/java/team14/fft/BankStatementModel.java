package team14.fft;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//Contributing Authors: O Darrah, W Elliott, D MacIssac
public class BankStatementModel {
	private final StringProperty bankStatementProperty;
	ObservableList<Transaction> list;
	
	public BankStatementModel() {
		bankStatementProperty = new SimpleStringProperty();
		list = FXCollections.observableArrayList();
	}
	
	public void setBankStatement(String filename) {
		bankStatementProperty.set(filename);
	}

	public StringProperty bankStatementProperty() {
		return bankStatementProperty;
	}
	
	public String getBankStatement() {
		return bankStatementProperty.get();
	}
}