package team14.fft;
import java.util.ArrayList;

public class Transaction {
	private String date;
    private Category category;
    private Vendor vendor;
    private Buyer buyer;
    private double total;
    private boolean debit;

    //Contributing authors: R Legere, W Elliott, CS Cheang
    public Transaction(String date, Vendor vendor, Buyer buyer, double totalIn){
    	this.date = date;
        this.vendor = vendor;
        this.buyer = buyer;
        total = totalIn;
        if(total < 0){debit = true;}else{debit = false;}
    }

    //Contributing authors: R Legere
    public Transaction(Vendor venIn, double totalIn){
        vendor = venIn;
        category = vendor.getCat();
        total = totalIn;
        if(total > 0){debit = true;}else{debit = false;}
    }
    
    //Contributing authors: CS Cheang
    public double getTotal(){
        return total;
    }

    //Contributing authors: R Legere
    public void changeCategory(Category newCat){
        category = newCat;
    }
    
    //Contributing authors: R Legere
    public Category getCat() {
    	return category;
    }
    
    public Buyer getBuyer() {
    	return buyer;
    }
    
    public Vendor getVendor() {
    	return vendor;
    }
    
    public String getDate() {
    	return date;
    }
    
    //Contributing authors: R Legere
    public int calcRewardPt(){
        return (int)(total*category.getX());
    }

    //Contributing authors: R Legere
    public boolean isDebit(){
        return debit;
    }
    
    //Contributing authors: R Legere
    public void setBuyer(Buyer buyer) {
    	this.buyer = buyer;
    	buyer.incrementTransaction();
    }
	//Contributing authors: W Elliott
    public void setCategory(Category category) {
    	this.category = category;
    }
    
    public String toString() {
    	return date + ": " + vendor + "_- $" + total;
    }
    
    public ArrayList<String> toList() {
    	ArrayList<String> output = new ArrayList<String>();
    	output.add(date);
    	try{output.add(category.toString());
    	}catch(NullPointerException e) {output.add("Undefined category");}
    	output.add(vendor.toString());
    	try{output.add(buyer.toString());
		}catch(NullPointerException e) {output.add("Undefined buyer");}
    	output.add(String.valueOf(total));
    	if(debit) {output.add("Debit");}
    	else {output.add("Credit");}
    	
    	return output;
    }
}
