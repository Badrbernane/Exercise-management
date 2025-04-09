package esihelper.exercise_management.Controller;

import esihelper.exercise_management.DAO.UtilisateurDao;
import esihelper.exercise_management.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    private final UtilisateurDao utilisateurDao = new UtilisateurDao();

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        Utilisateur user = utilisateurDao.login(email, password);
        if (user != null) {
            errorMessage.setVisible(false);
            System.out.println("Connexion réussie pour l'utilisateur : " + user.getNom());
            // TODO: Navigate to the next screen
        } else {
            errorMessage.setText("Email ou mot de passe incorrect.");
            errorMessage.setVisible(true);
        }
    }

    @FXML
    private void handleRegister() {
        System.out.println("Redirection vers l'écran d'inscription.");
        // TODO: Implement registration screen navigation
    }
}