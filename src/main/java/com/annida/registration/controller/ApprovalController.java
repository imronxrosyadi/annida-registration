package com.annida.registration.controller;

import com.annida.registration.helper.Response;
import com.annida.registration.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
