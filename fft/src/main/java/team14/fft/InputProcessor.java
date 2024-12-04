package team14.fft;

import java.io.IOException;
import java.util.ArrayList;

public class InputProcessor {
	//Contributing authors: CS Cheang
	private static ArrayList<Transaction> transactions;
    public static void processData(String[][] data) throws IOException {
        for (String[] row : data) {
            if (row == null) continue;

            String date = row[0];
            String vendor = row[1];
            String credit = row[2];
            String debit = row[3];
            String balance = row[4];
            double total;
            if(credit != null) {
            	total = Integer.parseInt(credit);
            }
            else {
            	total = Integer.parseInt(debit);
            	total *= -1;
            }
            double bal = Integer.parseInt(balance);
            Vendor ven = Vendor.addVendor(vendor);
            
            
            System.out.printf("%-30s %-28s %-8s %-8s %-10s %n", date, vendor, debit, credit, balance);
            if(row[2] == null) {
            	Transaction transaction = new Transaction(row[0], ven, total);
            	transactions.add(transaction);
            }
        }
    }
    
    public static ArrayList<Transaction> getTransactions(String fileName) throws IOException{
    	processData(ReadingExcel.ReadingInput(fileName));
    	return transactions;
    }
    
}
