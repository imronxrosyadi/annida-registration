package com.annida.registration.controller;

import com.annida.registration.helper.ResponsePaging;
import com.annida.registration.model.Approval;
import com.annida.registration.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/monitoring")
public class ApprovalAdminController {

    @Autowired
    private ApprovalService approvalService;

    @GetMapping
    public ResponsePaging<?> getAllPendingPaging(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size,
                                          @RequestParam(value = "sortBy", defaultValue = "createdDate") String sortBy,
                                          @RequestParam(value = "prefix", defaultValue = "DESC") String prefix) {
        try {
            Page<Approval> response = approvalService.findByStatusFalse(page, size, sortBy, prefix);
            return new ResponsePaging<>(HttpStatus.OK, response.getContent(),
                    response.getTotalPages(), response.getSize(), response.getTotalElements());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponsePaging<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }
}
