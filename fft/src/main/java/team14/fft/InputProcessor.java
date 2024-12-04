package team14.fft;

import java.io.IOException;
import java.util.ArrayList;


public class InputProcessor {
	//Contributing authors: CS Cheang, R Legere
	private static ArrayList<Transaction> transactions;
    public static void processData(String[][] data) throws IOException {
    	transactions = new ArrayList<Transaction>();
        for (String[] row : data) {
            if (row == null) continue;

            String date = row[0];
            String vendor = row[1];
            String credit = row[2];
            String debit = row[3];
            String balance = row[4];
            double total;
            if(credit != null) {
            	total = Double.parseDouble(credit);
            }
            else {
            	total = Double.parseDouble(debit);
            	total *= -1;
            }
            double bal = Double.parseDouble(balance);
            Vendor ven = Vendor.addVendor(vendor);
            
            
            Transaction transaction = new Transaction(row[0], ven, total);
            transactions.add(transaction);
            }
        }
    
    //Contributing authors: R Legere
    public static ArrayList<Transaction> getTransactions(String fileName) throws IOException{
    	processData(ReadingExcel.ReadingInput(fileName));
    	return transactions;
    }
    
    public static CategoryList loadCategories(String[][] arr) throws IOException {
    	CategoryList catList = new CategoryList();
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i][1] != null) {
    			Category cat = new Category(arr[i][0], Integer.parseInt(arr[i][1]));
    			catList.add(cat);
    		}
    		else {
    			Category cat = new Category(arr[i][0]);
    			catList.add(cat);
    		}
    	}
    	return catList;
    }
    
}
