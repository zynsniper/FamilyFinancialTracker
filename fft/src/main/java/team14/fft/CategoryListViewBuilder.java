package team14.fft;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class CategoryListViewBuilder implements Builder<Region>{
	
	//Contributing authors: R Legere
	public Region build() {
		VBox build = new VBox(labs(), catBox(), noCatList(), buttons());
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
		cats.getItems().add(test);
		return cats;
	}
	
	//Contributing authors: R Legere
	private Node noCatList() {
		VBox toReturn = new VBox();
		/*for(int i=0; i<transactions.size(); i++) {
			if(transactions.get(i).getCat() == null) {
				String transaction = transactions.get(i).toString();*/
				CheckBox box = new CheckBox("Example transaction");
				//box.setOnAction()
				toReturn.getChildren().add(box);
			//}
		//}
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
	
	
	
	
	
}
