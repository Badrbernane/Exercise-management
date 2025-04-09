package esihelper.exercise_management;

import esihelper.exercise_management.DAO.UtilisateurDao;
import esihelper.exercise_management.Model.Utilisateur;

public class MainApp {
    public static void main(String[] args) {
        UtilisateurDao dao = new UtilisateurDao();

        // Test d'enregistrement
        Utilisateur newUser = new Utilisateur("Badr", "badr@test.com", "123456");
        boolean success = dao.register(newUser);
        System.out.println(success ? "Utilisateur enregistré" : "Échec de l'enregistrement");

        // Test de connexion
        Utilisateur loggedIn = dao.login("badr@test.com", "123456");
        if (loggedIn != null) {
            System.out.println("Connecté en tant que : " + loggedIn.getNom());
        } else {
            System.out.println("Échec de connexion");
        }
    }
}