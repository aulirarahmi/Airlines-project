package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Conversation_4 {

    @FXML
    private Button NextToHome;

    @FXML
    private Button SkipToHomePage;

    @FXML
    private BorderPane mainPane;

    @FXML
    void initialize() {
        // Handle lanjut ke halaman home  
        NextToHome.setOnAction(event -> {
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
