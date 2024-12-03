package team14.fft;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class CategoryListController {
	private Builder<Region> build;
	
	//Contributing authors: R Legere
	public CategoryListController() {
		build = new CategoryListViewBuilder();
	}
	
	//Contributing authors: R Legere
	public Region getView() {
		return build.build();
	}
	
}
