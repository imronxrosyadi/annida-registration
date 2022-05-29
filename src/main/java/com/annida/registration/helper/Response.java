package com.annida.registration.helper;

import org.springframework.http.HttpStatus;

public class Response<D> {

    private HttpStatus status;
    private Integer code;
    private D data;
    private String message;

    public Response(HttpStatus status, D dataModel) {
        this.status = status;
        this.code = status.value();
        this.data = dataModel;
    }

    public Response(HttpStatus status, D dataModel, String message) {
        this.status = status;
        this.code = status.value();
        this.data = dataModel;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

}
