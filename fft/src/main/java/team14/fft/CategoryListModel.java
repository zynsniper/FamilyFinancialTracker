package team14.fft;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryListModel {
	private SimpleStringProperty catStr;
	private ObservableList<Category> cats;
	
	//Contributing authors: R Legere
	public CategoryListModel() {
		catStr = new SimpleStringProperty();
		cats = FXCollections.observableArrayList();
	}
	
	//Contributing authors: R Legere
	public SimpleStringProperty catStr() {
		return catStr;
	}
	
	
	//Contributing authors: R Legere
	public void addCat() {
		Category cat = new Category(catStr.getValue());
		cats.add(cat);
		
	}
	
	//Contributing authors: R Legere
	public ObservableList<Category> getList(){
		return cats;
	}
	
	public void assignCategories(String category, )
}
