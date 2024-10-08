package org.horrorcore_healthcare.healthinsurance.repository;

import org.horrorcore_healthcare.healthinsurance.entity.Appointment;
import org.springframework.data.repository.ListCrudRepository;

public interface AppointmentRepository extends ListCrudRepository<Appointment, Long> {
}
