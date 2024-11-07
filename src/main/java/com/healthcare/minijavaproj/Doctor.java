package com.healthcare.minijavaproj;

public class Doctor {
    private String name;
    private String specialization;
    private String contactNumber;

    public Doctor(String name, String specialization, String contactNumber) {
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;  // assuming 'name' is the field holding the doctor's name
    }


    public String getSpecialization() {
        return specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
