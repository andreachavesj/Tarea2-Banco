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

public class Retiro {
    @FXML
    Button btnRegresar;
    @FXML Button btnDepositar;
    @FXML
    TextField txtCedula;
    @FXML TextField txtCuenta;
    @FXML TextField txtMonto;


    /**
     * Funcion que permite realizar un retiro si se cumplen las validaciones de verificar cliente y validar campos
     * y mostrar mensaje de exito, si no uno de error
     * @throws Exception
     */
    public void realizarRetiro() throws Exception {
        String cedula=txtCedula.getText();
        int cuenta = Integer.valueOf(txtCuenta.getText());
        double retiro= Double.valueOf(txtMonto.getText());
        if(CuentaControlador.verificarCliente(cedula, cuenta)==true && ValidarCampos(cedula, retiro)==true){
            CuentaControlador.retirar(cedula, cuenta, retiro);
            System.out.println(CuentaControlador.conjuntoCuentasCorrientes.toString());
        }else{
            mensajeError();
        }
    }

    /**
     * Funcion que permite validar campos que no esten vacios y el retiro sea mayor o igual a 0
     * @param cedula
     * @param retiro
     * @return
     */
    public boolean ValidarCampos(String cedula, double retiro){
        boolean completo=true;
        if((cedula.isEmpty())||(txtCuenta==null)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error debido a espacios en blanco");
            alert.showAndWait();
            return completo=false;
        }else if(retiro<=0){
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

    /**
     * Funcion que muestra un mensaje de exito
     */
    public static void mensajeExitoso(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Exito");
        alert.setContentText("Retiro realizado con éxito");
        alert.showAndWait();
    }

    /**
     * Funcion que muestra mensaje de error
     */
    public static void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Ha ocurrido un error, porfavor ingrese datos válidos");
        alert.showAndWait();
    }

    /**
     * Funcion que permite ir a la ventana de acceder cuenta por medio de un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrAccederCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("AccederCuenta.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
