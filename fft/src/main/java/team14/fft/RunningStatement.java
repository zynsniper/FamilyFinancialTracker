package team14.fft;

public class RunningStatement extends Statement{
	//Contributing author: CS Cheang
	public RunningStatement(int statementID, String buyerName, String statementDate) {
        super(statementID, buyerName, statementDate);
    }
	
	//Contributing author: CS Cheang
    public void addTransaction(Transaction transaction) {
        addTransactions(transaction);
        calculateTotalSpent();
        calculateTotalRewardPoints();
    }
}
