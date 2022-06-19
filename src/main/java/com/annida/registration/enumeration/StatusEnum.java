package com.annida.registration.enumeration;

public enum StatusEnum {
    WAITING_APPROVAL_DOC(0),WAITING_APPROVAL_PAYMENT(1),APPROVED(2),REJECT(3),DELETED(4);

    private int status;
    StatusEnum(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
