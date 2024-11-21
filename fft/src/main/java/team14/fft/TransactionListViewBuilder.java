package team14.fft;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

//Contributing Authors: O Darrah, W Elliott
public class TransactionListViewBuilder implements Builder<Region> {

	//Contributing Authors: O Darrah, W Elliott
	@Override
	public Region build() {
		BorderPane results = new BorderPane();
		results.setTop(formatTitle(title(), instructions()));
		results.setBottom(formatAssignButton(assignButton()));
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
		results.setPrefWidth(70);
		//results.setOnAction();
		return results;
	}
	
	//Contributing Authors: O Darrah
	private Node formatAssignButton(Node assignButton) {
		HBox results = new HBox();
		results.setPadding(new Insets(10,10,10,10));
		results.getChildren().add(assignButton);
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
