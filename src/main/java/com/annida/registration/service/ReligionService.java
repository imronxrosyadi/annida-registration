package com.annida.registration.service;

import com.annida.registration.model.Religion;

import java.util.List;
import java.util.Optional;

public interface ReligionService {

    List<Religion> findAll() throws Exception;

    Optional<Religion> findById(String id) throws Exception;

    Religion save(Religion religion) throws Exception;

    void deleteById(String id) throws Exception;

}
