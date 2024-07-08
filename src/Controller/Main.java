package Controller;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;

public class Main extends Application {

    private static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        switchScene("/View/FXMLLogin.fxml");
    }

    public static void switchScene(String fxml) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource(fxml));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
