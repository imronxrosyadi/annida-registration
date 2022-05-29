package com.annida.registration.service;

import com.annida.registration.model.Approval;
import com.annida.registration.model.File;

import java.util.Optional;

public interface FileService {

    Optional<File> findById(String id) throws Exception;

    File save(File file) throws Exception;

    void deleteById(String id) throws Exception;

}
