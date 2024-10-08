package org.horrorcore_healthcare.healthinsurance.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "policies")
public class Policy implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims = new ArrayList<>();

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<PremiumPayment> premiumPayments = new ArrayList<>();

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Dependant> dependants = new ArrayList<>();

    public Policy() {
    }

    public Policy(UserProfile userProfile, Plan plan, String policyNumber, LocalDate startDate, LocalDate endDate, List<Claim> claims, List<PremiumPayment> premiumPayments, List<Dependant> dependants) {
        this.userProfile = userProfile;
        this.plan = plan;
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.claims = claims;
        this.premiumPayments = premiumPayments;
        this.dependants = dependants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public List<PremiumPayment> getPremiumPayments() {
        return premiumPayments;
    }

    public void setPremiumPayments(List<PremiumPayment> premiumPayments) {
        this.premiumPayments = premiumPayments;
    }

    public List<Dependant> getDependants() {
        return dependants;
    }

    public void setDependants(List<Dependant> dependants) {
        this.dependants = dependants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(getId(), policy.getId()) && Objects.equals(getUserProfile(), policy.getUserProfile()) && Objects.equals(getPlan(), policy.getPlan()) && Objects.equals(getPolicyNumber(), policy.getPolicyNumber()) && Objects.equals(getStartDate(), policy.getStartDate()) && Objects.equals(getEndDate(), policy.getEndDate()) && Objects.equals(getClaims(), policy.getClaims()) && Objects.equals(getPremiumPayments(), policy.getPremiumPayments()) && Objects.equals(getDependants(), policy.getDependants());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserProfile(), getPlan(), getPolicyNumber(), getStartDate(), getEndDate(), getClaims(), getPremiumPayments(), getDependants());
    }
}
