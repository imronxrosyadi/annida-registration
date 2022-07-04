package com.annida.registration.model.dto;

public class SubjectTokenDto {

    private String sub;
    private long exp;

    public SubjectTokenDto() {
        
    }

    public SubjectTokenDto(String sub, long exp) {
        this.sub = sub;
        this.exp = exp;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }
}
