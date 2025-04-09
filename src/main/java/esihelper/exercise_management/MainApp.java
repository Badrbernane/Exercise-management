package esihelper.exercise_management;

import esihelper.exercise_management.DbUtil.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        try (Connection conn = Configuration.GetConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connexion à la base de données réussie !");
            } else {
                System.out.println("Connexion échouée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion : " + e.getMessage());
            e.printStackTrace(); // utile pour voir la cause exacte
        }
    }
}