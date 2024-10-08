package org.horrorcore_healthcare.healthinsurance.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private HealthcareProvider provider;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    @Column(nullable = true)
    private String notes;

    public Appointment() {}

    public Appointment(UserProfile userProfile, HealthcareProvider provider, LocalDate appointmentDate, String notes) {
        this.userProfile = userProfile;
        this.provider = provider;
        this.appointmentDate = appointmentDate;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public HealthcareProvider getProvider() {
        return provider;
    }

    public void setProvider(HealthcareProvider provider) {
        this.provider = provider;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUserProfile(), that.getUserProfile()) && Objects.equals(getProvider(), that.getProvider()) && Objects.equals(getAppointmentDate(), that.getAppointmentDate()) && Objects.equals(getNotes(), that.getNotes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserProfile(), getProvider(), getAppointmentDate(), getNotes());
    }
}
