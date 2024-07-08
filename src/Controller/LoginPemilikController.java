package Controller;


import java.io.IOException;

import Model.UserList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class LoginPemilikController {

    @FXML
    private ImageView logoImageView;

    @FXML
    public TextField UsernameLoginTextField;

    @FXML
    public PasswordField getPasswordField;

    @FXML
    private TextField emailPemilikLoginTextField;

     @FXML
    private Button MasukButton;

    @FXML
    private Hyperlink BuatAkunRegistrasiHyperlink;

    private UserList userList = new UserList();


    @FXML
    public void initialize() {
        userList.loadXML();
        BuatAkunRegistrasiHyperlink.setOnAction(event -> redirectToRegisterPage());
    }

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) {
        String username = UsernameLoginTextField.getText();
        String password = getPasswordField.getText();
        String email = emailPemilikLoginTextField.getText();


            for (int i = 0; i < userList.getUserLists().size(); i++) {
                if(username.equals(userList.getUserLists().get(i).getUsername()) && password.equals(userList.getUserLists().get(i).
                getPassword()) && email.equals(userList.getUserLists().get(i).getEmail())) {
                    showAlert(AlertType.INFORMATION, "Login Success", "Welcome " + username );
                    redirectToDashboardPage();
                    return;
                }
            }

            showAlert(AlertType.ERROR, "Login Failed", "Username and password not registered.");
            redirectToRegisterPage();
    }


    public void redirectToDashboardPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/dashboardPemilik.fxml"));
            Stage stage = (Stage) MasukButton.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void redirectToRegisterPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/FXMLRegister.fxml"));
            Stage stage = (Stage) BuatAkunRegistrasiHyperlink.getScene().getWindow();
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
