package com.annida.registration.enumeration;

public enum StatusEnum {
    WAITING_APPROVAL_DOC(0),WAITING_APPROVAL_PAYMENT(1),APPROVED(2),REJECT(3),PENDING(4),
    FAILED(5),INVALID_DATA(6),DOCUMENT_DATA_HAS_BEEN_UPDATED(7),PAYMENT_DATA_HAS_BEEN_UPDATED(8);

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
