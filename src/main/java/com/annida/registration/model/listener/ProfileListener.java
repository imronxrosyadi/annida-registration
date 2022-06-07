package com.annida.registration.model.listener;

import com.annida.registration.model.Profile;
import com.annida.registration.model.User;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProfileListener {

    @PrePersist
    void onPrePersist(Profile profile) {
        if (profile.getId() == null)
            profile.setId(UUID.randomUUID().toString());

        if (profile.getCreatedDate() == null)
            profile.setCreatedDate(LocalDateTime.now());

        if (profile.getUpdatedDate() == null)
            profile.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    void onPreUpdate(Profile profile) {
        profile.setCreatedDate(LocalDateTime.now());
    }

}
