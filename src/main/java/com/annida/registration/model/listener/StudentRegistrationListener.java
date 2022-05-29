package com.annida.registration.model.listener;

import com.annida.registration.model.SchoolYear;
import com.annida.registration.model.StudentRegistration;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class StudentRegistrationListener {

    @PrePersist
    void onPrePersist(StudentRegistration studentRegistration) {
        if (studentRegistration.getId() == null)
            studentRegistration.setId(UUID.randomUUID().toString());

        if (studentRegistration.getCreatedDate() == null)
            studentRegistration.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    void onPreUpdate(StudentRegistration studentRegistration) {
    }

}
