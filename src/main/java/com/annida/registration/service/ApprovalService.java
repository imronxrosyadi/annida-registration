package com.annida.registration.service;

import com.annida.registration.model.Approval;

import java.util.List;
import java.util.Optional;

public interface ApprovalService {

    List<Approval> findAll() throws Exception;

    Optional<Approval> findById(String id) throws Exception;

    Approval save(Approval approval) throws Exception;

    void deleteById(String id) throws Exception;

}
