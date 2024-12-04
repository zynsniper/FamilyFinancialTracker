package team14.fft;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

//Contributing Authors: O Darrah, W Elliott, R Legere
public class TransactionListViewBuilder implements Builder<Region> {
	private Runnable nextHandler;
	String buyer;
	TransactionListModel model;
	ChoiceBox<Buyer> buyers;
	
	//Contributing authors: R Legere
	public TransactionListViewBuilder(Runnable next, Statement statement) {
		this.nextHandler = next;
		model = new TransactionListModel(statement);
	}
	
	//Contributing Authors: O Darrah, W Elliott
	@Override
	public Region build() {
		BorderPane results = new BorderPane();
		results.setTop(formatTitle(title(), instructions()));
		results.setBottom(formatButtons(assignButton(), addBuyerField(), addBuyerButton(), nextButton()));
		results.setCenter(formatCenter(buyerMenu(), listOfTransactions()));
		results.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
		return results;
	}
	
	//Contributing Authors: W Elliott
	private Node title() {
		Label results = new Label("Unassigned Transactions");
		results.getStyleClass().add("pane-label");
		return results;
	}
	
	//Contributing Authors: W Elliott
	private Node instructions() {
		Label results = new Label("Please select a buyer from the dropdown menu, then select any number of transactions to be assigned to them.");
		return results;
	}
	
	//Contributing Authors: W Elliott
	private Node formatTitle(Node title, Node instructions) {
		VBox results = new VBox();
		results.setSpacing(10);
		results.setPadding(new Insets(0,10,10,10));
		results.getChildren().addAll(title, instructions);
		return results;
	}
	
	//Contributing Authors: O Darrah
	private Node assignButton() {
		Button results = new Button("Assign");
		results.setPrefWidth(100);
		results.setOnAction(e -> {
		    model.addBuyers(buyers.getValue().toString());
		    listOfTransactions().refresh();});
		return results;
	}
	private Node addBuyerField() {
		TextField newBuyer = new TextField();
		//newBuyer.setPromptText("Enter buyer name");
		newBuyer.setPrefWidth(200);
		newBuyer.textProperty().bindBidirectional(model.buyerStr());
		return newBuyer;
	}
	
	private Node addBuyerButton() {
		Button results = new Button("Add Buyer");
		results.setPrefWidth(100);
		results.setOnAction(e -> model.addBuyer());
		return results;
	}
	
	//Contributing authors: R Legere
	private Node nextButton() {
		Button next = new Button("Next");
		next.setPrefWidth(100);
		next.setOnAction(e -> nextHandler.run());
		return next;
	}
	
	//Contributing Authors: O Darrah
	private Node formatButtons(Node assignButton, Node newBuyer, Node addBuyerButton, Node nextButton) {
		HBox results = new HBox();
		results.setPadding(new Insets(10,10,10,10));
		results.setSpacing(10);
		results.getChildren().addAll(assignButton, newBuyer, addBuyerButton, nextButton);
		return results;
	}
	
	//Contributing Authors: O Darrah
	private Node buyerMenu() {
		buyers = new ChoiceBox<Buyer>();
		buyers.setItems(model.getList());
		buyers.setPrefWidth(100);
		return buyers;
	}
	
	//Contributing Authors: O Darrah
	@SuppressWarnings("unchecked")
	private TableView<TransactionModel> listOfTransactions(){
		TableView<TransactionModel> results = new TableView<>(model.getObservableTransactionModels());
		
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
        
        results.getColumns().add(selectColumn);
        results.getColumns().add(dateColumn);
        results.getColumns().add(buyerColumn);
        results.getColumns().add(vendorColumn);
        results.getColumns().add(totalColumn);
       
		return results;
	}
	
	//Contributing Authors: O Darrah
	private Node formatCenter(Node menu, Node table) {
		VBox results = new VBox();
		results.setSpacing(10);
		results.setPadding(new Insets(10,10,10,10));
		results.getChildren().addAll(menu, table);
		return results;
	}
}
