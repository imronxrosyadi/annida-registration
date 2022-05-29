package com.annida.registration.model.listener;

import com.annida.registration.model.Religion;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReligionListener {

    @PrePersist
    void onPrePersist(Religion religion) {
        if (religion.getId() == null)
            religion.setId(UUID.randomUUID().toString());

        if (religion.getCreatedDate() == null)
            religion.setCreatedDate(LocalDateTime.now());

        if (religion.getUpdatedDate() == null)
            religion.setUpdatedDate(LocalDateTime.now());
    }

    @PreUpdate
    void onPreUpdate(Religion religion) {
    }

}
