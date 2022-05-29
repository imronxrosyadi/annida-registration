package com.annida.registration.model;

import com.annida.registration.model.listener.ApprovalListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "approval")
@EntityListeners(ApprovalListener.class)
@Data
public class Approval {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "student_registration", referencedColumnName = "id")
    private StudentRegistration studentRegistration;

    @Column(name = "approval_doc", nullable = false)
    private boolean approvalDoc;

    @Column(name = "approval_doc_date")
    private LocalDateTime approvalDocDate;

    @Column(name = "approval_payment", nullable = false)
    private boolean approvalPayment;

    @Column(name = "approval_payment_date")
    private LocalDateTime approvalPaymentDate;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
