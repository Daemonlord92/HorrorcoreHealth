package org.horrorcore_healthcare.healthinsurance.entity;

import jakarta.persistence.*;
import org.horrorcore_healthcare.healthinsurance.enums.ClaimStatus;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "claims")
public class Claim implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private Policy policy;

    @Column(nullable = false)
    private LocalDate claimDate;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private ClaimStatus claimStatus;

    @Column(nullable = false)
    private String reason;

    public Claim() {
    }

    public Claim(Policy policy, LocalDate claimDate, BigDecimal amount, ClaimStatus claimStatus, String reason) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.amount = amount;
        this.claimStatus = claimStatus;
        this.reason = reason;
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

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return Objects.equals(getId(), claim.getId()) && Objects.equals(getPolicy(), claim.getPolicy()) && Objects.equals(getClaimDate(), claim.getClaimDate()) && Objects.equals(getAmount(), claim.getAmount()) && getClaimStatus() == claim.getClaimStatus() && Objects.equals(getReason(), claim.getReason());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPolicy(), getClaimDate(), getAmount(), getClaimStatus(), getReason());
    }
}
