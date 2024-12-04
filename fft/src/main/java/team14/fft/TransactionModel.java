package team14.fft;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class TransactionModel {
	private StringProperty date;
    private StringProperty category;
    private StringProperty vendor;
    private StringProperty buyer;
    private DoubleProperty total;
    private CheckBox select;

    //Contributing authors: O Darrah
    public TransactionModel(Transaction transaction){
    	date = new SimpleStringProperty(transaction.getDate());
        vendor = new SimpleStringProperty(transaction.getVendor().toString());
        //category = new SimpleStringProperty(transaction.getCat().toString());
        buyer = new SimpleStringProperty(transaction.getBuyer().toString());
        total = new SimpleDoubleProperty(transaction.getTotal());
        select = new CheckBox();
    }
    
    
    //Contributing authors: O Darrah
    public double getTotal(){
        return total.get();
    }
    
    //Contributing authors: O Darrah
    public String getDate(){
        return date.get();
    }
    
    //Contributing authors: O Darrah
    public String getBuyer(){
        return buyer.get();
    }
    
    //Contributing authors: O Darrah
    public String getVendor(){
        return vendor.get();
    }

    //Contributing authors: O Darrah
    public String getCategoryy(){
        return category.get();
    }
    
    //Contributing authors: O Darrah
    public CheckBox getSelect(){
        return select;
    }
    
    public void setBuyer(String buyer) {
    	this.buyer.set(buyer);
    }
    
}
