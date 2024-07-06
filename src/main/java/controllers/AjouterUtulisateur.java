package controllers;

import Services.UtilisateurService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import entites.Utilisateur;
import util.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class AjouterUtulisateur {

    @FXML
    private TextField txtdatenaissance;

    @FXML
    private TextField txtmail;

    @FXML
    private TextField txtmdp;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtstatut;

    @FXML
    private TextField txttel;

    @FXML
    void adduser(ActionEvent event) {
        try {
            String nom = txtnom.getText().trim();
            String prenom = txtprenom.getText().trim();
            String mdp = txtmdp.getText().trim();
            String mail = txtmail.getText().trim();
            String telStr = txttel.getText().trim();
            long tel = 0;

            if (!telStr.isEmpty()) {
                tel = Long.parseLong(telStr);
            }

            String datenaissance = txtdatenaissance.getText().trim();
            int statut = Integer.parseInt(txtstatut.getText().trim());

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNomU(nom);
            utilisateur.setPrenomU(prenom);
            utilisateur.setMdp(mdp);
            utilisateur.setMailU(mail);
            utilisateur.setTel(tel);

            java.util.Date dateNaissance = java.sql.Date.valueOf(datenaissance);
            utilisateur.setDateNaissance(dateNaissance);

            utilisateur.setStatut(statut == 1);

            // Initialize your connection here (you need to replace this with your actual connection logic)
            Connection connection = DataSource.getInstance().getConnexion();  // Replace with actual connection logic

            UtilisateurService utilisateurService = new UtilisateurService();
            utilisateurService.ajouter(connection, utilisateur);

            // Show success message
            showAlert(Alert.AlertType.INFORMATION, "Utilisateur ajouté", "L'utilisateur a été ajouté avec succès.");

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de format", "Veuillez vérifier le format des données entrées.");
            System.err.println("Invalid number format: " + e.getMessage());
            e.printStackTrace(); // Optionally show a message to the user

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur SQL", "Une erreur s'est produite lors de l'ajout de l'utilisateur.");
            System.err.println("SQL error: " + e.getMessage());
            e.printStackTrace(); // Optionally show a message to the user

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Une erreur inattendue s'est produite.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(); // Catch any other exceptions
        }
    }

    // Méthode pour afficher un message dans une boîte de dialogue
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
