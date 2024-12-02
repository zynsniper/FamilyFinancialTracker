package team14.fft;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	
	//Contributing authors: R Legere
	public TransactionListViewBuilder(Runnable next) {
		this.nextHandler = next;
		model = new TransactionListModel();
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
		//results.setOnAction();
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
		ChoiceBox<String> results = new ChoiceBox<>();
		results.getItems().addAll("This is a test", "Hello World");
		return results;
	}
	
	//Contributing Authors: O Darrah
	private Node listOfTransactions(){
		TableView<Transaction> results = new TableView<>();
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
