package com.javafx.contextmenu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemploContextMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("Acción 1");
        MenuItem menuItem2 = new MenuItem("Acción 2");
        MenuItem menuItem3 = new MenuItem("Acción 3");

        menuItem3.setOnAction((event) -> {
            System.out.println("Has pulsado en la acción 3!");
        });

        contextMenu.getItems().addAll(menuItem1,menuItem2,menuItem3);

        TextArea textArea = new TextArea();
        //.setContextMenu asocia menú contextual a NODO
        textArea.setContextMenu(contextMenu);

        VBox vBox = new VBox(textArea);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ejemplo Menú Popup/Contextual");

        primaryStage.show();
    }
}