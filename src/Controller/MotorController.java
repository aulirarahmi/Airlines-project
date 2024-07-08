package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MotorController {

    @FXML
    private ImageView BackToHome;

    @FXML
    private Button ButtonMotorIT18;

    @FXML
    private Button ButtonMotorIT20;

    @FXML
    private Button ButtonMotorIT23;

    @FXML
    private Pane PaneMotorIT18;

    @FXML
    private Pane PaneMotorIT20;

    @FXML
    private Pane PaneMotorIT23;

    @FXML
    private void initialize() {
        BackToHome.setOnMouseClicked(event -> navigateTo("/View/FXMLhome.fxml"));
        PaneMotorIT20.setOnMouseClicked(event -> navigateTo("/View/FXMLPemesananMotor.fxml"));
        ButtonMotorIT20.setOnAction(event -> navigateTo("/View/FXMLPemesananMotor.fxml"));
       
    }

    private void navigateTo(String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) BackToHome.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
