package practicasprofesionaleslis.utilidades;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Utilidades {
    public static Optional<ButtonType> mostrarAlertaSimple(Alert.AlertType tipo,
            String titulo, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        return alerta.showAndWait();
    }
}
