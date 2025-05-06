package practicasprofesionaleslis.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import practicasprofesionaleslis.utilidades.Utilidades;

public class FXMLPrincipalEstudianteController implements Initializable {
    @FXML private Label lbNombreEstudiante;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    public void btnCerrarSesion(ActionEvent event) {
        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        String titulo = "Cerrar Sesión";
        String contenido = "¿Estás seguro que deseas cerrar sesión?";

        if (Utilidades.mostrarAlertaSimple(tipo, titulo, contenido).get() == ButtonType.OK) {
            irInicioSesion();
        }
    }

    private void irInicioSesion() {
        try {
            Stage escenarioBase = (Stage) lbNombreEstudiante.getScene().getWindow();
            Parent vista = FXMLLoader.load(getClass().getResource("/practicasprofesionaleslis/vista/FXMLInicioSesion.fxml"));
            Scene escenaPrincipal = new Scene(vista);
            
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("Pantalla Principal - Estudiante");
            escenarioBase.showAndWait();
            escenarioBase.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
