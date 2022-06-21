package com.annida.registration.model.dto;

import lombok.Data;

@Data
public class PendingTaskRequestDto {

    private String id;
    private String reason;
    PendingTaskRequestDto(String id,String reason){
        this.id = id;
        this.reason = reason;
    }

}
