package com.annida.registration.service;

import com.annida.registration.model.SchoolYear;

import java.util.List;
import java.util.Optional;

public interface SchoolYearService {

    List<SchoolYear> findAll() throws Exception;

    Optional<SchoolYear> findById(String id) throws Exception;

    SchoolYear save(SchoolYear schoolYear) throws Exception;

    void deleteById(String id) throws Exception;

}
