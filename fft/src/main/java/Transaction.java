package fft.src.main.java;

public class Transaction {
    private Category category;
    private Vendor vendor;
    private double total;
    private boolean debit;

    public Transaction(Category catIn, Vendor venIn, double totalIn){
        vendor = venIn;
        category = catIn;
        total = totalIn;
        if(total > 0){debit = true;}else{debit = false;}
    }

    public Transaction(Vendor venIn, double totalIn){
        vendor = venIn;
        category = vendor.getCat();
        total = totalIn;
        if(total > 0){debit = true;}else{debit = false;}
    }

    public void changeCategory(Category newCat){
        category = newCat;
    }

    public int calcRewardPt(){
        return (int)(total*category.getX());
    }

    public boolean isDebit(){
        return debit;
    }
}
