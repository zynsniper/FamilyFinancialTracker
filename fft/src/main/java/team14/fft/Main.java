package team14.fft;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

//Contributing Authors: O Darrah, D MacIssac
public class Main extends Application{
	
	public static BorderPane mainLayout;
	
	//Contributing Authors: O Darrah
	public static BorderPane getMainLayout() {
		return mainLayout;
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
	
	//Contributing Authors: O Darrah, D MacIssac
	@Override
	public void start(Stage primaryStage) {
		
		TransactionsModel model = new TransactionsModel();
		
		mainLayout = new BorderPane();
		mainLayout.setPadding(new Insets(10,10,10,10));
		mainLayout.setCenter(new BankStatementController(model).getView());
		
		primaryStage.setTitle("Family Financial Tracker");
		primaryStage.setScene(new Scene(mainLayout, 800, 400));
		primaryStage.show();
	}
	
}