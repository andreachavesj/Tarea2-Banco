package Vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MovimientosCuenta {
    @FXML
    Button btnRegresar;

    @FXML Button btnRetiro;
    @FXML Button btnDeposito;
    public void IrRetiro(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("Retiro.fxml")));
        Stage window = (Stage) btnRetiro.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void IrDeposito(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("Deposito.fxml")));
        Stage window = (Stage) btnDeposito.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void IrMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("Menu.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
