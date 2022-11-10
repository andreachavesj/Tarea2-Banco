package Vista;

import Controlador.CuentaControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MostrarSaldo {
    @FXML Button btnSaldo;
    @FXML TextField txtId;
    @FXML TextField txtNumeroCuenta;
    @FXML Button btnRegresar;

    public void verSaldo() throws Exception {
        String cedula=txtId.getText();
        int cuenta = Integer.valueOf(txtNumeroCuenta.getText());
        if(CuentaControlador.verificarCliente(cedula, cuenta)==true && ValidarCampos()==true){
            double saldo = CuentaControlador.mostrarSaldo(cedula, cuenta);
            mensajeExitoso(saldo);
        }else{
            mensajeError();
        }
    }
    public boolean ValidarCampos(){
        boolean completo=true;
        if((txtId==null)||(txtNumeroCuenta==null)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a espacios en blanco");
            alert.showAndWait();
            return completo=false;
        }else{
            return completo=true;
        }
    }
    public void mensajeExitoso(double saldo){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Exito");
        alert.setContentText("El saldo de su cuenta es: "+ saldo);
        alert.showAndWait();
    }
    public void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("La cédula ingresada no ha sido registrada");
        alert.showAndWait();
    }
    public void IrMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("Menu.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
