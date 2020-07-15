package ru.studentsplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.studentsplatform.backend.entities.model.JobAd;

public interface JobAdRepository extends JpaRepository<JobAd, Long> {
}