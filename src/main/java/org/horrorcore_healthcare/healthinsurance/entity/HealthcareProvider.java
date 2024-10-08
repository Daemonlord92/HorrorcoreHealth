package org.horrorcore_healthcare.healthinsurance.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "healthcare_providers")
public class HealthcareProvider implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contactNumber;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    public HealthcareProvider() {}

    public HealthcareProvider(String name, String specialization, String address, String contactNumber, List<Appointment> appointments) {
        this.name = name;
        this.specialization = specialization;
        this.address = address;
        this.contactNumber = contactNumber;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthcareProvider that = (HealthcareProvider) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getSpecialization(), that.getSpecialization()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getContactNumber(), that.getContactNumber()) && Objects.equals(getAppointments(), that.getAppointments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSpecialization(), getAddress(), getContactNumber(), getAppointments());
    }
}
