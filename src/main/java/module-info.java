module esihelper.exercise_management {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens esihelper.exercise_management to javafx.fxml;
    exports esihelper.exercise_management;
}