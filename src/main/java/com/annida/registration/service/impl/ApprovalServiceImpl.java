package com.annida.registration.service.impl;

import com.annida.registration.enumeration.CommonEnum;
import com.annida.registration.model.Approval;
import com.annida.registration.repository.ApprovalRepository;
import com.annida.registration.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Approval> findAllPaging(int page, int size, String sortBy, String prefix) throws Exception {
        Sort sort = Sort.by(sortBy).descending();
        if (CommonEnum.ASC.name().equals(prefix)) {
            sort = Sort.by(sortBy).ascending();
        }
        Pageable paging = PageRequest.of(page, size, sort);
        return approvalRepository.findAll(paging);
    }

    @Override
    public Page<Approval> findByStatusFalse(int page, int size, String sortBy, String prefix) throws Exception {
        Pageable paging = PageRequest.of(page, size, Sort.Direction.valueOf(prefix),sortBy);
        return approvalRepository.findByStatusFalse(paging);
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
