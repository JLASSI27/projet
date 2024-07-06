//package controllers;

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TextField;
//import org.example.Main; // Assurez-vous que Main est correctement importé
//import java.sql.Connection;
//import java.sql.SQLException;

//public class AuthentificationController {

    ///@FXML
    //private TextField txtidaute;

    //@FXML
    //private TextField txtidautmdp;

    // Méthode pour gérer l'action d'authentification
    //@FXML
   /// void Authentifier(ActionEvent event) {
        //String email = txtidaute.getText().trim();
        //String password = txtidautmdp.getText().trim();

        // Récupérer la connexion à la base de données depuis Main
        //Connection connection = Main.getConnection();

        //if (connection == null) {
           // showAlert(Alert.AlertType.ERROR, "Erreur de connexion", "Connexion à la base de données non disponible.");
            //return;
        //}

       // boolean isAuthenticated = Main.authenticateUser(connection, email, password);

        //if (isAuthenticated) {
           // showAlert(Alert.AlertType.INFORMATION, "Authentification réussie", "Bienvenue !");
            // Redirection vers la prochaine vue ou autres actions
        //} else {
          //  showAlert(Alert.AlertType.ERROR, "Authentification échouée", "Identifiants incorrects.");
        //}
    //}

    // Méthode utilitaire pour afficher une boîte de dialogue
    //private void showAlert(Alert.AlertType alertType, String title, String message) {
       // Alert alert = new Alert(alertType);
       // alert.setTitle(title);
       // alert.setHeaderText(null);
      //  alert.setContentText(message);
      //  alert.showAndWait();
   // }
//}
