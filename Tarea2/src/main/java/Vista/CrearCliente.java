package Vista;

import Controlador.ClienteControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class CrearCliente {
    @FXML TextField txtNombre;
    @FXML TextField txtCedula;
    @FXML TextField txtDireccion;
    @FXML Button btnRegresar;
    @FXML Button btnRegistrar;

    public void guardarDatos() throws Exception {
        String nombre=txtNombre.getText();
        String cedula=txtCedula.getText();
        String direccion= txtDireccion.getText();
        if(ClienteControlador.registrarCliente(nombre,cedula, direccion)==true && ValidarCampos(nombre, cedula, direccion)==true){
            ClienteControlador.registrarCliente(nombre,cedula,direccion);
            mensajeExitoso();
        }else{
            mensajeCedulaExistente();
        }

        }

    public boolean ValidarCampos( String nombre, String identificacion, String direccion){
        boolean completo=true;
        if(nombre.isEmpty()|| identificacion.isEmpty() || direccion.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a espacios en blanco");
            alert.showAndWait();
            return completo=false;
        } else{
            limpiarCampos();
            return completo=true;

        }
    }

    public void mensajeCedulaExistente(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Ha ocurrido un erorr por espacios en blanco o cédula repetida");
        alert.showAndWait();
    }

    public void mensajeExitoso(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Exito");
        alert.setContentText("Su registro ha sido exitoso");
        alert.showAndWait();
    }
    public void IrMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("Menu.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void limpiarCampos(){
        txtNombre.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
    }

}



