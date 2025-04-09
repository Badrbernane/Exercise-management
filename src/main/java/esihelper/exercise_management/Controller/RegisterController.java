package esihelper.exercise_management.Controller;

import esihelper.exercise_management.DAO.UtilisateurDao;
import esihelper.exercise_management.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    private final UtilisateurDao utilisateurDao = new UtilisateurDao();

    @FXML
    private void handleRegister() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            errorMessage.setText("Tous les champs sont obligatoires.");
            errorMessage.setVisible(true);
            return;
        }

        boolean success = utilisateurDao.register(new Utilisateur(name, email, password));
        if (success) {
            errorMessage.setVisible(false);
            System.out.println("Inscription réussie !");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/esihelper/exercise_management/login-view.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) nameField.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            errorMessage.setText("Erreur lors de l'inscription.");
            errorMessage.setVisible(true);
        }
    }
}