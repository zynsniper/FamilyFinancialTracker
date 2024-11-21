package team14.fft;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.util.Builder;

//Contributing Authors: O Darrah, W Elliott, D MacIssac
public class BankStatementViewBuilder implements Builder<Region>{
	
	private StringProperty bankStatementProperty;
	private Runnable browseHandler;
	private Runnable nextPageHandler;
	
	//Contributing Authors: O Darrah, W Elliott, D MacIssac
	public BankStatementViewBuilder(StringProperty bankStatementProperty, Runnable browseHandler, Runnable nextPageHandler) {
		this.bankStatementProperty = bankStatementProperty;
		this.browseHandler = browseHandler;
		this.nextPageHandler = nextPageHandler;
	}
	
	//Contributing Authors: O Darrah, W Elliott, D MacIssac
	@Override
	public Region build() {
		BorderPane results = new BorderPane();
		results.setMaxHeight(40);
		results.setMaxWidth(350);
		results.setId("load-statement-pane");
		results.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
		results.setTop(title());
		results.setCenter(formatSelectFile(browseButton(), statementField()));
		results.setBottom(formatNextButton(nextButton()));
		return results;
	}
	
	//Contributing Authors: W Elliott, D MacIssac
	private Node title() {
		Label results = new Label("Select Bank File");
		results.getStyleClass().add("pane-label");
		return results;
	}
	
	//Contributing Authors: W Elliott, D MacIssac
	private Node statementField() {
		TextField results = new TextField();
		results.setEditable(false);
		results.setPrefWidth(200);
		results.textProperty().bind(bankStatementProperty);
		return results;
	}
	
	//Contributing Authors: O Darrah, D MacIssac
	private Node browseButton() {
		Button results = new Button("Browse...");
		results.setId("Browse-and-Load");
		results.setPrefWidth(100);
		results.setOnAction(e->browseHandler.run());
		return results;
	}
	
	//Contributing Authors: O Darrah
	private Node formatSelectFile(Node browseButton, Node textField) {
		HBox results = new HBox();
		results.setPadding(new Insets(10, 10, 10, 10));
		results.setSpacing(10);
		results.getChildren().addAll(textField, browseButton);
		return results;
	}
	
	//Contributing Authors: W Elliott
	private Node formatNextButton(Node nextButton) {
		HBox results = new HBox();
		results.setPadding(new Insets(10, 10, 10, 10));
		results.getChildren().add(nextButton);
		return results;
	}
	
	//Contributing Authors: O Darrah, W Elliott
	private Node nextButton() {
		Button results = new Button("Next");
		results.setId("View-Transaction-List");
		results.setPrefWidth(100);
		results.setOnAction(e->nextPageHandler.run());
		//if file has not been selected, display error, add later
		return results;
	}
}