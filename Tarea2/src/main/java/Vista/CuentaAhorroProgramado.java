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


    /**
     * Funcion que permite crear una cuenta de ahorro programada si logra cumplir con las validaciones
     * de verificar cliente y validar campos y si es asi crea la cuenta y muestra mensaje de exito y sino de error
     * @throws Exception
     */
    public void guardarCuenta() throws Exception {
        String cedula=txtCedula.getText();
        int cuentaCorriente = Integer.valueOf(txtCorriente.getText());
        Double deposito= Double.valueOf(txtMonto.getText());
        if(CuentaControlador.verificarCliente(cedula, cuentaCorriente)==true && ValidarCampos(cedula, cuentaCorriente, deposito)==true){
            int numeroCuentaProgramado = CuentaControlador.registrarCuentaAhorroProgramado(cedula, deposito, cuentaCorriente);
            mensajeExitoso(numeroCuentaProgramado);
            limpiarCampos();
        }else{
            mensajeError();
        }
    }

    /**
     * Funcion que permite validar que los campos no esten vacios y el monto sea mayor a 0
     * @param cedula
     * @param cuentaAsociada
     * @param monto
     * @return
     */
    public boolean ValidarCampos( String cedula, int cuentaAsociada, double monto){
        boolean completo=true;
        if(cedula.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a espacios en blanco");
            alert.showAndWait();
            return completo=false;
        }else if(monto< 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a monto a debitar no suficiente");
            alert.showAndWait();
            return completo=false;
        }else{
            return completo=true;
        }
    }

    /**
     * Funcion que muestra un mensaje de exito en caso de realizar el registro
     * @param cuenta
     */
    public void mensajeExitoso(int cuenta){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Exito");
        alert.setContentText("Su registro ha sido exitoso, su numero de cuenta es: "+ cuenta);
        alert.showAndWait();
    }

    /**
     * Funcion que muestra un mensaje en caso de error
     */
    public void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Ha ocurrido un error, verifique sus datos");
        alert.showAndWait();
    }

    /**
     * Funcion que permite ir a la ventana de crear cuenta mediante un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrCrearCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCuenta.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void limpiarCampos(){
        txtCedula.setText("");
        txtMonto.setText("");
        txtCorriente.setText("");
    }
}
