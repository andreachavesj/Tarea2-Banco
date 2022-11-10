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

public class CuentaAhorroProgramado {
    @FXML
    TextField txtCedula;
    @FXML TextField txtCorriente;
    @FXML TextField txtMonto;
    @FXML
    Button btnRegresar;
    @FXML Button btnRegistrar;

    public void guardarCuenta() throws Exception {
        String cedula=txtCedula.getText();
        int cuentaCorriente = Integer.valueOf(txtCorriente.getText());
        Double deposito= Double.valueOf(txtMonto.getText());
        if(CuentaControlador.verificarCliente(cedula, cuentaCorriente)==true && ValidarCampos(cedula, cuentaCorriente, deposito)==true){
            int numeroCuentaProgramado = CuentaControlador.registrarCuentaAhorroProgramado(cedula, deposito, cuentaCorriente);
            mensajeExitoso(numeroCuentaProgramado);
        }else{
            mensajeError();
        }
    }
    public boolean ValidarCampos( String cedula, int cuentaAsociada, double monto){
        boolean completo=true;
        if(cedula.isEmpty()){
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
    public void mensajeExitoso(int cuenta){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Exito");
        alert.setContentText("Su registro ha sido exitoso, su numero de cuenta es: "+ cuenta);
        alert.showAndWait();
    }
    public void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("La cédula ingresada no ha sido registrada");
        alert.showAndWait();
    }
    public void IrCrearCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCuenta.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
