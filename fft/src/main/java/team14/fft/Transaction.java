package team14.fft;

public class Transaction {
	private String date;
    private Category category;
    private Vendor vendor;
    private Buyer buyer;
    private double total;
    private boolean debit;

    //Contributing authors: R Legere
<<<<<<< HEAD
    public Transaction(Category catIn, Vendor venIn, Buyer buyerIn, double totalIn){
=======
    public Transaction(String dateIn, Category catIn, Vendor venIn, double totalIn){
    	date = dateIn;
>>>>>>> 333ab8b6ecbdeb1ebd58eed03f6af1f073b9f13c
        vendor = venIn;
        category = catIn;
        buyer = buyerIn;
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
    
    public String toString() {
    	return date + ": " + vendor + "_- $" + total;
    }
}
