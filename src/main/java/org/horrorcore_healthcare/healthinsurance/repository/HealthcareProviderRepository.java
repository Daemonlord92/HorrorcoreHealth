package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.HealthcareProvider;
import org.springframework.data.repository.ListCrudRepository;

public interface HealthcareProviderRepository extends ListCrudRepository<HealthcareProvider, Long> {
}
