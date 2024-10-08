package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.Dependent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface DependentRepository extends ListCrudRepository<Dependent, String> {
}
