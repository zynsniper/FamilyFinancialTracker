package team14.fft;
public class Transaction {
    private Category category;
    private Vendor vendor;
    private Buyer buyer;
    private double total;
    private boolean debit;

    //Contributing authors: R Legere
    public Transaction(Category catIn, Vendor venIn, Buyer buyerIn, double totalIn){
        vendor = venIn;
        category = catIn;
        buyer = buyerIn;
        total = totalIn;
        if(total < 0){debit = true;}else{debit = false;}
    }
    //Contributing authors: CS Cheang
    public double getTotal(){
        return total;
    }

    //Contributing authors: R Legere
    public Transaction(Vendor venIn, double totalIn){
        vendor = venIn;
        category = vendor.getCat();
        total = totalIn;
        if(total > 0){debit = true;}else{debit = false;}
    }

    //Contributing authors: R Legere
    public void changeCategory(Category newCat){
        category = newCat;
    }
    //Contributing authors: R Legere
    public int calcRewardPt(){
        return (int)(total*category.getX());
    }

    //Contributing authors: R Legere
    public boolean isDebit(){
        return debit;
    }
}
