package team14.fft;

import javafx.collections.ObservableList;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class CategoryListController {
	private Builder<Region> build;
	
	//Contributing authors: R Legere
	public CategoryListController(ObservableList<TransactionModel> observableList) {
		build = new CategoryListViewBuilder(observableList);
	}
	
	//Contributing authors: R Legere
	public Region getView() {
		return build.build();
	}

	public void assignCategories() {
		
	}
}
