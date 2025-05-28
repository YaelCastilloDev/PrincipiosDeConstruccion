package practicasprofesionaleslis.utilidades;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import practicasprofesionaleslis.PracticasProfesionalesLIS;

public class Utilidades {
    public static Optional<ButtonType> mostrarAlertaSimple(Alert.AlertType tipo,
            String titulo, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        return alerta.showAndWait();
    }
    
    public static Stage obtenerEscenarioComponente(Control componente) {
        return (Stage) componente.getScene().getWindow();
    }
    
    public static void irInicioSesion(Control componente) {
        try {
            Stage escenarioBase = (Stage) componente.getScene().getWindow();
            Parent vista = FXMLLoader.load(PracticasProfesionalesLIS.class.getResource("/practicasprofesionaleslis/vista/FXMLInicioSesion.fxml"));
            Scene escenaPrincipal = new Scene(vista);
            
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("INICIO DE SESIÓN");
            escenarioBase.show();
            escenarioBase.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void cerrarVentana(Control componente) {
        ((Stage) componente.getScene().getWindow()).close();
    }
}
