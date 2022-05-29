package com.annida.registration.service;

import com.annida.registration.model.StudentRegistration;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface StudentRegistrationService {

    List<StudentRegistration> findAll() throws Exception;

    Optional<StudentRegistration> findById(String id) throws Exception;

    StudentRegistration save(StudentRegistration studentRegistration, MultipartFile birthCertificate, MultipartFile familyCard) throws Exception;

    void deleteById(String id) throws Exception;

}
