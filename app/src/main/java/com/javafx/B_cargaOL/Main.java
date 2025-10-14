package com.javafx.B_cargaOL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Molina
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primeraEscena) throws Exception { //puede lanzar excep'
        Parent root = FXMLLoader.load(getClass().getResource("/ejemplo_OL.fxml"));

        Scene scene = new Scene(root);
        primeraEscena.setScene(scene);
        primeraEscena.setTitle("Primer Ejemplo JavaFX - Hola Mundo");
        primeraEscena.show();
        
        
    }
}
