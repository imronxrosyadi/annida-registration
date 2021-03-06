package com.annida.registration.repository;

import com.annida.registration.model.Approval;
import com.annida.registration.model.Profile;
import com.annida.registration.model.StudentRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, String> {
    Optional<Approval> findByTicketNumber(String ticketNumber);
    Optional<Approval> findByStudentRegistration(StudentRegistration studentRegistration);
}
