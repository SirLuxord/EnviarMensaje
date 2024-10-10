package dad.enviaremail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnviarMensajeApp extends Application {
    private final RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.setTitle("Enviar Email");
        primaryStage.show();
    }

}
