package com.annida.registration.service.impl;

import com.annida.registration.model.Approval;
import com.annida.registration.repository.ApprovalRepository;
import com.annida.registration.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    @Override
    public List<Approval> findAll() throws Exception {
        return approvalRepository.findAll();
    }

    @Override
    public Optional<Approval> findById(String id) throws Exception {
        return approvalRepository.findById(id);
    }

    @Override
    public Optional<Approval> findByTicketNumber(String ticketNumber) throws Exception {
        Optional<Approval> entity = approvalRepository.findByTicketNumber(ticketNumber);
        entity.get().getStudentRegistration().setFamilyCard(null);
        entity.get().getStudentRegistration().setBirthCertificate(null);
        entity.get().getStudentRegistration().setProofOfPayment(null);
        return entity;
    }

    @Override
    public Approval save(Approval approval) throws Exception {
        return approvalRepository.save(approval);
    }

    @Override
    public void deleteById(String id) throws Exception {
        approvalRepository.deleteById(id);
    }
}
