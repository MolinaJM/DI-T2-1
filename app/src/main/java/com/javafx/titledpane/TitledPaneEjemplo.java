package com.javafx.titledpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitledPaneEjemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label=new Label("Etiqueta dentro del TitledPane");
        TitledPane titledPane=new TitledPane("Título", label);
        titledPane.setCollapsible(true);

        //titledPane.setExpanded(true);
        titledPane.setExpanded(false);

        Scene scene=new Scene(new VBox(titledPane),100,100);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}