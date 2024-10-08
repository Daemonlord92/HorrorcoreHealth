package org.horrorcore_healthcare.healthinsurance.entity;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "medical_history")
public class MedicalHistory implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfile userProfile;

    @Column(nullable = false)
    private LocalDate treatmentDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String doctorNotes;

    public MedicalHistory() {}

    public MedicalHistory(UserProfile userProfile, LocalDate treatmentDate, String description, String doctorNotes) {
        this.userProfile = userProfile;
        this.treatmentDate = treatmentDate;
        this.description = description;
        this.doctorNotes = doctorNotes;
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

    public LocalDate getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDate treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalHistory that = (MedicalHistory) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUserProfile(), that.getUserProfile()) && Objects.equals(getTreatmentDate(), that.getTreatmentDate()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDoctorNotes(), that.getDoctorNotes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserProfile(), getTreatmentDate(), getDescription(), getDoctorNotes());
    }
}
