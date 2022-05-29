package com.annida.registration.model.listener;

import com.annida.registration.model.Approval;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ApprovalListener {

    @PrePersist
    void onPrePersist(Approval approval) {
        if (approval.getId() == null)
            approval.setId(UUID.randomUUID().toString());

        if (approval.getApprovalDocDate() == null)
            approval.setApprovalDocDate(LocalDateTime.now());

        if (approval.getApprovalPaymentDate() == null)
            approval.setApprovalPaymentDate(LocalDateTime.now());

        if (approval.getCreatedDate() == null)
            approval.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    void onPreUpdate(Approval approval) {
    }
}
