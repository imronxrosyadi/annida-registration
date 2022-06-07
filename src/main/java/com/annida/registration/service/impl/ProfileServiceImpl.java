package com.annida.registration.service.impl;

import com.annida.registration.model.Profile;
import com.annida.registration.repository.ProfileRepository;
import com.annida.registration.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> getAll() throws Exception {
        return profileRepository.findAll();
    }

    @Override
    public void insert(Profile profile) throws Exception {
        profileRepository.save(profile);
    }

    @Override
    public void update(Profile profile, MultipartFile file) throws Exception {
        profileRepository.save(profile);
    }

    @Override
    public void deleteById(String id) throws Exception {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile getById(String id) throws Exception {
        return profileRepository.getById(id);
    }

    @Override
    public Profile getByEmail(String email) throws Exception {
        return profileRepository.getById(email);
    }
}
