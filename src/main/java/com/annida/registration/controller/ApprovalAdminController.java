package com.annida.registration.controller;

import com.annida.registration.helper.Response;
import com.annida.registration.helper.ResponsePaging;
import com.annida.registration.model.Approval;
import com.annida.registration.model.dto.PendingTaskRequestDto;
import com.annida.registration.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
            Page<Approval> response = approvalService.findAllAdmin(page, size, sortBy, prefix);
            return new ResponsePaging<>(HttpStatus.OK, response.getContent(),
                    response.getTotalPages(), response.getSize(), response.getTotalElements());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponsePaging<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @GetMapping("/detail/{ticketNumber}")
    public Response<?> getByTicketNumber(@PathVariable("ticketNumber") String ticketNumber) {
        try {
            return new Response<>(HttpStatus.OK, approvalService.findByTicketNumber(ticketNumber));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @PostMapping("/approve/{id}")
    public Response<?> approve(@PathVariable("id") String id, @RequestHeader (name="Authorization") String token) {
        try {
            approvalService.approve(id, token);
            return new Response<>(HttpStatus.OK, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @PostMapping("/reject")
    public Response<?> reject(@RequestBody PendingTaskRequestDto request) {
        try {
            approvalService.reject(request);
            return new Response<>(HttpStatus.OK,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }
}
