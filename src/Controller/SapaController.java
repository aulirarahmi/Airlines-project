package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SapaController {

    @FXML
    private Button NextToConversation;

    @FXML
    private Button SkipToHomePage;

    @FXML
    private BorderPane mainPane;

    @FXML
    void initialize() {
        // Handle lanjut ke halaman dialog  
        NextToConversation.setOnAction(event -> {
            switchToConversationScene();
        });

        // Handle skip ke halaman home
        SkipToHomePage.setOnAction(event -> {
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

    private void switchToConversationScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Conversation_1.fxml"));
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
