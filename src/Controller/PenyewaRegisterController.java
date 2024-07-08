package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import Model.User;
import Model.UserList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PenyewaRegisterController {

    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField firstnameRegistTextField;

    @FXML
    private TextField LastnameRegistTextField;

    @FXML
    private TextField UsernameRegistTextField;

    @FXML
    private PasswordField setPasswordField;

    @FXML
    private PasswordField ConfirmPasswordField;

    @FXML
    private Button RegisterButton;

    @FXML
    private TextField EmailRegistTextField;

    @FXML
    private Button BackButton;

    @FXML
    private RadioButton pemilikMobilRole;

    @FXML
    private RadioButton penyewaRole;


    private String pilihanJenisUser = "";

    private UserList userList = new UserList();

    @FXML
    public void handleRegisterButtonAction(ActionEvent event) {
        String firstName = firstnameRegistTextField.getText();
        String lastName = LastnameRegistTextField.getText();
        String username = UsernameRegistTextField.getText();
        String email = EmailRegistTextField.getText();
        String password = setPasswordField.getText();
        String confirmPassword = ConfirmPasswordField.getText();
        // String role = pilihanJenisUser;

        userList.loadXML();

        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()
                || confirmPassword.isEmpty() || email.isEmpty()) {
            showAlert(AlertType.ERROR, "Registration Error", "Please complete all registration fields.");
        } else if (!password.equals(confirmPassword)) {
            showAlert(AlertType.ERROR, "Registration Error", "Passwords do not match.");
        } else {
            // Save the new user data to XML
            saveUserDataToXML(firstName, lastName, username, email, password, "penyewa");
            showAlert(AlertType.INFORMATION, "Registration Successful", "User registered successfully.");
            showLoginPage();
        }
    }

    // public abstract String role;

    // public abstract void showLoginPage();

    @FXML
    protected void handleRadioButton(ActionEvent event){
        if(penyewaRole.isSelected()){
            pilihanJenisUser = "penyewa";
        }else if(pemilikMobilRole.isSelected()){
            pilihanJenisUser = "pemilik mobil";
        }

    }

    private void saveUserDataToXML(String firstName, String lastName, String username, String email, String password, String role) {
         XStream xstream = new XStream(new StaxDriver());
         ArrayList <User>  data = userList.getUserLists();
         data.add(new User(firstName, lastName, username, email, password, role));

         String xml = xstream.toXML(data);

         FileOutputStream coba = null;
         try{
            coba = new FileOutputStream("user_data.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            coba.write(bytes);
         }catch (Exception e){
            System.out.println("Perhatian: " + e.getMessage());
         }finally{
            if (coba != null){
                try{
                    coba.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
         }
    }


    @FXML
    protected void handleCloseButtonAction() {
        showLoginPage();
    }

    private void showLoginPage() {
        try {
            Stage stage = (Stage) RegisterButton.getScene().getWindow();
            Scene scene = (new Scene(FXMLLoader.load(getClass().getResource("/View/FXMLLogin.fxml"))));
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
