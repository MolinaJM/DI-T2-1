package com.javafx.text;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextEjemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Es como un Label pero se puede personalizar aún más
        Text miTexto=new Text("Esto es un ejemplo!!");
        miTexto.setWrappingWidth(100); //Estrecha ancho a una cantidad 
        miTexto.setStrikethrough(true); //Contorno
        miTexto.setUnderline(true); //Subrayado
        miTexto.setFontSmoothingType(FontSmoothingType.LCD);
        miTexto.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        //Relleno y borde
        miTexto.setFill(Color.DARKMAGENTA);
        miTexto.setStroke(Color.GREEN);

        miTexto.setX(0);
        miTexto.setY(20);
        miTexto.setTextOrigin(VPos.BASELINE);//Se podría poner con respecto a cualquier Nodo


        Scene scene=new Scene(new Pane(miTexto), 300, 380);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
