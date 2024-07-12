package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ConfirmPaymentController {

    @FXML
    private Button ButtonHome;

    @FXML
    private BorderPane mainPane;

    @FXML
    void initialize() {
        // Handle toHome
        ButtonHome.setOnAction(event -> {
            switchToHomeScene();
        });
    }

    private void switchToHomeScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLHome.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            } catch (IOException e) {
            e.printStackTrace();
            }
    }
}
