package com.healthcare.minijavaproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsController {

    @FXML private BarChart<String, Number> doctorAnalyticsChart;
    @FXML private CategoryAxis xAxis;
    @FXML private NumberAxis yAxis;

    public void initializeAnalyticsData(List<Appointment> appointments, List<Doctor> doctors) {
        // Create a map to hold the count of patients per doctor
        Map<Doctor, Integer> doctorPatientCount = new HashMap<>();

        // Initialize the doctor count map
        for (Doctor doctor : doctors) {
            doctorPatientCount.put(doctor, 0);
        }

        // Count the number of patients for each doctor
        for (Appointment appointment : appointments) {
            Doctor doctor = appointment.getDoctor();
            if (doctorPatientCount.containsKey(doctor)) {
                doctorPatientCount.put(doctor, doctorPatientCount.get(doctor) + 1);
            }
        }

        // Prepare data for the bar chart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Number of Patients");

        for (Map.Entry<Doctor, Integer> entry : doctorPatientCount.entrySet()) {
            Doctor doctor = entry.getKey();
            Integer patientCount = entry.getValue();
            series.getData().add(new XYChart.Data<>(doctor.getName(), patientCount));
        }

        // Add the series to the chart
        doctorAnalyticsChart.getData().add(series);
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
