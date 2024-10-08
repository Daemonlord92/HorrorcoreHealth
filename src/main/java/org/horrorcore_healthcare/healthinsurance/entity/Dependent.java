package org.horrorcore_healthcare.healthinsurance.entity;

import jakarta.persistence.*;
import org.horrorcore_healthcare.healthinsurance.enums.RelationStatus;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dependents")
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private Policy policy;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private RelationStatus relationStatus;

    public Dependent() {}

    public Dependent(String firstName, String lastName, LocalDate birthDate, RelationStatus relationStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.relationStatus = relationStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public RelationStatus getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(RelationStatus relationStatus) {
        this.relationStatus = relationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependent dependent = (Dependent) o;
        return Objects.equals(getId(), dependent.getId()) && Objects.equals(getPolicy(), dependent.getPolicy()) && Objects.equals(getFirstName(), dependent.getFirstName()) && Objects.equals(getLastName(), dependent.getLastName()) && Objects.equals(getBirthDate(), dependent.getBirthDate()) && getRelationStatus() == dependent.getRelationStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPolicy(), getFirstName(), getLastName(), getBirthDate(), getRelationStatus());
    }
}
