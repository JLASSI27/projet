package Services;

import util.DataSource;
import org.example.Abonnement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class AbonnementService {
    Connection connection;

    public AbonnementService() {
        connection = DataSource.getInstance().getConnexion();
    }

    // Ajouter un abonnement
    public void ajouterS(Abonnement abonnement) throws SQLException {
        String query = "INSERT INTO abonnement (montant, dateExpiration, codePromo, typeAbonnement, idU) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setFloat(1, abonnement.getMontant());
            preparedStatement.setDate(2, new java.sql.Date(abonnement.getDateExpiration().getTime()));
            preparedStatement.setString(3, abonnement.getCodePromo());
            preparedStatement.setString(4, abonnement.getTypeAbonnement());
            preparedStatement.setInt(5, abonnement.getIdU());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                abonnement.setIdA(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating abonnement failed, no ID obtained.");
            }
        }
    }

    // Modifier un abonnement
    public void modifierS(int id, Abonnement abonnementModifie) throws SQLException {
        String query = "UPDATE abonnement SET montant = ?, dateExpiration = ?, codePromo = ?, typeAbonnement = ?, idU = ? WHERE idA = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setFloat(1, abonnementModifie.getMontant());
            preparedStatement.setDate(2, new java.sql.Date(abonnementModifie.getDateExpiration().getTime()));
            preparedStatement.setString(3, abonnementModifie.getCodePromo());
            preparedStatement.setString(4, abonnementModifie.getTypeAbonnement());
            preparedStatement.setInt(5, abonnementModifie.getIdU());
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Abonnement modifié avec succès : " + abonnementModifie.getIdA());
            } else {
                System.out.println("Aucun abonnement trouvé avec l'ID : " + id);
            }
        }
    }

    // Supprimer un abonnement
    public void supprimerS(int id) {
        String query = "DELETE FROM abonnement WHERE idA = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Abonnement supprimé avec succès, ID : " + id);
            } else {
                System.out.println("Aucun abonnement trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulter un abonnement
    public Abonnement consulter(int id) {
        String query = "SELECT * FROM abonnement WHERE idA = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Abonnement abonnement = new Abonnement();
                abonnement.setIdA(resultSet.getInt("idA"));
                abonnement.setMontant(resultSet.getFloat("montant"));
                abonnement.setDateExpiration(resultSet.getDate("dateExpiration"));
                abonnement.setCodePromo(resultSet.getString("codePromo"));
                abonnement.setTypeAbonnement(resultSet.getString("typeAbonnement"));
                abonnement.setIdU(resultSet.getInt("idU"));
                return abonnement;
            } else {
                System.out.println("Aucun abonnement trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Abonnement personnalisé
    public void abonnementPersonnalise(int id, String codePromo) throws SQLException {
        String query = "UPDATE abonnement SET codePromo = ? WHERE idA = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, codePromo);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Code promo ajouté avec succès pour l'abonnement ID : " + id);
            } else {
                System.out.println("Aucun abonnement trouvé avec l'ID : " + id);
            }
        }
    }

    // Rappel automatique
    public void rappelAutomatique() {
        String query = "SELECT * FROM abonnement WHERE dateExpiration = CURRENT_DATE";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String message = "Votre abonnement arrive à expiration aujourd'hui. Pensez à le renouveler !";
                afficherMessage(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void afficherMessage(String message) {
        // Logique pour afficher le message dans l'interface utilisateur
        System.out.println(message);
    }

    // Paiement abonnement
    public void paiementAbonnement(int id) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // Afficher un message de confirmation avec l'ID de l'abonnement
        System.out.println("Voulez-vous vraiment effectuer le paiement de l'abonnement ID " + id + " ? (Oui/Non)");

        // Lire l'entrée de l'utilisateur
        String reponse = scanner.nextLine();

        // Vérifier si l'utilisateur a confirmé le paiement
        if (reponse.equalsIgnoreCase("Oui")) {
            // Logique de paiement de l'abonnement (e.g., via une API de paiement)
            System.out.println("Paiement de l'abonnement ID " + id + " effectué avec succès !");
        } else {
            // Afficher un message si l'utilisateur a annulé le paiement
            System.out.println("Le paiement de l'abonnement ID " + id + " a été annulé.");
        }
    }
}
