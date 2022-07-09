package com.annida.registration.service.impl;

import com.annida.registration.model.SchoolYear;
import com.annida.registration.repository.SchoolYearRepository;
import com.annida.registration.service.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolYearServiceImpl implements SchoolYearService {

    @Autowired
    private SchoolYearRepository schoolYearRepository;

    @Override
    public List<SchoolYear> findAll() throws Exception {
        return schoolYearRepository.findAll();
    }

    @Override
    public Optional<SchoolYear> findById(String id) throws Exception {
        return schoolYearRepository.findById(id);
    }

    @Override
    public SchoolYear save(SchoolYear schoolYear) throws Exception {
        return schoolYearRepository.save(schoolYear);
    }

    @Override
    public void deleteById(String id) throws Exception {
        try {
            schoolYearRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("data used in another table");
        }
    }
}
