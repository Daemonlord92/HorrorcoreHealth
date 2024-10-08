package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.UserCredential;
import org.springframework.data.repository.ListCrudRepository;

public interface UserCredentialRepository extends ListCrudRepository<UserCredential, String> {
}
