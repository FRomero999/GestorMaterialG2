package org.example.gestormaterialg2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField txtDisponible;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCategoria;

    /**
     * Comprueba que los textField (todos) no esten vacios.
     * Si esta todo bien, muestra una alerta con el contenido del nombre y se borran los textos
     * Si alguno esta vacio, no hace nada
     * @param actionEvent
     */
    @FXML
    public void guardar(ActionEvent actionEvent) {
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtCategoria.getText().isEmpty() || txtDisponible.getText().isEmpty()) {
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Material guardado");
        alert.setHeaderText(null);
        alert.setContentText("Nombre: " + txtNombre.getText());
        alert.showAndWait();

        txtId.clear();
        txtNombre.clear();
        txtCategoria.clear();
        txtDisponible.clear();
    }

    /**
     *  Sale de la aplicación (de la forma mas sencilla)
     */
    @FXML
    public void volver(ActionEvent actionEvent) {
        Platform.exit();
    }
}
