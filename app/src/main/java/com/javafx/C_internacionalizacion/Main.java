package com.javafx.C_internacionalizacion;

import java.util.Locale;
import java.util.ResourceBundle;
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
        try {
            //Se establecen los lenguajes y regiones
            Locale castellanoLocale = new Locale.Builder().setLanguage("es").setRegion("ES").build();
            Locale englishLocale = new Locale.Builder().setLanguage("en").setRegion("EN").build();
           // ResourceBundle bundle = ResourceBundle.getBundle("messages", castellanoLocale);
            ResourceBundle bundle = ResourceBundle.getBundle("messages", englishLocale);
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ejemplo_internacionalizacion.fxml"));
            loader.setResources(bundle);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primeraEscena.setScene(scene);
            primeraEscena.setTitle("Primer Ejemplo JavaFX - Hola Mundo");
            primeraEscena.show();

        } catch (Exception e) {
            e.printStackTrace();
            // Manejo adicional del error (por ejemplo, mostrar un mensaje de error al usuario)
        }
    }
}
