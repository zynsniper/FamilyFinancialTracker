package team14.fft;

import java.io.IOException;
import java.util.ArrayList;

//Contributing authors: R Legere
public class BackendTest {
	public static void main(String[] args) throws IOException{
		
		ArrayList<Transaction> transactions = InputProcessor.getTransactions("/Users/rileylegere/Downloads/2023-11.xlsx");
		for(int i=0; i<transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
		}
		
		ArrayList<Vendor> vendors = Vendor.getVendors();
		for(int i=0; i<vendors.size(); i++) {
			System.out.println(vendors.get(i).toString());
		}
		
		CategoryList list = new CategoryList();
		list.add(new Category("Grocery", 3));
		list.add(new Category("Restaurant", 3));
		list.add(new Category("Transport", 3));
		list.add(new Category("Recurring bills", 2));
		list.add(new Category("Other"));
		list.store();
		list = InputProcessor.loadCategories(ReadingExcel.readCategories("target/Category.xlsx"));
		for(int i=0; i<list.getList().size(); i++) {
			System.out.println(list.getList().get(i).toString());
		}
	}
}
