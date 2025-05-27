package practicasprofesionaleslis.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import practicasprofesionaleslis.PracticasProfesionalesLIS;
import practicasprofesionaleslis.modelo.dao.ExpedienteDAO;
import practicasprofesionaleslis.modelo.dao.InicioSesionDAO;
import practicasprofesionaleslis.modelo.pojo.Coordinador;
import practicasprofesionaleslis.modelo.pojo.Estudiante;
import practicasprofesionaleslis.modelo.pojo.Evaluador;
import practicasprofesionaleslis.modelo.pojo.ProfesorEE;
import practicasprofesionaleslis.utilidades.Utilidades;

public class FXMLInicioSesionController implements Initializable {
    @FXML
    private TextField txtfUsuario;
    @FXML
    private PasswordField pwdfPassword;
    @FXML
    private Label lblErrorUsuario;
    @FXML
    private Label lblErrorPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
    @FXML
    public void clicBtnVerificarSesion(ActionEvent event) {
        String usuario = txtfUsuario.getText();
        String contraseña = pwdfPassword.getText();
        int tipoUsuario = determinarTipoUsuario(usuario);
        
        if (validarCampos(usuario, contraseña)) {
            switch (tipoUsuario) {
                case 1: validarCredencialesEstudiante(usuario, contraseña); break;
                case 2: validarCredencialesCoordinador(usuario, contraseña); break;
                case 3: validarCredencialesProfesorEE(usuario, contraseña); break;
                case 4: validarCredencialesEvaluador(usuario, contraseña); break;
                default: Utilidades.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "USUARIO NO VÁLIDO",
                        "Tipo de usuario no válido. Verifique sus credenciales.");
            }
        }
    }
    
    private boolean validarCampos(String usuario, String contraseña) {
        boolean camposValidos = true;
        lblErrorUsuario.setText("");
        lblErrorPassword.setText("");
        
        if (usuario.isEmpty()) {
            lblErrorUsuario.setText("Usuario obligatorio");
            camposValidos = false;
        }
        if (contraseña.isEmpty()) {
            lblErrorPassword.setText("Contraseña obligatoria");
            camposValidos = false;
        }
        return camposValidos;
    }
    
    private int determinarTipoUsuario(String usuario) {
        if (usuario.startsWith("S")) {
            return 1;
        } else if (usuario.startsWith("C")) {
            return 2;
        } else if (usuario.startsWith("P")) {
            return 3;
        } else if (usuario.startsWith("E")) {
            return 4;
        }
        return 0;
    }
    
    private void validarCredencialesEstudiante(String usuario, String contraseña) {
        try {
            Estudiante estudiante = InicioSesionDAO.verificarCredencialesEstudiante(usuario, contraseña);
            
            if (estudiante != null) {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + estudiante.toString() + " al sistema.");
                String nombreProyecto = ExpedienteDAO.obtenerNombreProyectoPorMatricula(estudiante.getMatricula());
                irPantallaPrincipalEstudiante(estudiante, nombreProyecto);
            } else {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            Utilidades.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "ERROR",
                    e.getMessage());
        }
    }
    
    private void validarCredencialesCoordinador(String usuario, String contraseña) {
        try {
            Coordinador coordinador = InicioSesionDAO.verificarCredencialesCoordinador(usuario, contraseña);
            
            if (coordinador != null) {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + coordinador.toString() + " al sistema.");
                irPantallaPrincipalCoordinador(coordinador);
            } else {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            Utilidades.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "ERROR",
                    e.getMessage());
        }
    }
    
    private void validarCredencialesProfesorEE(String usuario, String contraseña) {
        try {
            ProfesorEE profesorEE = InicioSesionDAO.verificarCredencialesProfesorEE(usuario, contraseña);
            
            if (profesorEE != null) {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + profesorEE.toString() + " al sistema.");
                irPantallaPrincipalProfesorEE(profesorEE);
            } else {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            Utilidades.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "ERROR",
                    e.getMessage());
        }
    }
    
    private void validarCredencialesEvaluador(String usuario, String contraseña) {
        try {
            Evaluador evaluador = InicioSesionDAO.verificarCredencialesEvaluador(usuario, contraseña);
            
            if (evaluador != null) {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + evaluador.toString() + " al sistema.");
                irPantallaPrincipalEvaluador(evaluador);
            } else {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            Utilidades.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "ERROR",
                    e.getMessage());
        }
    }
    
    private void irPantallaPrincipalEstudiante(Estudiante estudiante, String nombreProyecto) {
        try {
            Stage escenarioBase = (Stage) txtfUsuario.getScene().getWindow();
            FXMLLoader cargador = new FXMLLoader(PracticasProfesionalesLIS.class.getResource("/practicasprofesionaleslis/vista/FXMLPrincipalEstudiante.fxml"));
            Parent vista = cargador.load();
            FXMLPrincipalEstudianteController controlador = cargador.getController();
            controlador.inicializarDatosEstudiante(estudiante, nombreProyecto);
            
            Scene escenaPrincipal = new Scene(vista);
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("PANTALLA PRINCIPAL - ESTUDIANTE");
            escenarioBase.setResizable(false);
            escenarioBase.centerOnScreen();
            escenarioBase.showAndWait();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void irPantallaPrincipalCoordinador(Coordinador coordinador) {
        // TODO
    }
    
    private void irPantallaPrincipalProfesorEE(ProfesorEE profesorEE) {
        // TODO
    }
    
    private void irPantallaPrincipalEvaluador(Evaluador evaluador) {
        // TODO
    }
}
