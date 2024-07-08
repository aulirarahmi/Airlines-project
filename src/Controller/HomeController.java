package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private ImageView LogOut;

    @FXML
    private Button fiturMobilButton;

    @FXML
    private Button fiturMotorButton;

    @FXML
    private ImageView imagePromo1;

    @FXML
    private ImageView imagePromo2;

    @FXML
    private ImageView imagePromo3;

    @FXML
    private ImageView imagePromo4;

    @FXML
    private BorderPane mainPane;

    @FXML
    void initialize() {
        // Handle LogOut  
        LogOut.setOnMouseClicked(event -> {
            switchToLoginScene();
        });

        // Handle imagePromo1 
        imagePromo1.setOnMouseClicked(event -> {
            switchToPromoScene();
        });

        // Handle imagePromo2 
        imagePromo2.setOnMouseClicked(event -> {
            switchToPromoScene();
        });

        // Handle imagePromo3
        imagePromo3.setOnMouseClicked(event -> {
            switchToPromoScene();
        });

        // Handle imagePromo4
        imagePromo4.setOnMouseClicked(event -> {
            switchToPromoScene();
        });

        // Handle fiturMobilButton 
        fiturMobilButton.setOnAction(event -> {
            switchToMobilPage();
        });

        // Handle fiturMotorButton 
        fiturMotorButton.setOnAction(event -> {
            switchToMotorPage();
        });
    }

    private void switchToMotorPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLMotorPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToMobilPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLMobilPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToPromoScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLSyaratPromo.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLLogin.fxml"));
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
