import java.util.ArrayList;

public class Statement {
    private int statementID;
    private String buyerName;
    private String statementDate;
    private ArrayList<Transaction> transactions;
    private double totalSpent;
    private int totalRewardPoints;
    
    public Statement(int statementID, String buyerName, String statementDate) {
        this.statementID = statementID;
        this.buyerName = buyerName;
        this.statementDate = statementDate;
        this.transactions = new ArrayList<>();
    }
    
    public int getStatementID() {
    	return statementID;
    }
    
    public String getStatementDate() {
    	return statementDate;
    }

    public void calculateTotalSpent() {
        totalSpent = 0;
        for (Transaction a : transactions) {
            totalSpent += a.isDebit() ? a.getTotal() : 0; 
        }
    }

    public void calculateTotalRewardPoints() {
        totalRewardPoints = 0;
        for (Transaction a : transactions) {
            totalRewardPoints += a.calcRewardPt();
        }
    }
    
    public void addTransactions(Transaction toBeAdded) {
    	transactions.add(toBeAdded);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }
    
    public String generateSummary() {
        return "Statement ID: " + statementID + "\n" +
               "Statement Date: " + statementDate + "\n" +
               "Buyer Name: " + buyerName + "\n" +
               "Total Spent: " + totalSpent + "\n" +
               "Total Reward Points: " + totalRewardPoints + "\n" +
               "Number of Transactions: " + transactions.size();
    }
    
}
