package team14.fft;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//Contributing Authors: O Darrah, W Elliott, D MacIssac
public class BankStatementModel {
	private final StringProperty bankStatementProperty;
	
	public BankStatementModel() {
		bankStatementProperty = new SimpleStringProperty();
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