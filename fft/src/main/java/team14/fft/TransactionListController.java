package team14.fft;

import javafx.scene.layout.Region;
import javafx.util.Builder;

//Contributing Authors: O Darrah
public class TransactionListController {
	private Builder<Region> builder;
	
	//Contributing Authors: O Darrah
	public TransactionListController() {
		this.builder = new TransactionListViewBuilder();
	}
	
	//Contributing Authors: O Darrah
	public Region getView() {
		return builder.build();
	}
}

