package esihelper.exercise_management.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
    private static final String URL = "jdbc:postgresql://ep-small-unit-abygp0ry-pooler.eu-west-2.aws.neon.tech/plateforme_exercices?sslmode=require";
    private static final String USER = "plateforme_exercices_owner";
    private static final String PASSWORD = "npg_LCvfqOa5IF4i";

    public static Connection GetConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL non trouvé", e);
        }
    }
}