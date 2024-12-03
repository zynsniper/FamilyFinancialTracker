package team14.fft;

import javafx.scene.layout.Region;
import javafx.util.Builder;

//Contributing Authors: O Darrah
public class TransactionListController {
	private Builder<Region> builder;
	
	//REMOVE TEST STATEMENTS LATER!!
	//Contributing Authors: O Darrah
	public TransactionListController(/*Statement statement*/) {
		Statement sTest = new Statement(01, "Olivia", "20241024");
		
		Category cTest1 = new Category("Groceries");
		Category cTest2 = new Category("Alcohol");
		Vendor vTest1  = new Vendor("WALMART SOUTH", cTest1);
		Vendor vTest2  = new Vendor("ALCOOL NB LIQUOR", cTest2);
		Buyer bTest1 = new Buyer ("Olivia");
		
		Transaction tTest1 = new Transaction("20241115", cTest1, vTest1, bTest1, 43.98);
		Transaction tTest2 = new Transaction("20241128", cTest2, vTest2, bTest1, 28.99);
		
		sTest.addTransactions(tTest1);
		sTest.addTransactions(tTest2);
		
		//change sTest to statement when removing tests
		this.builder = new TransactionListViewBuilder(this::nextPage, sTest);
	}
	
	//Contributing Authors: O Darrah
	public Region getView() {
		return builder.build();
	}
	
	//Contributing authors: R Legere, O Darrah
	public void nextPage() {
		Main.getMainLayout().setCenter(new CategoryListController().getView());
	}
}


