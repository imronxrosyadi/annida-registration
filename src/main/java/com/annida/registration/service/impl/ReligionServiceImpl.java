package com.annida.registration.service.impl;

import com.annida.registration.model.Religion;
import com.annida.registration.repository.ReligionRepository;
import com.annida.registration.service.ReligionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReligionServiceImpl implements ReligionService {

    @Autowired
    ReligionRepository religionRepositoryImpl;

    @Override
    public List<Religion> findAll() throws Exception {
        return religionRepositoryImpl.findAll();
    }

    @Override
    public Optional<Religion> findById(String id) throws Exception {
        return religionRepositoryImpl.findById(id);
    }

    @Override
    public Religion save(Religion religion) throws Exception {
        return religionRepositoryImpl.save(religion);
    }

    @Override
    public void deleteById(String id) throws Exception {
        try {
            religionRepositoryImpl.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("data used in another table");
        }
    }
}
