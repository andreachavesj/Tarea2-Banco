package Vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CrearCuenta {
    @FXML
    Button btnCorriente;
    @FXML Button btnRegresar;
    @FXML Button btnAhorroP;


    public void IrMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("Menu.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void IrCrearCuentaCorriente(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCuentaCorriente.fxml")));
        Stage window = (Stage) btnCorriente.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void IrCrearCuentaAhorroP(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCuentaAhorroProgramado.fxml")));
        Stage window = (Stage) btnAhorroP.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
