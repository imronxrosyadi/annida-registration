package com.annida.registration.model.listener;

import com.annida.registration.model.User;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserListener {
    @PrePersist
    void onPrePersist(User user) {
        if (user.getId() == null)
            user.setId(UUID.randomUUID().toString());

        if (user.getCreatedDate() == null)
            user.setCreatedDate(LocalDateTime.now());

        if (user.getUpdatedDate() == null)
            user.setUpdatedDate(LocalDateTime.now());
    }

    @PreUpdate
    void onPreUpdate(User user) {
        user.setUpdatedDate(LocalDateTime.now());
    }
}
