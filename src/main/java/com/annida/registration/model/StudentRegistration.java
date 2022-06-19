package com.annida.registration.model;

import com.annida.registration.model.listener.StudentRegistrationListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_registration")
@EntityListeners(StudentRegistrationListener.class)
@Data
public class StudentRegistration {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "id_number", unique = true, nullable = false)
    private String idNumber;

    @Column(name = "group")
    private String group;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birth_place")
    private String birthPlace;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "child_status")
    private Integer childStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "father_education")
    private Integer fatherEducation;

    @Column(name = "father_occupation")
    private Integer fatherOccupation;

    @Column(name = "father_occupation_desc")
    private String fatherOccupationDesc;

    @Column(name = "father_address")
    private String fatherAddress;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "mother_education")
    private Integer motherEducation;

    @Column(name = "mother_occupation")
    private Integer motherOccupation;

    @Column(name = "mother_occupation_desc")
    private String motherOccupationDesc;

    @Column(name = "mother_address")
    private String motherAddress;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "mutation_in")
    private LocalDate mutationIn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "mutation_out")
    private LocalDate mutationOut;

    @Column(name = "mutation_origin")
    private String mutationOrigin;

    @Column(name = "mutation_to")
    private String mutationTo;

    @ManyToOne
    @JoinColumn(name = "school_year", referencedColumnName = "id")
    private SchoolYear schoolYear;

    @ManyToOne
    @JoinColumn(name = "religion", referencedColumnName = "id")
    private Religion religion;

    @OneToOne
    @JoinColumn(name = "birth_certificate", referencedColumnName = "id")
    private File birthCertificate;

    @OneToOne
    @JoinColumn(name = "family_card", referencedColumnName = "id")
    private File familyCard;

    @OneToOne
    @JoinColumn(name = "proof_of_payment", referencedColumnName = "id")
    private File proofOfPayment;

}
