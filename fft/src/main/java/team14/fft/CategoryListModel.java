package team14.fft;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryListModel {
	private SimpleStringProperty catStr;
	private ObservableList<Category> cats;
	private CategoryList list;
	private ObservableList<TransactionModel> transactions;
	
	//Contributing authors: R Legere
	public CategoryListModel(ObservableList<TransactionModel> transactions) {
		this.transactions = transactions;
		list = new CategoryList();
		catStr = new SimpleStringProperty();
		cats = FXCollections.observableArrayList();
		cats.addAll(list.getList());
	}
	
	//Contributing authors: R Legere
	public SimpleStringProperty catStr() {
		return catStr;
	}
	
	public ObservableList<TransactionModel> getTransactions(){
		return transactions;
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
	
	public void addCats(String category) {
		for(int i=0; i<getTransactions().size(); i++) {
			if(getTransactions().get(i).getSelect().isSelected()) {
					getTransactions().get(i).setCat(category);
					getTransactions().get(i).getSelect().setSelected(false);
			}
	}
	}
}
