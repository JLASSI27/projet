package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("../AjouterUtilisateur.fxml"));
        try {
            Parent root = FXMLLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajouter Utilisateur");
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
