package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.PremiumPayment;
import org.springframework.data.repository.ListCrudRepository;

public interface PremiumPaymentRepository extends ListCrudRepository<PremiumPayment, Long> {
}
