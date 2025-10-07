package com.javafx.menubar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contenedores extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BORDERPANE");
      
        // BorderPane
        BorderPane borderPane=new BorderPane();
        Button button7=new Button("Botón 7");
        Button button8=new Button("Botón 8");
        Button button9=new Button("Botón 9");
        Button button12=new Button("Botón 12");
        Button button13=new Button("Botón 13");
        borderPane.setTop(button7);
        borderPane.setCenter(button8);
        borderPane.setBottom(button9);
        borderPane.setRight(button12);
        borderPane.setLeft(button13);
        borderPane.setStyle("-fx-background-color: blue;");
        
        // Organizar todo en un VBox principal
        VBox root=new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(borderPane);
        

        Scene scene=new Scene(root, 650, 100);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
