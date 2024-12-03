package team14.fft;

public class InputProcessor {
	//Contributing authors: CS Cheang
    public void processData(String[][] data) {
        for (String[] row : data) {
            if (row == null) continue;

            String date = row[0];
            String vendor = row[1];
            String debit = row[2];
            String credit = row[3];
            String balance = row[4];
            
            System.out.printf("%-30s %-28s %-8s %-8s %-10s %n", date, vendor, debit, credit, balance);
        }
    }
}
