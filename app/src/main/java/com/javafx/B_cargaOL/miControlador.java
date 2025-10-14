package com.javafx.B_cargaOL;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Molina
 */
public class miControlador implements Initializable {
    
     ObservableList<String> nombresRarosElfos = FXCollections.observableArrayList(
            "Aelrindel",
            "Eldarion",
            "Galadhon",
            "Ilmare",
            "Luthion",
            "Celebrian",
            "Faerwen",
            "Nimrodel",
            "Thranduilion",
            "Lorienel",
            "Aerendyl",
            "Mithrandiriel",
            "Silmarien",
            "Eärfalas",
            "Míriel"
        );


    ObservableList<Robot> listaRobots = FXCollections.observableArrayList(
            new Robot("Robocop", "Robocop")
    );
    
      ObservableList<String> seriesLista = FXCollections.observableArrayList(
                "Breaking Bad",
                "The Expanse",
                "Stranger Things",
                "Last Of Us",
                "The Mandalorian",
                "Friends",
                "The IT"
        );
  
     

    @FXML
    private ComboBox<String> miCombo;

    @FXML
    private ListView<String> miLista;

    @FXML
    private TableView<Robot> miTabla;

    @FXML
    private TableColumn<Robot, String> nombreColumn;

    @FXML
    private TableColumn<Robot, String> peliColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Configura combo
        miCombo.setItems(nombresRarosElfos);
        
        //Configura ListView
         miLista.setItems(seriesLista);
        
        //Configura TableView
        //Los campos han de coincidir con los campos del objeto 
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Robot, String>("nombre"));
        peliColumn.setCellValueFactory(new PropertyValueFactory<Robot, String>("peli"));
        miTabla.setItems(listaRobots);
    }
}
