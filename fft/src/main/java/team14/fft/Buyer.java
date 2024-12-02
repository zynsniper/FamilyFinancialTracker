package team14.fft;

import java.util.ArrayList;
public class Buyer {
    private String buyerName;
    private int numTransactions;
    private static ArrayList<Buyer> buyers = new ArrayList<>();

    //Contributing authors: R Legere
    public Buyer(String nameIn){
        buyerName = nameIn;
        numTransactions = 0;
        buyers.add(this);
    }
    //Contributing authors: R Legere
    public String toString(){
        return buyerName;
    }
    //Contributing authors: R Legere
    public void incrementTransaction(){
        numTransactions++;
    }
    //Contributing authors: R Legere
    public int getNumTransactions(){
        return numTransactions;
    }

    //Contributing authors: CS Cheang
    public static ArrayList<Buyer> getAllBuyers() {
        return buyers;
    }
    
}
