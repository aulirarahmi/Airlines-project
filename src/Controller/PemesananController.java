package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public abstract class PemesananController {

     @FXML
    private Button BackButton;

    @FXML
    private ImageView BackToHome;

    @FXML
    private Button BookingButton;

    protected abstract String getHomeFXML();

    protected abstract String getBackFXML();

    protected abstract String getBookingFXML();

    @FXML
    private void initialize() {
        BackToHome.setOnMouseClicked(event -> navigateTo(getHomeFXML()));
        BackButton.setOnAction(event -> navigateTo(getBackFXML()));
        BookingButton.setOnAction(event -> navigateTo(getBookingFXML()));
    }

    private void navigateTo(String fxmlFile) {
        SharedModel.getInstance().setInitialPrice(800000);
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) BackToHome.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
