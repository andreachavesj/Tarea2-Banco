package Vista;

import Controlador.ClienteControlador;
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

public class CuentaCorriente {
    @FXML
    TextField txtId;
    @FXML TextField txtDeposito;
    @FXML
    Button btnRegistrar;
    @FXML Button btnRegresar;

    /**
     * Funcion que permite crear una cuenta corriente si cumple con las validaciones de verificar cedula y
     * validar campos y mostrar mensjaje de exito y limpiar campos
     * @throws Exception
     */
    public void guardarCuenta() throws Exception {
        String cedula=txtId.getText();
        Double deposito= Double.valueOf(txtDeposito.getText());
        if(CuentaControlador.verificarCedula(cedula)==true && ValidarCampos(cedula, deposito)==true){
            int numeroCuenta = CuentaControlador.registrarCuentaCorriente(cedula, deposito);
            mensajeExitoso(numeroCuenta);
            System.out.println(CuentaControlador.conjuntoCuentasCorrientes.toString());
            limpiarCampos();
        }else{
            mensajeError();
        }
    }

    /**
     * Funcion que permite validar los campos que no esten vacios y el deposito sea mayor a 50 mil
     * @param cedula
     * @param deposito
     * @return boolean
     */
    public boolean ValidarCampos( String cedula, Double deposito){
        boolean completo=true;
        if(cedula.isEmpty()){
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
     * Funcion que muestra un mensaje exitoso cuando se registra
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
     * Funcion que muestra un mensaje de error en caso de que no se registre
     */
    public void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Ocurrio un error, verifique los datos ingresados");
        alert.showAndWait();
    }

    /**
     * Funcion que pemite ir a la ventana de crear cuenta mediante un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrCrearCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCuenta.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Funcion que limpia los campos despues de registarse
     */
    public void limpiarCampos(){
        txtId.setText("");
        txtDeposito.setText("");
    }
}
