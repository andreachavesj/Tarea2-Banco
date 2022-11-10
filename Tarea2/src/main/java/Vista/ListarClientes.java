package Vista;

import Controlador.ClienteControlador;
import Modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class ListarClientes {
    @FXML
    Label labelClientes;
    @FXML
    TextArea txtClientes;
    @FXML
    Button btnRegresar;
    @FXML Button btnMostrar;

    public void IrMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("Menu.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void listarClientes(ActionEvent actionEvent) {
        txtClientes.setText(ClienteControlador.conjuntoClientes.toString());
    }
}
