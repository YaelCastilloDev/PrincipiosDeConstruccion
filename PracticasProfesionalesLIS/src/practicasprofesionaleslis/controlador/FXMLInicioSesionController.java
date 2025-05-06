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
import practicasprofesionaleslis.modelo.dao.InicioSesionDAO;
import practicasprofesionaleslis.modelo.pojo.Usuario;
import practicasprofesionaleslis.utilidades.Utilidades;

public class FXMLInicioSesionController implements Initializable {
    @FXML private Label lbErrorUsuario, lbErrorPassword;
    @FXML private TextField tfUsuario;
    @FXML private PasswordField tfPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
    public void btnVerificarSesion(ActionEvent event) {
        String username = tfUsuario.getText();
        String password = tfPassword.getText();
        if (validarCampos(username, password)) {
            validarCredenciales(username, password);
        }
    }
    
    private boolean validarCampos(String username, String password) {
        boolean camposValidos = true;
        lbErrorUsuario.setText("");
        lbErrorPassword.setText("");
        
        if (username.isEmpty()) {
            lbErrorUsuario.setText("Usuario obligatorio");
            camposValidos = false;
        }
        if (password.isEmpty()) {
            lbErrorPassword.setText("Contraseña obligatoria");
            camposValidos = false;
        }
        return camposValidos;
    }
    
    private void validarCredenciales(String username, String password) {
        try {
            Usuario usuarioSesion = InicioSesionDAO.verificarCredenciales(username, password);
            if (usuarioSesion != null) {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.INFORMATION,
                        "Credenciales correctas",
                        "Bienvenido(a) " + usuarioSesion.toString() + " al sistema.");
                irPantallaPrincipal(usuarioSesion);
            } else {
                Utilidades.mostrarAlertaSimple(Alert.AlertType.WARNING,
                        "Credenciales incorrectas",
                        "Usuario y/o contraseña incorrectos. Por favor, verifique las credenciales.");
            }
        } catch (SQLException e) {
            Utilidades.mostrarAlertaSimple(Alert.AlertType.ERROR,
                    "Problema de conexión",
                    "Error de conexión: " + e.getMessage());
        }
    }
    
    private void irPantallaPrincipal(Usuario usuario) {
        try {
            Stage escenarioBase = (Stage) tfUsuario.getScene().getWindow();
            Parent vista = FXMLLoader.load(getClass().getResource("/practicasprofesionaleslis/vista/FXMLPrincipalEstudiante.fxml"));
            Scene escenaPrincipal = new Scene(vista);
            
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("Pantalla Principal");
            escenarioBase.showAndWait();
            escenarioBase.centerOnScreen();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
