package com.healthcare.minijavaproj;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Analytics {

    private List<Appointment> appointments;
    private List<Doctor> doctors;

    public Analytics(List<Appointment> appointments, List<Doctor> doctors) {
        this.appointments = appointments;
        this.doctors = doctors;
    }

    /**
     * Returns a summary of the number of appointments per doctor.
     */
    public Map<String, Integer> getDoctorAppointmentsSummary() {
        Map<String, Integer> doctorAppointments = new HashMap<>();

        // Loop through each appointment and count the number of appointments per doctor
        for (Appointment appointment : appointments) {
            Doctor doctor = appointment.getDoctor();
            String doctorName = doctor.getName();

            // If the doctor is already in the map, increment the count
            doctorAppointments.put(doctorName, doctorAppointments.getOrDefault(doctorName, 0) + 1);
        }

        return doctorAppointments;
    }

    /**
     * Returns a summary of the total number of appointments.
     */
    public int getTotalAppointments() {
        return appointments.size();
    }

    /**
     * Returns a summary of the total number of doctors.
     */
    public int getTotalDoctors() {
        return doctors.size();
    }

    /**
     * Returns a summary of appointments for each doctor, formatted for display.
     */
    public String getDoctorPerformanceSummary() {
        Map<String, Integer> doctorAppointments = getDoctorAppointmentsSummary();
        StringBuilder performanceSummary = new StringBuilder();

        for (Map.Entry<String, Integer> entry : doctorAppointments.entrySet()) {
            performanceSummary.append(entry.getKey()).append(": ").append(entry.getValue()).append(" appointments\n");
        }

        return performanceSummary.toString();
    }

    /**
     * Returns a summary of the patient inflow, which is the total number of appointments.
     */
    public String getPatientInflowSummary() {
        return "Total Appointments: " + getTotalAppointments();
    }
}
