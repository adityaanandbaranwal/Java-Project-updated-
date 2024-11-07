package com.healthcare.minijavaproj;

public class Patient {
    private String name;
    private String medicalHistory;
    private String ongoingTreatments;
    private String allergies;
    private String emergencyContact;

    public Patient(String name, String medicalHistory, String ongoingTreatments, String allergies, String emergencyContact) {
        this.name = name;
        this.medicalHistory = medicalHistory;
        this.ongoingTreatments = ongoingTreatments;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;  // assuming 'name' is the field holding the patient's name
    }


    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getOngoingTreatments() {
        return ongoingTreatments;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }
}
