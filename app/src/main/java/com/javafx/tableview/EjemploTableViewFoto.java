package com.javafx.tableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EjemploTableViewFoto extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //Cambios con respecto a EjemploTableView
    //1) Añade nuevos campos en el OL: fotos pueden ir en URL o en Base64
    //2) Ponemos TV a editable
    @Override
    public void start(Stage primaryStage) throws InterruptedException, FileNotFoundException {

        ObservableList<RobotFoto> lista = FXCollections.observableArrayList(
                new RobotFoto("Robocop", "Robocop", "https://images.virgula.me/2017/04/robocop1.jpg", true)
        );
        TableView tableView = new TableView(lista);
        //Se establece a editable la tabla para que se puedan tocar objetos como radios o checkbox
        //Si quisiéramos editar una celda tipo texto (cosa no recomendable) habría que tocar
        //eventos setCellFactory y setOnEditCommit
        tableView.setEditable(true);

        //Añadimos robot
        tableView.getItems().add(new RobotFoto("Terminator", "Terminator", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Terminator-2-judgement-day.jpg/220px-Terminator-2-judgement-day.jpg", false));
        //Se carga directamente en OL, además utilizamos una imagen en base64
        lista.add(new RobotFoto("TARS", "Interestellar", "data:image/jpeg;base64,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", true));
        System.out.println(lista.size());

        //Tabla necesita definir columnas asociadas a las propiedasdes de 1 modelo (Clase)
        TableColumn<RobotFoto, String> c1 = new TableColumn<>("Nombre");//Título
        c1.setCellValueFactory(new PropertyValueFactory<>("nombre"));//propiedad en Robot
        TableColumn<RobotFoto, String> c2 = new TableColumn<>("Película");//Título
        c2.setCellValueFactory(new PropertyValueFactory<>("peli"));//propiedad en Robot
        //Se crea nueva columna para Imagen  
        TableColumn<RobotFoto, ImageView> c3_foto = new TableColumn<>("Imagen");
        //No se asocia ninguna columna para fotoURL (porque no nos interesa que salga la URL/BASE64, pero sí la FOTO)
        //Por tanto, creamos una columna NO asociada a ninguna propiedad del objeto RobotFoto
        //Tocamos la función .setCellValueFactory para crear una celda "personalizada" devolviendo
        //lo que queremos mostrar con un return new SimpleObjectProperty<>(objetoadevolver)
        c3_foto.setCellValueFactory(cellData -> {
            ImageView imageView = new ImageView(new Image(cellData.getValue().getFotoURL()));
            imageView.setFitHeight(40);
            imageView.setFitWidth(40);
            return new SimpleObjectProperty<>(imageView);
        });//Conclusión: se puede mostrar CUALQUIER cosa dentro de una celda

        TableColumn<RobotFoto, CheckBox> c4 = new TableColumn<>("Está Vivo?");
        //c4.setCellValueFactory(new PropertyValueFactory<>("sigueconvida"));//propiedad en Robot
        //Si queremos personalizar:
        c4.setCellValueFactory(cellData -> {
            CheckBox cb = new CheckBox();
            cb.setSelected(cellData.getValue().isSigueconvida());
            return new SimpleObjectProperty<>(cb);
        });

        TableColumn<RobotFoto, Button> c5 = new TableColumn<>("Acción!");
        c5.setCellValueFactory(cellData -> {
            //Podemos meter todos los botones que nos interese en la misma celda,
            //pero habrá que hacer un Layout padre que los contenga
            Button button = new Button("Púlsame!");
            button.setOnAction(event -> {
                RobotFoto r = cellData.getValue();//Acceso al objeto Modelo
                System.out.println("Has pinchado en: " + r.getNombre());
            });
            return new SimpleObjectProperty<>(button);
        });

        tableView.getColumns().addAll(c1, c2, c3_foto, c4, c5);

        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {//1 Click
                RobotFoto robotSelec = (RobotFoto) tableView.getSelectionModel().getSelectedItem();
                if (robotSelec != null) {
                    System.out.println("Robot Seleccionado: " + robotSelec.getNombre());
                }
            }
        });

        //Personalización con .setCellFactory de la columna 1
        c1.setCellFactory(e -> new TableCell<RobotFoto, String>() {
            @Override
            //Se ejecuta cada vez que muestra un Item.
            protected void updateItem(String item, boolean empty) {
                if (!empty) {
                    this.setText(item);//traspasamos el valor
                    if (item.matches("^T.*")) {//Personalizamos
                        this.setStyle("-fx-background-color: lightblue; -fx-font-weight: bold;"); //CSS
                    }
                    else{
                        this.setStyle(null);
                    }
                } else {
                    this.setText(null);
                }
            }
        });

        //Personalización con .setCellFactory de la columna 4
        c4.setCellFactory(e -> new TableCell<RobotFoto, CheckBox>() {
            //necesitamos "construir" qué vamos a mostrar de forma interna, en este caso un CB
            //Con el ejemplo de la columna1 no era necesario ya que simplemente mostramos
            //un texto
            private final CheckBox checkBox = new CheckBox();

            @Override
            //Se ejecuta cada vez que muestra un Item.
            protected void updateItem(CheckBox item, boolean empty) {
               // super.updateItem(item, empty);
                if (!empty) {
                    checkBox.setSelected(item.isSelected());//traspasamos el valor
                    setGraphic(checkBox);  //se muestra el checkbox
                    if (item.isSelected()) {
                        setStyle("-fx-background-color: red; -fx-font-weight: bold;"); //CSS
                    } else {
                        setStyle("-fx-background-color: lightgreen; -fx-font-weight: bold;"); //CSS
                    }
                    //Hay que crear un evento explícito ya que updateItem solo se muestra al listar/relistar
                    checkBox.setOnAction(event -> {
                        RobotFoto robot = getTableView().getItems().get(getIndex());  // Obtener el robot actual de la fila, no se puede utilizar getSelectedItem porque no hay nada seleccionado
                        robot.setSigueconvida(checkBox.isSelected());  // Actualizar el campo "seleccionado" en el objeto RobotFoto
                        if (checkBox.isSelected()) {
                            setStyle("-fx-background-color: red; -fx-font-weight: bold;"); //CSS
                        } else {
                            setStyle("-fx-background-color: lightgreen; -fx-font-weight: bold;"); //CSS
                        }
                    });
                } //no hace falta else porque TODAS las columnas tienen CB
            }
        });

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 390, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
