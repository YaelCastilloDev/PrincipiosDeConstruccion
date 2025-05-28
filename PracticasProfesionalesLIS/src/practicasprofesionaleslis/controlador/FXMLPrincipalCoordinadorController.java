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
import practicasprofesionaleslis.modelo.pojo.Coordinador;
import practicasprofesionaleslis.utilidades.UtilidadesVentanas;

public class FXMLPrincipalCoordinadorController implements Initializable {
    private Coordinador coordinador;

    @FXML
    private ImageView imgFotoPerfil;
    @FXML
    private Label lblNombreCoordinador;
    @FXML
    private Label lblCorreoInstitucional;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void inicializarDatosCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
        if (coordinador != null) {
            lblNombreCoordinador.setText(coordinador.toString());
            lblCorreoInstitucional.setText(coordinador.getCorreoInstitucional());
        }
    }

    @FXML
    private void clicBtnCerrarSesion(ActionEvent event) {
        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        String titulo = "CERRAR SESIÓN";
        String contenido = "¿Estás seguro que deseas cerrar sesión?";

        if (UtilidadesVentanas.mostrarAlertaSimple(tipo, titulo, contenido).get() == ButtonType.OK) {
            UtilidadesVentanas.irInicioSesion(lblNombreCoordinador);
        }
    }

    @FXML
    private void clicBtnRegistrarResponsableProyecto(ActionEvent event) {
    }

    @FXML
    private void clicBtnRegistrarOrganizacionVinculada(ActionEvent event) {
    }

    @FXML
    private void clicBtnGenerarDoctosAsignacion(ActionEvent event) {
    }

    @FXML
    private void clicBtnRegistrarProyecto(ActionEvent event) {
    }

    @FXML
    private void clicBtnActualizarProyecto(ActionEvent event) {
    }

    @FXML
    private void clicBtnAsignarProyecto(ActionEvent event) {
    }

    @FXML
    private void clicBtnActualizarOrganizacionVinculada(ActionEvent event) {
    }

    @FXML
    private void clicBtnActualizarResponsableProyecto(ActionEvent event) {
    }

    @FXML
    private void clicBtnProgramarEntregasPracticas(ActionEvent event) {
    }
    
}
