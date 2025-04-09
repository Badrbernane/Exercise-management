package esihelper.exercise_management.DAO;

import esihelper.exercise_management.DbUtil.Configuration;
import esihelper.exercise_management.Model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDao {
    public boolean register(Utilisateur user) {
        String sql = "INSERT INTO utilisateur(nom, email, mot_de_passe) VALUES (?, ?, ?)";
        try (Connection conn = Configuration.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getMotDePasse()); // TODO: hasher le mot de passe !
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erreur d'enregistrement: " + e.getMessage());
            return false;
        }
    }
    public Utilisateur login(String email, String password) {
        String sql = "SELECT * FROM utilisateur WHERE email = ? AND mot_de_passe = ?";
        try (Connection conn = Configuration.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion: " + e.getMessage());
        }
        return null;
    }
}
