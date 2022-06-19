package com.annida.registration.model;

import com.annida.registration.model.listener.SchoolYearListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_school_year")
@EntityListeners(SchoolYearListener.class)
@Data
public class SchoolYear {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_active")
    private boolean isActive;

}
