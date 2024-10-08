package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.Policy;
import org.springframework.data.repository.ListCrudRepository;

public interface PolicyRepository extends ListCrudRepository<Policy, String> {
}
