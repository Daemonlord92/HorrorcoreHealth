package org.horrorcore_healthcare.healthinsurance.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "plans")
public class Plan {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal premiumAmount;

    @Column(nullable = false)
    private String coverageDetails;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<Policy> policies;

    public Plan() {}

    public Plan(String id, String name, BigDecimal premiumAmount, String coverageDetails) {
        this.id = id;
        this.name = name;
        this.premiumAmount = premiumAmount;
        this.coverageDetails = coverageDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(getId(), plan.getId()) && Objects.equals(getName(), plan.getName()) && Objects.equals(getPremiumAmount(), plan.getPremiumAmount()) && Objects.equals(getCoverageDetails(), plan.getCoverageDetails()) && Objects.equals(getPolicies(), plan.getPolicies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPremiumAmount(), getCoverageDetails(), getPolicies());
    }
}
