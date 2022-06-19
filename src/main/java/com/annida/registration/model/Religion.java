package com.annida.registration.model;

import com.annida.registration.model.listener.ReligionListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_religion")
@EntityListeners(ReligionListener.class)
@Data
public class Religion {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_active")
    private boolean isActive;

}
