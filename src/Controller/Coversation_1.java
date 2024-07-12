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

public class Coversation_1 {

    @FXML
    private Button NextToConversation_2;

    @FXML
    private Button SkipToHomePage;

    @FXML
    private BorderPane mainPane;

    @FXML
    void initialize() {
        // Handle lanjut ke halaman dialog2  
        NextToConversation_2.setOnAction(event -> {
            switchToConversation_2_Scene();
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

    private void switchToConversation_2_Scene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Conversation_2.fxml"));
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