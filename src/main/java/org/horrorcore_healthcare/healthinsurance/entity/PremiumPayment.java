package org.horrorcore_healthcare.healthinsurance.entity;

import jakarta.persistence.*;
import org.horrorcore_healthcare.healthinsurance.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "premium_payments")
public class PremiumPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private Policy policy;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    public PremiumPayment() {}

    public PremiumPayment(Policy policy, LocalDate paymentDate, BigDecimal amount, PaymentStatus paymentStatus) {
        this.policy = policy;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremiumPayment that = (PremiumPayment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPolicy(), that.getPolicy()) && Objects.equals(getPaymentDate(), that.getPaymentDate()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getPaymentStatus(), that.getPaymentStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPolicy(), getPaymentDate(), getAmount(), getPaymentStatus());
    }
}
