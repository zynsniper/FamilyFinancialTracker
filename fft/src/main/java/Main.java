package fft.src.main.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Button
        Button button = new Button("Click Me!");
        button.setOnAction(event -> System.out.println("Hello, JavaFX!"));

        // Create a layout and add the button to it
        StackPane root = new StackPane();
        root.getChildren().add(button);

        // Create a Scene with the layout
        Scene scene = new Scene(root, 300, 200);

        // Configure the Stage (window)
        primaryStage.setTitle("JavaFX Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}