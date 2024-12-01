package team14.fft;
import java.util.ArrayList;

public class Statement {
    private int statementID;
    private String buyerName;
    private String statementDate;
    private ArrayList<Transaction> transactions;
    private double totalSpent;
    private int totalRewardPoints;
    
    //Contributing authors: CS Cheang
    public Statement(int statementID, String buyerName, String statementDate) {
        this.statementID = statementID;
        this.buyerName = buyerName;
        this.statementDate = statementDate;
        this.transactions = new ArrayList<>();
    }
    
    //Contributing authors: CS Cheang
    public int getStatementID() {
    	return statementID;
    }
    
    //Contributing authors: CS Cheang
    public String getStatementDate() {
    	return statementDate;
    }
    
    //Contributing authors: CS Cheang
    public void calculateTotalSpent() {
        totalSpent = 0;
        for (Transaction a : transactions) {
            totalSpent += a.isDebit() ? a.getTotal() : 0; 
        }
    }
    
    //Contributing authors: CS Cheang
    public void calculateTotalRewardPoints() {
        totalRewardPoints = 0;
        for (Transaction a : transactions) {
            totalRewardPoints += a.calcRewardPt();
        }
    }
    
    //Contributing authors: CS Cheang
    public void addTransactions(Transaction toBeAdded) {
    	transactions.add(toBeAdded);
    }
    
    //Contributing authors: CS Cheang
    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }
    
    //Contributing authors: CS Cheang
    public String generateSummary() {
        return "Statement ID: " + statementID + "\n" +
               "Statement Date: " + statementDate + "\n" +
               "Buyer Name: " + buyerName + "\n" +
               "Total Spent: " + totalSpent + "\n" +
               "Total Reward Points: " + totalRewardPoints + "\n" +
               "Number of Transactions: " + transactions.size();
    }
    
}
