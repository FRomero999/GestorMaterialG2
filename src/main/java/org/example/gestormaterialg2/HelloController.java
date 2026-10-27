package org.example.gestormaterialg2;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 * Controlador de la vista principal de la aplicación.
 * <p>
 * Gestiona el formulario de alta de material (nombre, identificador, categoría y
 * disponibilidad), así como la inicialización de los controles y las acciones
 * asociadas a los botones de la interfaz.
 */
public class HelloController implements Initializable {

    /**
     * Etiqueta de bienvenida de la vista.
     */
    @FXML
    private Label welcomeText;

    /**
     * Campo de texto donde se introduce el nombre del material.
     */
    @FXML
    private TextField txtNombre;

    /**
     * Grupo que agrupa los botones de disponibilidad.
     */
    @FXML
    private ToggleGroup disponibilidad;

    /**
     * Botón para marcar el material como no disponible.
     */
    @FXML
    private ToggleButton btnNoDisponible;

    /**
     * Botón para marcar el material como disponible.
     */
    @FXML
    private ToggleButton btnDisponible;

    /**
     * Selector numérico del identificador del material.
     */
    @FXML
    private Spinner<Integer> spinnerId;

    /**
     * Casilla que indica si el material está disponible.
     */
    @FXML
    private CheckBox checkDisponible;

    /**
     * Selector de la categoría del material.
     */
    @FXML
    private ChoiceBox<String> choiceCategory;

    /**
     * Lista de elementos mostrada en la vista.
     */
    @FXML
    private ListView<String> lista;

    /**
     * Inicializa el controlador después de que su elemento raíz haya sido
     * completamente procesado.
     * <p>
     * Configura el {@code Spinner} de identificadores, comparte la misma lista
     * observable entre el {@code ChoiceBox} y el {@code ListView}, y carga y
     * ordena los valores iniciales de las categorías.
     *
     * @param location  ubicación utilizada para resolver rutas relativas del
     *                  objeto raíz, o {@code null} si no se conoce
     * @param resources recursos utilizados para localizar el objeto raíz, o
     *                  {@code null} si no se localizó
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Spinner --> ValueFactory
        spinnerId.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1));
        spinnerId.getValueFactory().setValue(50);

        // Choice     \
        // TableView   |--> items : ObservableList --> selectionModel
        // ListView   /
        ObservableList<String> datos = FXCollections.observableArrayList();
        choiceCategory.setItems(datos);
        lista.setItems(datos);

        datos.addAll("Cart", "VideoGame", "Console", "CD");
        datos.add("Remote");
        datos.sort(Comparator.naturalOrder());

        choiceCategory.getItems().add("Laptop");
        choiceCategory.getItems().add("Tablet");
        choiceCategory.getItems().add("Desktop");
        choiceCategory.getItems().addAll("Printer", "Keyboard", "Gamepad");
        choiceCategory.getItems().set(2, "Hola");

        choiceCategory.getSelectionModel().selectFirst();
    }

    /**
     * Comprueba que el campo de texto del nombre no esté vacío y, si es así,
     * muestra una alerta con el contenido del formulario y limpia el nombre.
     * <p>
     * Si el nombre está vacío, el método no realiza ninguna acción.
     *
     * @param actionEvent evento de acción que dispara el guardado
     */
    @FXML
    public void guardar(ActionEvent actionEvent) {
        if (txtNombre.getText().isEmpty()) {
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Material guardado");
        alert.setHeaderText(null);
        alert.setContentText(
                "Nombre: " + txtNombre.getText()
                        + "\nId: " + spinnerId.getValueFactory().getValue()
                        + "\nCategoria: " + choiceCategory.getSelectionModel().getSelectedItem()
                        + "\nDisponible: " + (checkDisponible.isSelected() ? "Si" : "No"));
        alert.showAndWait();

        txtNombre.clear();
    }

    /**
     * Cierra la aplicación de la forma más sencilla.
     *
     * @param actionEvent evento de acción que dispara el cierre
     */
    @FXML
    public void volver(ActionEvent actionEvent) {
        Platform.exit();
    }
}
