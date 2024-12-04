package team14.fft;


import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class CategoryListViewBuilder implements Builder<Region>{
	CategoryListModel model;
	ChoiceBox<Category> cats;
	
	public CategoryListViewBuilder(ObservableList<TransactionModel> list) {
		model = new CategoryListModel(list);
	}
	//Contributing authors: R Legere
	public Region build() {
		VBox build = new VBox(labs(), catBox(), noCatList(), buttons());
		build.setSpacing(10);
		build.setPrefHeight(300);
		build.setPrefWidth(200);
		build.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
		return build;
	}
	
	//Contributing authors: R Legere
	private Node title() {
		Label lab = new Label("Unassigned categories\n");
		lab.getStyleClass().add("pane-label");
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
		cats = new ChoiceBox<>();
		cats.setItems(model.getList());
		return cats;
	}
	
	//Contributing authors: R Legere, O Darrah
	private TableView<TransactionModel> noCatList() {
		@SuppressWarnings("unchecked")
			TableView<TransactionModel> results = new TableView<>(model.getTransactions());
			
			TableColumn<TransactionModel, String> dateColumn = new TableColumn<>("Date");
	        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
	        dateColumn.setSortable(true);

	        TableColumn<TransactionModel, ?> buyerColumn = new TableColumn<>("Buyer");
	        buyerColumn.setCellValueFactory(new PropertyValueFactory<>("buyer"));
	        buyerColumn.setSortable(true);

	        TableColumn<TransactionModel, ?> vendorColumn = new TableColumn<>("Vendor");
	        vendorColumn.setCellValueFactory(new PropertyValueFactory<>("vendor"));
	        vendorColumn.setSortable(true);
	        
	        TableColumn<TransactionModel, ?> totalColumn = new TableColumn<>("Cost");
	        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
	        totalColumn.setSortable(true);
	        
	        TableColumn<TransactionModel, Boolean> selectColumn = new TableColumn<>("Select");
	        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));
	        
	        TableColumn<TransactionModel, ?> catColumn = new TableColumn<>("Category");
	        catColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
	        
	        results.getColumns().add(selectColumn);
	        results.getColumns().add(dateColumn);
	        results.getColumns().add(buyerColumn);
	        results.getColumns().add(vendorColumn);
	        results.getColumns().add(totalColumn);
	        results.getColumns().add(catColumn);
	       
			return results;
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
		assign.setOnAction(e -> {
			
		model.addCats(cats.getValue().toString());
	    noCatList().refresh();});
		return assign;
	}
	
	//Contributing authors: R Legere
	private Node buttons() {
		HBox buttons = new HBox(nextButton(), assignButton());
		buttons.setSpacing(10);
		return buttons;
	}
	
	
	
	
	
}
