package com.annida.registration.service;

import com.annida.registration.model.StudentRegistration;
import com.annida.registration.model.dto.StudentRegistrationDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface StudentRegistrationService {

    List<StudentRegistration> findAll() throws Exception;

    Optional<StudentRegistration> findById(String id) throws Exception;

    StudentRegistrationDto save(StudentRegistration studentRegistration) throws Exception;

    StudentRegistrationDto edit(StudentRegistration studentRegistration) throws Exception;

}
