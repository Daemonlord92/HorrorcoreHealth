package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.Plan;
import org.springframework.data.repository.ListCrudRepository;

public interface PlanRepository extends ListCrudRepository<Plan, String> {
}
