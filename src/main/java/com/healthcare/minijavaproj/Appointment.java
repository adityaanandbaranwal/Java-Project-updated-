package com.healthcare.minijavaproj;

import java.time.LocalDate;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDate appointmentDate;

    // Updated constructor with three parameters (no time)
    public Appointment(Patient patient, Doctor doctor, LocalDate appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    // Getter methods
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    // Setter methods if needed
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
