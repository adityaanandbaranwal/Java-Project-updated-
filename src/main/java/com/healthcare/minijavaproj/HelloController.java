package com.healthcare.minijavaproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private ObservableList<Doctor> availableDoctors = FXCollections.observableArrayList();
    private ObservableList<Patient> availablePatients = FXCollections.observableArrayList(); // Observable list for patients

    @FXML private TextField patientNameField, medicalHistoryField, ongoingTreatmentsField, allergiesField, emergencyContactField;
    @FXML private TextField doctorNameField, doctorSpecializationField, doctorContactField;
    @FXML private ComboBox<Doctor> doctorComboBox;
    @FXML private ComboBox<Patient> patientComboBox;  // Patient ComboBox
    @FXML private DatePicker appointmentDatePicker;
    @FXML private Button registerPatientBtn, registerDoctorBtn, bookAppointmentBtn;
    @FXML private ListView<Patient> patientListView;
    @FXML private TabPane tabPane;

    public void initialize() {
        patientListView.setItems(FXCollections.observableList(patients));
        doctorComboBox.setItems(availableDoctors);
        patientComboBox.setItems(availablePatients);  // Set the patients ComboBox
    }

    // Patient Registration
    @FXML
    private void registerPatient() {
        String name = patientNameField.getText();
        String medicalHistory = medicalHistoryField.getText();
        String ongoingTreatments = ongoingTreatmentsField.getText();
        String allergies = allergiesField.getText();
        String emergencyContact = emergencyContactField.getText();

        if (!isValidName(name)) {
            showError("Invalid Name", "Name cannot contain numbers!");
            return;
        }
        if (!isValidContact(emergencyContact)) {
            showError("Invalid Contact", "Emergency contact is invalid!");
            return;
        }

        Patient patient = new Patient(name, medicalHistory, ongoingTreatments, allergies, emergencyContact);
        patients.add(patient);
        availablePatients.add(patient);  // Add to availablePatients list for ComboBox
        patientListView.getItems().add(patient);  // Update ListView
        showConfirmation("Patient Registered", "Patient " + name + " registered successfully!");
        clearPatientFields();
    }

    // Doctor Registration
    @FXML
    private void registerDoctor() {
        String name = doctorNameField.getText();
        String specialization = doctorSpecializationField.getText();
        String contactNumber = doctorContactField.getText();

        if (!isValidName(name)) {
            showError("Invalid Name", "Name cannot contain numbers!");
            return;
        }
        if (!isValidContact(contactNumber)) {
            showError("Invalid Contact", "Contact number is invalid!");
            return;
        }
        if (isDoctorAlreadyRegistered(name)) {
            showError("Duplicate Doctor", "This doctor is already registered!");
            return;
        }

        Doctor doctor = new Doctor(name, specialization, contactNumber);
        doctors.add(doctor);
        availableDoctors.add(doctor);  // Add to availableDoctors list for ComboBox
        showConfirmation("Doctor Registered", "Doctor " + name + " registered successfully!");
        clearDoctorFields();
    }

    // Appointment Booking
    @FXML
    private void bookAppointment() {
        Patient selectedPatient = patientComboBox.getValue(); // Get selected patient from ComboBox
        Doctor selectedDoctor = doctorComboBox.getValue();
        LocalDate appointmentDate = appointmentDatePicker.getValue();

        if (selectedPatient == null || selectedDoctor == null || appointmentDate == null) {
            showError("Invalid Input", "Please select patient, doctor, and appointment date.");
            return;
        }

        Appointment appointment = new Appointment(selectedPatient, selectedDoctor, appointmentDate);  // Use constructor with 3 params
        appointments.add(appointment);
        showConfirmation("Appointment Booked", "Appointment with Dr. " + selectedDoctor.getName() + " on " + appointmentDate);
        appointmentDatePicker.setValue(null);  // Clear date picker
    }
    @FXML
    private void openAnalyticsView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("analytics-view.fxml"));
            AnchorPane analyticsPane = loader.load();

            AnalyticsController controller = loader.getController();
            controller.initializeAnalyticsData(appointments, doctors);

            Stage stage = new Stage();
            stage.setScene(new Scene(analyticsPane));
            stage.setTitle("Doctor Analytics");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Helper methods for validation and UI interaction
    private boolean isValidName(String name) {
        return name != null && !name.matches(".*\\d.*");
    }

    private boolean isValidContact(String contact) {
        return contact != null && contact.matches("\\d{10}");
    }

    private boolean isDoctorAlreadyRegistered(String name) {
        return doctors.stream().anyMatch(d -> d.getName().equalsIgnoreCase(name));
    }

    private Patient getSelectedPatient() {
        return patientComboBox.getValue(); // Get the patient from the ComboBox
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.setTitle(title);
        alert.showAndWait();
    }

    private void showConfirmation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle(title);
        alert.showAndWait();
    }

    private void clearPatientFields() {
        patientNameField.clear();
        medicalHistoryField.clear();
        ongoingTreatmentsField.clear();
        allergiesField.clear();
        emergencyContactField.clear();
    }

    private void clearDoctorFields() {
        doctorNameField.clear();
        doctorSpecializationField.clear();
        doctorContactField.clear();
    }
}
