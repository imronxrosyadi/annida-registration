package com.annida.registration.controller;

import com.annida.registration.enumeration.CommonEnum;
import com.annida.registration.helper.Response;
import com.annida.registration.helper.ResponsePaging;
import com.annida.registration.model.Approval;
import com.annida.registration.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitoring")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @GetMapping("/registration/{ticketNumber}")
    public Response<?> getByTicketNumber(@PathVariable("ticketNumber") String ticketNumber) {
        try {
            return new Response<>(HttpStatus.OK, approvalService.findByTicketNumber(ticketNumber));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @GetMapping
    public ResponsePaging<?> getAllPaging(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size,
                                          @RequestParam(value = "sortBy", defaultValue = "createdDate") String sortBy,
                                          @RequestParam(value = "prefix", defaultValue = "DESC") String prefix) {
        try {
            Page<Approval> response = approvalService.findAllPaging(page, size, sortBy, prefix);
            return new ResponsePaging<>(HttpStatus.OK, response.getContent(),
                    response.getTotalPages(), response.getSize(), response.getTotalElements());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponsePaging<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }
}
