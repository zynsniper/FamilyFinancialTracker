package team14.fft;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class CategoryListViewBuilder implements Builder<Region>{
	private CategoryListModel model;
	
	public CategoryListViewBuilder() {
		model = new CategoryListModel();
	}
	//Contributing authors: R Legere
	public Region build() {
		VBox build = new VBox(labs(), catFormat(), noCatList(), buttons());
		build.setPrefHeight(300);
		build.setPrefWidth(200);
		return build;
	}
	
	//Contributing authors: R Legere
	private Node title() {
		Label lab = new Label("Unassigned categories\n");
		return lab;
	}
	
	//Contributing authors: R Legere
	private Node instructions() {
		Label lab = new Label("Select a category from the drop-down menu, and check all transactions");
		return lab;
	}
	
	//Contributing authors: R Legere
	private Node labs() {
		VBox labs = new VBox(title(), instructions());
		labs.setSpacing(10);
		return labs;
	}
	
	//Contributing authors: R Legere
	private Node catBox() {
		ChoiceBox<Category> cats = new ChoiceBox<>();
		Category test = new Category("Test category");
		cats.setItems(model.getList());
		return cats;
	}
	
	//Contributing authors: R Legere
	private Node catText() {
		TextField addCat = new TextField();
		addCat.setPrefWidth(100);
		addCat.textProperty().bindBidirectional(model.catStr());
		return addCat;
	}
	
	//Contributing authors: R Legere
	private Node catButton() {
		Button addCat = new Button("Add");
		addCat.setOnAction(e -> model.addCat());
		return addCat;
	}
	
	//Contributing authors: R Legere
	private Node noCatList() {
		VBox toReturn = new VBox();
				CheckBox box = new CheckBox("Example transaction");
				//box.setOnAction()
				toReturn.getChildren().add(box);
		return toReturn;
	}
	
	//Contributing authors: R Legere
	private Node nextButton() {
		Button next = new Button("Continue");
		next.setPrefWidth(100);
		//next.setOnAction();
		return next;
	}
	
	//Contributing authors: R Legere
	private Node assignButton() {
		Button assign = new Button("Assign");
		assign.setPrefWidth(100);
		//assign.setOnAction(null);
		return assign;
	}
	
	//Contributing authors: R Legere
	private Node buttons() {
		HBox buttons = new HBox(nextButton(), assignButton());
		return buttons;
	}
	
	//Contributing authors: R Legere
	private Node catFormat() {
		HBox catFormat = new HBox(catBox(), catText(), catButton());
		return catFormat;
	}
	
	
	
	
	
}
