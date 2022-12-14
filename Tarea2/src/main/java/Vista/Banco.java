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

public class Banco {
    @FXML
    Button crearCliente;
    @FXML Button listarClientes;
    @FXML Button crearCuenta;

    @FXML Button accederCuenta;

    @FXML Button mostrarSaldo;

    /**
     * Funcion que permite ir a la ventana de crear cliente mediante un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrCrearCliente(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCliente.fxml")));
        Stage window = (Stage) crearCliente.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Funcion que permite ir a la ventana de listar cliente mediante un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrListarClientes(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("ListarClientes.fxml")));
        Stage window = (Stage) listarClientes.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Funcion que permite ir a la ventana de crear cuenta mediante un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrCrearCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("CrearCuenta.fxml")));
        Stage window = (Stage) crearCuenta.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Funcion que permite ir a la ventana de acceder cuenta mediante un boton que permite realizar depositos y retiros
     * @param actionEvent
     * @throws IOException
     */
    public void IrAccederCuenta(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("AccederCuenta.fxml")));
        Stage window = (Stage) accederCuenta.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Funcion que permite ir a la ventana de mostrar saldo mediante un boton
     * @param actionEvent
     * @throws IOException
     */
    public void IrMostrarSaldo(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(InicioBanco.class.getResource("MostrarSaldo.fxml")));
        Stage window = (Stage) mostrarSaldo.getScene().getWindow();
        window.setScene(new Scene(root));
    }


}
