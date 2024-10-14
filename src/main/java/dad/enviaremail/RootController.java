package dad.enviaremail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
        try {
            Email email = new SimpleEmail();
            email.setHostName(nombreIPTextField.getText());
            email.setSmtpPort(Integer.parseInt(puertoTextField.getText()));
            email.setAuthenticator(new DefaultAuthenticator(remitenteTextField.getText(), contraseñaPassField.getText()));
            email.setSSLOnConnect(smtpCheckBox.isSelected());
            email.setFrom(remitenteTextField.getText());
            email.setSubject(asuntoTextField.getText());
            email.setMsg(MensajeTextArea.getText());
            email.addTo(emailTextField.getText());
            email.send();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje enviado");
            alert.setHeaderText("Mensaje enviado con éxito a " + emailTextField.getText());
            alert.showAndWait();
        } catch (EmailException e) {
            System.out.println("No se ha podido enviar el email");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo enviar el email");
            alert.setContentText("Invalid message supplied");
            alert.showAndWait();
        }
    }

    @FXML
    private CheckBox smtpCheckBox;

    @FXML
    void onVaciarAction(ActionEvent event) {
        MensajeTextArea.setText("");
        asuntoTextField.setText("");
        contraseñaPassField.setText("");
        emailTextField.setText("");
        nombreIPTextField.setText("");
        puertoTextField.setText("");
        remitenteTextField.setText("");
        smtpCheckBox.setSelected(false);
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }
}
