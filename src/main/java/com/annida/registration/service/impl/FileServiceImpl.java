package com.annida.registration.service.impl;

import com.annida.registration.model.Approval;
import com.annida.registration.model.File;
import com.annida.registration.repository.FileRepository;
import com.annida.registration.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public Optional<File> findById(String id) throws Exception {
        return fileRepository.findById(id);
    }

    @Override
    public File save(File file) throws Exception {
        return fileRepository.save(file);
    }

    @Override
    public void deleteById(String id) throws Exception {
        fileRepository.deleteById(id);
    }
}
