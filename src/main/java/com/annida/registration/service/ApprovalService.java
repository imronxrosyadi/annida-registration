package com.annida.registration.service;

import com.annida.registration.model.Approval;
import com.annida.registration.model.StudentRegistration;
import com.annida.registration.model.dto.PendingTaskRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ApprovalService {

    List<Approval> findAll() throws Exception;

    Optional<Approval> findById(String id) throws Exception;

    Optional<Approval> findByTicketNumber(String ticketNumber) throws Exception;
    Optional<Approval> findByStudentRegistration(StudentRegistration studentRegistration) throws Exception;
    Page<Approval> findAllPaging(int page, int size, String sortBy, String prefix) throws Exception;
    Page<Approval> findAllAdmin(int page, int size, String sortBy, String prefix) throws Exception;
    Approval save(Approval approval) throws Exception;

    void deleteById(String id) throws Exception;

    void approve(String id) throws Exception;
    void reject(PendingTaskRequestDto id) throws Exception;

}
