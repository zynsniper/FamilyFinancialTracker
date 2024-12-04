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


