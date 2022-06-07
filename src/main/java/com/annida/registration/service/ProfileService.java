package com.annida.registration.service;

import com.annida.registration.model.Profile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProfileService {

    List<Profile> getAll() throws Exception;

    void insert(Profile profile) throws Exception;

    void update(Profile profile, MultipartFile file) throws Exception;

    void deleteById(String id) throws Exception;

    Profile getById(String id) throws Exception;

    Profile getByEmail(String email) throws Exception;

}
