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

public class Deposito {
    @FXML
    Button btnRegresar;
    @FXML Button btnDepositar;
    @FXML TextField txtCedula;
    @FXML TextField txtCuenta;
    @FXML TextField txtMonto;


    public void realizarDeposito() throws Exception {
        String cedula=txtCedula.getText();
        int cuenta = Integer.valueOf(txtCuenta.getText());
        double deposito= Double.valueOf(txtMonto.getText());
        if(CuentaControlador.verificarCliente(cedula, cuenta)==true && ValidarCampos(cedula, deposito)==true){
            CuentaControlador.depositar(cedula, cuenta, deposito);
            System.out.println(CuentaControlador.conjuntoCuentasCorrientes.toString());
        }else{
            mensajeError();
        }
    }
    public boolean ValidarCampos(String cedula, double deposito){
        boolean completo=true;
        if((cedula.isEmpty())||(txtCuenta==null)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a espacios en blanco");
            alert.showAndWait();
            return completo=false;
        }else if(deposito<=0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a deposito insuficiente");
            alert.showAndWait();
            return completo=false;
        }else{
            return completo=true;
        }
    }
    public static void mensajeExitoso(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Exito");
        alert.setContentText("Deposito realizado con éxito");
        alert.showAndWait();
    }
    public static void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Ha ocurrido un error, porfavor ingrese datos válidos");
        alert.showAndWait();
    }
    public void IrAccederCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("AccederCuenta.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
