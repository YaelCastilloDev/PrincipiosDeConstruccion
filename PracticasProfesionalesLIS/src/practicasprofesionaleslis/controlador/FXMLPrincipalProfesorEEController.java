package practicasprofesionaleslis.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import practicasprofesionaleslis.modelo.pojo.ProfesorEE;
import practicasprofesionaleslis.utilidades.UtilidadesVentanas;

public class FXMLPrincipalProfesorEEController implements Initializable {
    private ProfesorEE profesorEE;

    @FXML
    private ImageView imgFotoPerfil;
    @FXML
    private Label lblNombreProfesorEE;
    @FXML
    private Label lblCorreoElectronico;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void inicializarDatosProfesorEE(ProfesorEE profesorEE) {
        this.profesorEE = profesorEE;
        if (profesorEE != null) {
            lblNombreProfesorEE.setText(profesorEE.toString());
            lblCorreoElectronico.setText(profesorEE.getCorreoInstitucional());
        }
    }

    @FXML
    private void clicBtnCerrarSesion(ActionEvent event) {
        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        String titulo = "CERRAR SESIÓN";
        String contenido = "¿Estás seguro que deseas cerrar sesión?";

        if (UtilidadesVentanas.mostrarAlertaSimple(tipo, titulo, contenido).get() == ButtonType.OK) {
            UtilidadesVentanas.irInicioSesion(lblNombreProfesorEE);
        }
    }

    @FXML
    private void clicBtnConsultarExpedienteEstudiante(ActionEvent event) {
    }

    @FXML
    private void clicBtnValidarEntregaDocumentos(ActionEvent event) {
    }
    
}
