package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SyaratDanKetentuanController {

    @FXML
    private ImageView BackToHome;

    @FXML
    private Button ClaimPromoButton;
    
    

    void initialize() {
       
    }
    
    @FXML
    private void switchToHomeScene(MouseEvent event) {
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLHome.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) BackToHome.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void claimPromo(ActionEvent event) {
        showAlert("Claim Promo", "Kode promo berhasil di claim!");
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    


}
