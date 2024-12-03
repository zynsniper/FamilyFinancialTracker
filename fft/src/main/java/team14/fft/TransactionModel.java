package team14.fft;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TransactionModel {
	private SimpleStringProperty date;
    private SimpleStringProperty category;
    private SimpleStringProperty vendor;
    private SimpleStringProperty buyer;
    private SimpleDoubleProperty total;
    // decide if this is needed later private boolean debit;

    //Contributing authors: O Darrah
    public TransactionModel(Transaction transaction){
        vendor = new SimpleStringProperty(transaction.getVen().getVendor());
        category = new SimpleStringProperty(transaction.getCat().toString());
        buyer = new SimpleStringProperty(transaction.getBuyer().getBuyerName());
        total = new SimpleDoubleProperty(transaction.getTotal());
    }
    
    //Contributing authors: O Darrah
    public SimpleDoubleProperty getTotalProperty(){
        return total;
    }
    
    //Contributing authors: O Darrah
    public SimpleStringProperty getDateProperty(){
        return date;
    }
    
    //Contributing authors: O Darrah
    public SimpleStringProperty getBuyerNameProperty(){
        return buyer;
    }
    
    //Contributing authors: O Darrah
    public SimpleStringProperty getVendorNameProperty(){
        return vendor;
    }

    //Contributing authors: O Darrah
    public SimpleStringProperty getCategoryProperty(){
        return category;
    }
}
