package com.javafx.contenedores;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PaneyAnchorPane extends Application {

    /*
    En el Pane, utilizamos las propiedades setLayoutX y setLayoutY para definir la posición
    del botón dentro del Pane: se ancla a una posición FIJA referente al borde superior izquierdo (0,0)
    En el AnchorPane, utilizamos las propiedades setTopAnchor y setLeftAnchor para 
    definir la posición del botón en relación con los bordes superior e izquierdo del AnchorPane.
    Lo mismo con setBottomAnchor y setRightAnchor: se ancla con respectoa a un BORDE
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ventana 1: Pane");
        
        //PANE es un contenedor básico, puede contener Nodos y necesita darle una posición Manual y FIJA!
        //ANCHORPANE es un Pane avanzado, que permite adaptarse a cambios en la ventana (permite la adaptabilidad [Responsive])
        //Se ancla a las 4 partes del pane (4 bordes) .set<borde>Anchor 
        
        // Crear un Pane
        Pane pane = new Pane();
        Button buttonPane = new Button("Botón en Pane");
        buttonPane.setLayoutX(20);
        buttonPane.setLayoutY(20);
        Button buttonPane2 = new Button("Botón en Pane2");
        buttonPane2.setLayoutX(180);//PROBLEMA1! Hay que ajustar manualmente, es más complejo
        buttonPane2.setLayoutY(250);//PROBLEMA1! Hay que ajustar manualmente, es más complejo
        pane.getChildren().addAll(buttonPane, buttonPane2);
        
        //PROBLEMA 2: Al Maximizar
        //Observación: el primer buttonPane no tiene problema ya que la ventana siempre crece hacia la derecha y hacia abajo
        
        Scene scene1 = new Scene(pane, 300, 300);
        primaryStage.setScene(scene1);
        primaryStage.setX(200);
        primaryStage.setY(100);
        primaryStage.show();

        //Creamos una segunda ventana (Stage)
        Stage secondStage = new Stage();
        secondStage.setTitle("Ventana 2: AnchorPane");

        //Creamos un AnchorPane
        AnchorPane anchorPane = new AnchorPane();
        Button buttonAnchorPane = new Button("Botón en AnchorPane");
        //Restricción(nodo,distancia)
        AnchorPane.setBottomAnchor(buttonAnchorPane, 20.0);
        AnchorPane.setRightAnchor(buttonAnchorPane, 20.0);
        anchorPane.getChildren().add(buttonAnchorPane);

        Scene scene2 = new Scene(anchorPane, 300, 300);

        secondStage.setScene(scene2);
        secondStage.show();

    }
}
