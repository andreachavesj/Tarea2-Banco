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

public class CuentaAhorro {
@FXML
    TextField txtCedula;
@FXML TextField txtDeposito;
@FXML TextField txtInteres;
@FXML Button btnRegresar;
@FXML Button btnRegistrar;

    /**
     * Funcion que permite crear y guardar una nueva cuenta de ahorro cumpliendo con todas las validaciones necesarias
     * como el de verificar que la cedula si exista y no haya espacios en blanco y el deposito sea mayor a 50 mil
     * @throws Exception
     */
    public void guardarCuenta() throws Exception {
        String cedula=txtCedula.getText();
        Double deposito= Double.valueOf(txtDeposito.getText());
        Double interes= Double.valueOf(txtInteres.getText());

        if(CuentaControlador.verificarCedula(cedula)==true && ValidarCampos(deposito)==true){
            int numeroCuenta = CuentaControlador.registrarCuentaAhorro(cedula, deposito, interes);
            mensajeExitoso(numeroCuenta);
            System.out.println(CuentaControlador.conjuntoCuentasAhorro.toString());
            limpiarCampos();
        }else{
            mensajeError();
        }
    }

    /**
     * Funcion que permite validar que los espacios no esten en blanco y el deposito sea mayor o igual a 50 mil
     * @param deposito
     * @return
     */
    public boolean ValidarCampos(double deposito){
        boolean completo=true;
        if((txtCedula==null)||(txtDeposito==null)||(txtInteres==null)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a espacios en blanco");
            alert.showAndWait();
            return completo=false;
        }else if(deposito< 50000){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a deposito inicial insuficiente");
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
     * Funcion que muestra un mensaje de error en caso de que alguna validacion no se cumpla
     */
    public void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Existe un error, verifique los datos");
        alert.showAndWait();
    }

    /**
     * Funcion que permite ir a la ventana de crear cuenta por medio de un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrCrearCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCuenta.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Funcion que permite limpiar los campos despues de realizar el registro
     */
    public void limpiarCampos(){
        txtCedula.setText("");
        txtInteres.setText("");
        txtDeposito.setText("");
    }
}
