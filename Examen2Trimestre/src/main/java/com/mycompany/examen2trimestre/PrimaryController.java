package com.mycompany.examen2trimestre;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML
    private TextField tf_nombre;
    @FXML
    private TextField tf_apellidos;
    @FXML
    private TextField tf_ad;
    @FXML
    private TextField tf_sge;
    @FXML
    private TextField tf_di;
    @FXML
    private TextField tf_pmdm;
    @FXML
    private TextField tf_psp;
    @FXML
    private TextField tf_eie;
    @FXML
    private TextField tf_hlc;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnNotas;
    @FXML
    private Button btnSalir;
    @FXML
    private TableView<Alumno> id_tabla;
    @FXML
    private TableColumn<Alumno, String> tc_nombre;
    @FXML
    private TableColumn<Alumno, String> tc_apellidos;
    @FXML
    private TableColumn<Alumno, Double> tc_ad;
    @FXML
    private TableColumn<Alumno, Double> tc_sge;
    @FXML
    private TableColumn<Alumno, Double> tc_di;
    @FXML
    private TableColumn<Alumno, Double> tc_pmdm;
    @FXML
    private TableColumn<Alumno, Double> tc_psp;
    @FXML
    private TableColumn<Alumno, Double> tc_eie;
    @FXML
    private TableColumn<Alumno, Double> tc_hlc;
    
    private ObservableList<Alumno> listaAlumnos;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        Alumno a1 = new Alumno("Jose Luis", "Dommarco", 8.0, 7.5, 9.0, 6.5, 8.0, 7.0, 7.5);
        Alumno a2 = new Alumno("Antonio", "García", 8.0, 7.5, 9.0, 6.5, 8.0, 7.0, 7.5);
        Alumno a3 = new Alumno("Loren", "Lynch", 8.0, 7.5, 9.0, 6.5, 8.0, 7.0, 7.5);

      
    }
       
   

    @FXML
    private void añadirAlumno(ActionEvent event) {
        
        
    }

    @FXML
    private void abrirNotas(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
    }

    
    
    
}
