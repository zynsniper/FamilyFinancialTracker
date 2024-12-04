package team14.fft;

public class InputProcessor {
	//Contributing authors: CS Cheang
	public String date;
    public void processData(String[][] data) {
    	date = data[0][0];
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
            }
        }
    }
    
}
