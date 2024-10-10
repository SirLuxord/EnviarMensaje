package dad.enviaremail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    public RootController() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextArea MensajeTextArea;

    @FXML
    private TextField asuntoTextField;

    @FXML
    private PasswordField contraseñaPassField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nombreIPTextField;

    @FXML
    private TextField puertoTextField;

    @FXML
    private TextField remitenteTextField;

    @FXML
    private GridPane root;

    @FXML
    void onCerrarAction(ActionEvent event) {

    }

    @FXML
    void onEnviarAction(ActionEvent event) {

    }

    @FXML
    void onServidorTrue(ActionEvent event) {

    }

    @FXML
    void onVaciarAction(ActionEvent event) {

    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }
}
