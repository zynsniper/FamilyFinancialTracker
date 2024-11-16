package fft.src.main.java;

import java.util.ArrayList;
public class Buyer {
    private String buyerName;
    private int numTransactions;
    private ArrayList<Buyer> buyers;

    public Buyer(String nameIn){
        buyerName = nameIn;
        numTransactions = 0;
        buyers.add(this);
    }

    public String getName(){
        return buyerName;
    }

    public void incrementTransaction(){
        numTransactions++;
    }

    public int getNumTransactions(){
        return numTransactions;
    }


}
