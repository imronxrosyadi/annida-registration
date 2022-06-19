package com.annida.registration.model.listener;

import com.annida.registration.model.SchoolYear;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class SchoolYearListener {

    @PrePersist
    void onPrePersist(SchoolYear schoolYear) {
        if (schoolYear.getId() == null) {
            schoolYear.setId(UUID.randomUUID().toString());
            schoolYear.setActive(true);
        }


        if (schoolYear.getCreatedDate() == null)
            schoolYear.setCreatedDate(LocalDateTime.now());

        if (schoolYear.getUpdatedDate() == null)
            schoolYear.setUpdatedDate(LocalDateTime.now());
    }

    @PreUpdate
    void onPreUpdate(SchoolYear schoolYear) {
    }

}
