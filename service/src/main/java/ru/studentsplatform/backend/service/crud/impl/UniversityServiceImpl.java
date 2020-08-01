package ru.studentsplatform.backend.service.crud.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.studentsplatform.backend.domain.repository.UniversityRepository;
import ru.studentsplatform.backend.entities.model.university.University;
import ru.studentsplatform.backend.service.crud.UniversityService;
import ru.studentsplatform.backend.service.exception.ServiceExceptionReason;
import ru.studentsplatform.backend.system.exception.core.BusinessException;

import java.util.List;

public class UniversityServiceImpl implements UniversityService {
    private UniversityRepository universityRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University create(University newEntity) {
        return universityRepository.save(newEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public University getById(Long id) {
        return universityRepository.findById(id).orElseThrow(() ->
                new BusinessException(ServiceExceptionReason.UNIVERSITY_NOT_FOUND, id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public University update(University updatedEntity, Long id) {
        if (!universityRepository.existsById(id)) {
            throw new BusinessException(ServiceExceptionReason.USER_NOT_FOUND, id);
        }
        updatedEntity.setId(id);
        return universityRepository.saveAndFlush(updatedEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(Long id) {
        try {
            universityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Error occured: cannot delete non-existent university");
            return false;
        }
        return true;
    }
}
