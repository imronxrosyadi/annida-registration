package com.annida.registration.model.listener;

import com.annida.registration.model.File;
import com.annida.registration.model.SchoolYear;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class FileListener {
    @PrePersist
    void onPrePersist(File file) {
        if (file.getId() == null)
            file.setId(UUID.randomUUID().toString());

        if (file.getCreatedDate() == null)
            file.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    void onPreUpdate(File file) {
    }
}
