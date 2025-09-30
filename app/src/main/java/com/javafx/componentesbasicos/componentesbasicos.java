package com.javafx.componentesbasicos;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class componentesbasicos extends Application {

    ComboBox<String> comboBox;
    ChoiceBox<String> choiceBox;
    TextField cajaTexto;
    Label etiquetaCaja;
    DatePicker datePicker;
    PasswordField passwordField;
    TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Label
        etiquetaCaja = new Label("Caja de Texto");

        //TextField
        cajaTexto = new TextField();
        //Método setFont se puede aplicar a TextField, Button, ToggleButton, TextArea, etc...
        cajaTexto.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
        cajaTexto.setPromptText("Texto de Caja");//Cuando No tiene el foco, escribe un "PlaceHolder"
        //Para establecer valor: cajaTexto.setText("Texto de Caja");
        cajaTexto.setMaxWidth(150);

        //PasswordField
        passwordField = new PasswordField();

        //ComboBox
        ObservableList<String> platos = FXCollections.observableArrayList(
                "Primavera", "Verano", "Otoño", "Invierno"
        );
        
        comboBox = new ComboBox<>(platos); //Se podría haber rellenado con un OL // new ComboBox<>(...)
        comboBox.getItems().add("Macarrones"); //Acceso al OL interno
        comboBox.getItems().add("Spaguettis");
        comboBox.getItems().add("Papardelle");
        
        comboBox.setEditable(true);
        comboBox.setPromptText("Escoge comida..");//PlaceHolder

        comboBox.setOnAction(e -> {
            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = comboBox.getSelectionModel().getSelectedItem();

            System.out.println("Selección: [" + selectedIndex + "] " + selectedItem);
            System.out.println(" Valor: " + comboBox.getValue());
            
            textArea.setText("Selección: [" + selectedIndex + "] " + selectedItem+" Valor: " + comboBox.getValue());
        });

        //ChoiceBox
        ObservableList<String> estaciones = FXCollections.observableArrayList(
                "Primavera", "Verano", "Otoño", "Invierno"
        );
        choiceBox = new ChoiceBox<>(estaciones);
        choiceBox.setOnAction(event -> {
            System.out.println(event);
            String selectedOption = choiceBox.getValue();
            System.out.println("Opción seleccionada: " + selectedOption);
        });
        //De la misma forma que con el ComboBox, también podíamos añadir con .getItems.add("....")

        //RadioBotones
        //Grupo para los botones de radio dependientes
        ToggleGroup toggleGroup = new ToggleGroup();
        //3 botones de radio dependientes
        RadioButton radioButton1 = new RadioButton("Opción 1");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton1.setSelected(true);
        RadioButton radioButton2 = new RadioButton("Opción 2");
        radioButton2.setToggleGroup(toggleGroup);
        RadioButton radioButton3 = new RadioButton("Opción 3");
        radioButton3.setToggleGroup(toggleGroup);

        //Espacio en blanco
        Region espacioBlanco = new Region();
        espacioBlanco.setPrefHeight(10);

        //Grupo para los botones de radio dependientes
        ToggleGroup toggleGroup2 = new ToggleGroup();
        //2 botones de radio independientes
        RadioButton radioButton4 = new RadioButton("Opción 4");
        RadioButton radioButton5 = new RadioButton("Opción 5");
        radioButton4.setToggleGroup(toggleGroup2);
        radioButton5.setToggleGroup(toggleGroup2);

        VBox vboxRadios = new VBox(10); // 10px entre elementos
        vboxRadios.setPadding(new Insets(20)); //20 px de Borde invisible para todo el Layout
        vboxRadios.getChildren().addAll(radioButton1, radioButton2, radioButton3, espacioBlanco, radioButton4, radioButton5);

        //Controlador de eventos para el primer grupo. Observable es un parámetro obligatorio que
        //representa la propiedad (en este caso .selectedToggleProperty), por si queremos acceder
        //a sus características. Lógicamente no tiene por qué llamarse 'observable'
        toggleGroup.selectedToggleProperty().addListener((observable, valorAnt, valorAct) -> {
            if (valorAct != null) {
                System.out.println(observable);
                System.out.println("Pasamos de" + ((RadioButton) valorAnt).getText()
                        + " a: " + ((RadioButton) valorAct).getText());
            }

        });
        //Para saber si iestán marcados o no..
        System.out.println(radioButton1.isSelected() + " " + radioButton2.isSelected() + " " + radioButton2.isSelected() + " " + radioButton4.isSelected());

        //Checkbox
        CheckBox checkBox1 = new CheckBox("Opción 1");
        //checkBox1.setSelected(true);
        checkBox1.setOnAction(e -> {
            if (checkBox1.isSelected()) {
                System.out.println("Checkbox marcado!");
            } else {
                System.out.println("Checkbox DESmarcado!");
            }
        });

        //DatePicker
        datePicker = new DatePicker();
        datePicker.setOnAction(e -> {
            LocalDate miFecha = datePicker.getValue();
            if (miFecha != null) {
                System.out.println("Fecha seleccionada: " + miFecha);
            }
        });

        //ImageView
        String url="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
        //Se crea, carga y asigna la imagen
        ImageView imageView = new ImageView();
        Image imagen = new Image(url, true);//Booleano para preservar el ratio
        imageView.setImage(imagen);

        //TextArea
        textArea = new TextArea();
        textArea.setText("Puedes escribir todo lo que quieras");
        //String text=textArea.getText();

        ToggleButton toggleButton = new ToggleButton("Inactivo");

        toggleButton.setOnAction(e -> {
            System.out.println("Pulsado botón ON/OFF");
            String buttonText = toggleButton.isSelected() ? "Activo" : "Inactivo";
            toggleButton.setText(buttonText);
        });

        //Layout Principal
        VBox vbox = new VBox(imageView, etiquetaCaja, cajaTexto, passwordField,
                comboBox, choiceBox, vboxRadios, checkBox1, datePicker,
                textArea, toggleButton
        );

        //Tooltips
        Tooltip tooltip = new Tooltip("Caja para introducir el nombre");
        cajaTexto.setTooltip(tooltip);

        vbox.setPadding(new Insets(20));
        Scene scene = new Scene(vbox, 300, 550);
        primaryStage.setTitle("Componentes Básicos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
