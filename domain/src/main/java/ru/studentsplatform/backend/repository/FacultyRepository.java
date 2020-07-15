package ru.studentsplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.studentsplatform.backend.entities.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}