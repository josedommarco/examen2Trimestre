package com.mycompany.examen2trimestre;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JRException;

public class PrimaryController implements Initializable {
    
    Informe informe = new Informe();
    
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

    private List<Alumno> listaAlumnos = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tc_nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        tc_apellidos.setCellValueFactory(new PropertyValueFactory("Apellidos"));
        tc_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
        tc_sge.setCellValueFactory(new PropertyValueFactory<>("sge"));
        tc_di.setCellValueFactory(new PropertyValueFactory<>("di"));
        tc_pmdm.setCellValueFactory(new PropertyValueFactory<>("pmdm"));
        tc_psp.setCellValueFactory(new PropertyValueFactory<>("psp"));
        tc_eie.setCellValueFactory(new PropertyValueFactory<>("eie"));
        tc_hlc.setCellValueFactory(new PropertyValueFactory<>("hlc"));

        actualizarTabla();
    }

    private List<Alumno> CrearAlumno() {

        Alumno a1 = new Alumno();

        a1.setNombre("Jose");
        a1.setApellidos("Luis");
        a1.setAd( 6.5);
        a1.setSge(7.2);
        a1.setDi(8.3);
        a1.setPmdm(5.8);
        a1.setPsp(6.7);
        a1.setEie(7.5);
        a1.setHlc(7.8);

       						
        
        Alumno a2 = new Alumno();

        a2.setNombre("Loren");
        a2.setApellidos("Lynch");
        a2.setAd(7.3);
        a2.setSge(8.5);
        a2.setDi(7.2);
        a2.setPmdm(3.5);
        a2.setPsp(8.0);
        a2.setEie(7.9);
        a2.setHlc(8.2);

        						
        
        Alumno a3 = new Alumno();

        a3.setNombre("Antonio");
        a3.setApellidos("García");
        a3.setAd(5.80);
        a3.setSge(6.70);
        a3.setDi(5.50);
        a3.setPmdm(7.30);
        a3.setPsp(4.20);
        a3.setEie(6.80);
        a3.setHlc(6.50);
        
        						

        listaAlumnos.add(a1);
        listaAlumnos.add(a2);
        listaAlumnos.add(a3);

        return listaAlumnos;

    }

    private void actualizarTabla() {
        if (listaAlumnos.size() == 0) {
            listaAlumnos = CrearAlumno();
        }
        ObservableList<Alumno> alumnos1 = FXCollections.observableArrayList();
        alumnos1.addAll(listaAlumnos);

        id_tabla.getItems().clear();
        id_tabla.getItems().addAll(alumnos1);
    }

    @FXML
    private void añadirAlumno(ActionEvent event) {
        String nombre = tf_nombre.getText();
        String apellidos = tf_apellidos.getText();
        double ad = Double.parseDouble(tf_ad.getText());
        double sge = Double.parseDouble(tf_sge.getText());
        double di = Double.parseDouble(tf_di.getText());
        double pmdm = Double.parseDouble(tf_pmdm.getText());
        double psp = Double.parseDouble(tf_psp.getText());
        double eie = Double.parseDouble(tf_eie.getText());
        double hlc = Double.parseDouble(tf_hlc.getText());

        Alumno nuevoAlumno = new Alumno(nombre, apellidos, ad, sge, di, pmdm, psp, eie, hlc);
        listaAlumnos.add(nuevoAlumno);

        actualizarTabla();
        tf_nombre.clear();
        tf_apellidos.clear();
        tf_ad.clear();
        tf_sge.clear();
        tf_di.clear();
        tf_pmdm.clear();
        tf_psp.clear();
        tf_eie.clear();
        tf_hlc.clear();

    }

    @FXML
    private void abrirNotas(ActionEvent event) {
    
       try {
            informe.showReport();
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            informe.pdfReport();
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

@FXML
private void informacionAlumno(MouseEvent event) {
    Alumno alumnoSeleccionado = id_tabla.getSelectionModel().getSelectedItem();
    if (alumnoSeleccionado != null) {
        StringBuilder mensaje = new StringBuilder();
        double media = alumnoSeleccionado.getMedia();
        int numSuspensos = alumnoSeleccionado.getNumSuspensos();
        if (media > 0) {
            mensaje.append("Nota media: ").append(media).append("\n");
        } else {
            mensaje.append("El alumno está suspendido.\n");
        }
        if (numSuspensos > 0) {
            mensaje.append("Número de módulos suspendidos: ").append(numSuspensos).append("\n");
        } else {
            mensaje.append("El alumno ha aprobado todos los módulos.\n");
        }
        if (mensaje.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información del alumno");
            alert.setHeaderText(alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellidos());
            alert.setContentText(mensaje.toString());
            alert.showAndWait();
        }
    }
}



}
