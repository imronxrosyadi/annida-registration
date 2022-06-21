package com.annida.registration.controller;

import com.annida.registration.helper.Response;
import com.annida.registration.model.StudentRegistration;
import com.annida.registration.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class StudentRegistrationController {

    @Autowired
    private StudentRegistrationService studentRegistrationService;

    @GetMapping
    public Response<List<StudentRegistration>> getAll() {
        try {
            return new Response<>(HttpStatus.OK, studentRegistrationService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Response<?> getById(@PathVariable("id") String id) {
        try {
            return new Response<>(HttpStatus.OK, studentRegistrationService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @PostMapping
    public Response<?> save(@RequestBody StudentRegistration studentRegistration) {
        try {
            return new Response<>(HttpStatus.CREATED, studentRegistrationService.save(studentRegistration));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @PutMapping
    public Response<?> edit(@RequestBody StudentRegistration studentRegistration) {
        try {
            return new Response<>(HttpStatus.CREATED, studentRegistrationService.save(studentRegistration));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

}
