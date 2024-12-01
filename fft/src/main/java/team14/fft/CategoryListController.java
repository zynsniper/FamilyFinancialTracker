package team14.fft;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class CategoryListController {
	private Builder<Region> build;
	
	public CategoryListController() {
		build = new CategoryListViewBuilder();
	}
	
	public Region getView() {
		return build.build();
	}
	
}
