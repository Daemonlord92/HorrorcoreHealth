package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.Claim;
import org.springframework.data.repository.CrudRepository;

public interface ClaimRepository extends CrudRepository<Claim, String> {
}
