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
import practicasprofesionaleslis.utilidades.UtilidadesVentanas;
import practicasprofesionaleslis.utilidades.ValidadorID;

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
        String usuario = txtfUsuario.getText().trim();
        String contraseña = pwdfPassword.getText();
        
        if (validarCampos(usuario, contraseña)) {
            int tipoUsuario = determinarTipoUsuario(usuario);
            
            if (!validarFormatoID(usuario, tipoUsuario)) {
                return;
            }
            
            switch (tipoUsuario) {
                case 1: validarCredencialesEstudiante(usuario, contraseña); break;
                case 2: validarCredencialesCoordinador(usuario, contraseña); break;
                case 3: validarCredencialesProfesorEE(usuario, contraseña); break;
                case 4: validarCredencialesEvaluador(usuario, contraseña); break;
                default: UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "FORMATO DE USUARIO NO VÁLIDO",
                        "El formato del ID de usuario no es válido.");
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
    
    private boolean validarFormatoID(String usuario, int tipoUsuario) {
        boolean formatoValido = false;
        String mensajeError = "";
        
        switch (tipoUsuario) {
            case 1:
                formatoValido = ValidadorID.validarIDEstudiante(usuario);
                mensajeError = "Formato de matrícula del estudiante inválido.";
                break;
            case 2:
                formatoValido = ValidadorID.validarIDCoordinador(usuario);
                mensajeError = "Formato de número de personal del coordinador inválido.";
                break;
            case 3:
                formatoValido = ValidadorID.validarIDProfesor(usuario);
                mensajeError = "Formato de número de personal del profesor inválido.";
                break;
            case 4: 
                formatoValido = ValidadorID.validarIDEvaluador(usuario);
                mensajeError = "Formato de número de personal del evaluador inválido.";
                break;
            default: mensajeError = "Formato de usuario no reconocido.";
        }
        
        if (!formatoValido) {
            UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.WARNING,
                    "FORMATO INCORRECTO",
                    mensajeError);
        }
        return formatoValido;
    }
    
    private int determinarTipoUsuario(String usuario) {
        if (usuario.isEmpty()) {
            return 0;
        }
        
        char primerCaracter = usuario.charAt(0);
        switch (primerCaracter) {
            case 'S': return 1;
            case 'C': return 2;
            case 'P': return 3;
            case 'E': return 4;
            default: return 0;
        }
    }
    
    private void validarCredencialesEstudiante(String usuario, String contraseña) {
        try {
            Estudiante estudiante = InicioSesionDAO.verificarCredencialesEstudiante(usuario, contraseña);
            
            if (estudiante != null) {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + estudiante.toString() + " al sistema.");
                String nombreProyecto = ExpedienteDAO.obtenerNombreProyectoPorMatricula(estudiante.getMatricula());
                irPantallaPrincipalEstudiante(estudiante, nombreProyecto);
            } else {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "ERROR",
                    e.getMessage());
        }
    }
    
    private void validarCredencialesCoordinador(String usuario, String contraseña) {
        try {
            Coordinador coordinador = InicioSesionDAO.verificarCredencialesCoordinador(usuario, contraseña);
            
            if (coordinador != null) {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + coordinador.toString() + " al sistema.");
                irPantallaPrincipalCoordinador(coordinador);
            } else {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "ERROR",
                    e.getMessage());
        }
    }
    
    private void validarCredencialesProfesorEE(String usuario, String contraseña) {
        try {
            ProfesorEE profesorEE = InicioSesionDAO.verificarCredencialesProfesorEE(usuario, contraseña);
            
            if (profesorEE != null) {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + profesorEE.toString() + " al sistema.");
                irPantallaPrincipalProfesorEE(profesorEE);
            } else {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "ERROR",
                    e.getMessage());
        }
    }
    
    private void validarCredencialesEvaluador(String usuario, String contraseña) {
        try {
            Evaluador evaluador = InicioSesionDAO.verificarCredencialesEvaluador(usuario, contraseña);
            
            if (evaluador != null) {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "CREDENCIALES CORRECTAS",
                        "Bienvenido(a) " + evaluador.toString() + " al sistema.");
                irPantallaPrincipalEvaluador(evaluador);
            } else {
                UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "CREDENCIALES INCORRECTAS",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            UtilidadesVentanas.mostrarAlertaSimple(Alert.AlertType.ERROR,
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
        try {
            Stage escenarioBase = (Stage) txtfUsuario.getScene().getWindow();
            FXMLLoader cargador = new FXMLLoader(PracticasProfesionalesLIS.class.getResource("/practicasprofesionaleslis/vista/FXMLPrincipalCoordinador.fxml"));
            Parent vista = cargador.load();
            FXMLPrincipalCoordinadorController controlador = cargador.getController();
            controlador.inicializarDatosCoordinador(coordinador);
            
            Scene escenaPrincipal = new Scene(vista);
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("PANTALLA PRINCIPAL - COORDINADOR");
            escenarioBase.setResizable(false);
            escenarioBase.centerOnScreen();
            escenarioBase.showAndWait();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void irPantallaPrincipalProfesorEE(ProfesorEE profesorEE) {
        try {
            Stage escenarioBase = (Stage) txtfUsuario.getScene().getWindow();
            FXMLLoader cargador = new FXMLLoader(PracticasProfesionalesLIS.class.getResource("/practicasprofesionaleslis/vista/FXMLPrincipalProfesorEE.fxml"));
            Parent vista = cargador.load();
            FXMLPrincipalProfesorEEController controlador = cargador.getController();
            controlador.inicializarDatosProfesorEE(profesorEE);
            
            Scene escenaPrincipal = new Scene(vista);
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("PANTALLA PRINCIPAL - PROFESOR EE");
            escenarioBase.setResizable(false);
            escenarioBase.centerOnScreen();
            escenarioBase.showAndWait();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void irPantallaPrincipalEvaluador(Evaluador evaluador) {
        // TODO
    }
}
