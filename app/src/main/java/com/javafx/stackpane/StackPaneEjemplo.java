package com.javafx.stackpane;

/**
 *
 * @author Molina
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StackPaneEjemplo extends Application {

    private StackPane stackPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();

        stackPane = new StackPane(); // StackPane o Panel de CAPAS

        // Añadimos elementos y los tenemos que ir VISIBILIZANDO O INVISIBILIZANDO
        Label label = new Label("Soy una etiqueta");
        label.setStyle("-fx-background-color:yellow");
        label.setPadding(new Insets(5, 5, 5, 5));// Se añade borde interno
        label.setVisible(false);
        stackPane.getChildren().add(label);

        Button button = new Button("Soy un botón");
        button.setStyle("-fx-background-color: cyan");
        button.setPadding(new Insets(5, 5, 5, 5));
        button.setVisible(false);
        stackPane.getChildren().add(button);

        CheckBox checkBox = new CheckBox("Soy un checkbox");
        checkBox.setOpacity(1);
        checkBox.setStyle("-fx-background-color:olive");
        checkBox.setPadding(new Insets(5, 5, 5, 5));
        checkBox.setVisible(true);
        stackPane.getChildren().add(checkBox);
        stackPane.setPrefSize(300, 150);

        vbox.getChildren().add(stackPane);// Si solamente tenemos un parent stackPane hemos de cambiar de capa
        // para ver los componentes. Se podría haber metido

        Button controlButton = new Button("CAMBIA!!!");
        vbox.getChildren().add(controlButton);

        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 550, 250);

        primaryStage.setTitle("StackPane Layout Ejemplo");
        primaryStage.setScene(scene);

        controlButton.setOnAction(e -> {
            cambiaElemento();
        });

        primaryStage.show();
    }

    // Ejemplo de uso de un OL con Nodos
    private void cambiaElemento() {
        ObservableList<Node> childs = this.stackPane.getChildren();

        Node topNode = childs.get(2);
        Node newTopNode = childs.get(1);
        System.out.println("2 PRIMEROS: "+topNode + " " + newTopNode);

        topNode.setVisible(false);
        topNode.toBack();
        newTopNode.setVisible(true);

        System.out.println("HIJOS TRAS EL CAMBIO "+childs);
    }

}
// OBSERVACIONES
// Si mezclamos la estructura de TOOLBAR+STACKPANE ya tenemos una APP con CAPAS
// Simplemente habría que asociar cada botón del TOOLBAR con la acción:
// - .toFront() (capa que quiero mostrar), .toBack() capa/s que NO.