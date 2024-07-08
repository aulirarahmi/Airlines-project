package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MobilController {

    @FXML
    private ImageView BackToHome;

    @FXML
    private Button ButtonMobilBX57;

    @FXML
    private Button ButtonMobilBX67;

    @FXML
    private Button ButtonMobilBX77;

    @FXML
    private Pane PaneMobilBX57;

    @FXML
    private Pane PaneMobilBX67;

    @FXML
    private Pane PaneMobilBX77;

    @FXML
    public void initialize() {
        
        BackToHome.setOnMouseClicked(event -> navigateTo("/View/FXMLhome.fxml"));
        PaneMobilBX57.setOnMouseClicked(event -> navigateTo("/View/FXMLPemesananMobil1.fxml"));
        PaneMobilBX67.setOnMouseClicked(event -> navigateTo("/View/FXMLPemesananMobil2.fxml"));
        PaneMobilBX77.setOnMouseClicked(event -> navigateTo("/View/FXMLPemesananMobil3.fxml"));
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
