package com.annida.registration.service.impl;

import com.annida.registration.model.Approval;
import com.annida.registration.model.File;
import com.annida.registration.model.StudentRegistration;
import com.annida.registration.repository.StudentRegistrationRepository;
import com.annida.registration.service.ApprovalService;
import com.annida.registration.service.FileService;
import com.annida.registration.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private FileService fileService;

    @Override
    public List<StudentRegistration> findAll() throws Exception {
        return studentRegistrationRepository.findAll();
    }

    @Override
    public Optional<StudentRegistration> findById(String id) throws Exception {
        return studentRegistrationRepository.findById(id);
    }

    @Transactional
    @Override
    public StudentRegistration save(StudentRegistration studentRegistration, MultipartFile birthCertificate, MultipartFile familyCard) throws Exception {
        File birthCert = new File(birthCertificate.getBytes(), birthCertificate.getOriginalFilename(), birthCertificate.getContentType());
        studentRegistration.setBirthCertificate(fileService.save(birthCert));

        File famCard = new File(familyCard.getBytes(), familyCard.getOriginalFilename(), familyCard.getContentType());
        studentRegistration.setFamilyCard(fileService.save(famCard));

        studentRegistration = studentRegistrationRepository.save(studentRegistration);

        Approval approval = new Approval();
        approval.setStudentRegistration(studentRegistration);
        approval.setApprovalDoc(false);
        approval.setApprovalPayment(false);
        approvalService.save(approval);

        return studentRegistration;
    }
}
