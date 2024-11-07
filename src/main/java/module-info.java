module com.healthcare.minijavaproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;


    opens com.healthcare.minijavaproj to javafx.fxml;
    exports com.healthcare.minijavaproj;
}

