package team14.fft;
import java.io.IOException;
import java.util.ArrayList;

public class BuyerList {
	//Contributing Authors: W Elliott
	
	private String filepath;
	private ArrayList<Buyer> buyerList;
	private Buyer currentBuyer;
	private ReadingExcel reader = new ReadingExcel();
	
	public BuyerList() throws IOException {
		String []storedBuyers = reader.ReadingInput(filepath)[0]; 
		
		for (String nameIn : storedBuyers) {
			buyerList.add(new Buyer(nameIn));
		}
	}
	
	public void store() {
		//stores buyerList into an EXCEL file to be opened later 
	}
	
	public void setCurBuyer(String name) {
		for(Buyer buyer: buyerList) {
			if(buyer.getBuyerName().equals(name)) {
				currentBuyer = buyer;
				break;
			}
		}
	}
	
	public Buyer getCurBuyer() {
		return currentBuyer;
	}
	
	public void add(String nameIn) {
		buyerList.add(new Buyer(nameIn));
	}

}
