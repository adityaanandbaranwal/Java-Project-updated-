package com.healthcare.minijavaproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Adjusted the file path to load the FXML correctly.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/healthcare/minijavaproj/hello-view.fxml"));
        TabPane root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Smart Healthcare Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
