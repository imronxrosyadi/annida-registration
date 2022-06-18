package com.annida.registration.service.impl;

import com.annida.registration.model.Approval;
import com.annida.registration.model.StudentRegistration;
import com.annida.registration.repository.StudentRegistrationRepository;
import com.annida.registration.service.ApprovalService;
import com.annida.registration.service.FileService;
import com.annida.registration.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
    public StudentRegistration save(StudentRegistration studentRegistration) throws Exception {
//        File birthCert = new File(Base64.getEncoder().encodeToString(birthCertificate.getBytes()), birthCertificate.getOriginalFilename(), birthCertificate.getContentType());
        studentRegistration.setBirthCertificate(fileService.save(studentRegistration.getBirthCertificate()));

//        File famCard = new File(Base64.getEncoder().encodeToString(familyCard.getBytes()), familyCard.getOriginalFilename(), familyCard.getContentType());
        studentRegistration.setFamilyCard(fileService.save(studentRegistration.getFamilyCard()));

        studentRegistration = studentRegistrationRepository.save(studentRegistration);

        Approval approval = new Approval();
        approval.setTicketNumber(generateTicketNumber());
        approval.setStudentRegistration(studentRegistration);
        approval.setApprovalDoc(false);
        approval.setApprovalPayment(false);
        approvalService.save(approval);

        return studentRegistration;
    }

    private String generateTicketNumber() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomString = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            int index = (int)(AlphaNumericString.length()
                    * Math.random());
            randomString.append(AlphaNumericString
                    .charAt(index));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHYYMMdd");
        StringBuilder ticketNumber = new StringBuilder()
                .append("ANN")
                .append(randomString.toString())
                .append(String.valueOf(LocalDateTime.now().format(formatter)));
        return ticketNumber.toString();
    }
}
