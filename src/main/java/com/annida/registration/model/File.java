package com.annida.registration.model;

import com.annida.registration.model.listener.FileListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_file")
@EntityListeners(FileListener.class)
@Data
public class File {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "file")
    private String file;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_type")
    private String type;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "is_active")
    private boolean isActive;

    public File() {}

    public File(String file, String name, String type) {
        this.file = file;
        this.type = type;
        this.name = name;
        this.isActive = true;
    }
}
