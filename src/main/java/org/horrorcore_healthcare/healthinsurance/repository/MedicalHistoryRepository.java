package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.MedicalHistory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MedicalHistoryRepository extends PagingAndSortingRepository<MedicalHistory, Long> {
}
