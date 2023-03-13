module com.mycompany.examen2trimestre {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swing;
    requires jasperreports;
    
    

    opens com.mycompany.examen2trimestre to javafx.fxml;
    exports com.mycompany.examen2trimestre;
}
