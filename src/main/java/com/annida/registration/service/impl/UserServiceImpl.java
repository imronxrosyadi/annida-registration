package com.annida.registration.service.impl;

import com.annida.registration.model.Profile;
import com.annida.registration.model.User;
import com.annida.registration.model.dto.RegisterUserDto;
import com.annida.registration.repository.UserRepository;
import com.annida.registration.service.ProfileService;
import com.annida.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ProfileService profileService;

    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void insert(RegisterUserDto user) throws Exception {
        User userModel = new User();
        userModel.setUsername(user.getUsername());
        userModel.setPassword(passwordEncoder.encode(user.getPassword()));

        User createdUser = userRepository.save(userModel);

        Profile profile = new Profile();
        profile.setName(user.getName());
        profile.setEmail(user.getEmail());
        profile.setUser(createdUser);
        profileService.insert(profile);
    }

    @Override
    public void deleteById(String id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(String id) throws Exception {
        return userRepository.getById(id);
    }

    @Override
    public User getByUsername(String username) throws Exception {
        return userRepository.getByUsername(username);
    }

    @Override
    public User changePassword(User user) throws Exception {
        return null;
    }
}
