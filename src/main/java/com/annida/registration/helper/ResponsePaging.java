package com.annida.registration.helper;

import org.springframework.http.HttpStatus;

public class ResponsePaging<D> {

    private HttpStatus status;
    private Integer code;
    private D data;
    private int totalPages;
    private int pageSizeData;
    private long totalData;
    private String message;

    public ResponsePaging(HttpStatus status, D dataModel, int totalPages, int pageSizeData, long totalData) {
        this.status = status;
        this.code = status.value();
        this.data = dataModel;
        this.totalPages = totalPages;
        this.pageSizeData = pageSizeData;
        this.totalData = totalData;
    }

    public ResponsePaging(HttpStatus status, D dataModel, String message) {
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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSizeData() {
        return pageSizeData;
    }

    public void setPageSizeData(int pageSizeData) {
        this.pageSizeData = pageSizeData;
    }

    public long getTotalData() {
        return totalData;
    }

    public void setTotalData(long totalData) {
        this.totalData = totalData;
    }
}
