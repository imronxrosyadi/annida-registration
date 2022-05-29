package com.annida.registration.controller;

import com.annida.registration.helper.Response;
import com.annida.registration.model.SchoolYear;
import com.annida.registration.service.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school-year")
public class SchoolYearController {

    @Autowired
    private SchoolYearService schoolYearService;

    @GetMapping
    public Response<List<SchoolYear>> getAll() {
        try {
            return new Response<>(HttpStatus.OK, schoolYearService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Response<?> getById(@PathVariable("id") String id) {
        try {
            return new Response<>(HttpStatus.OK, schoolYearService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @PostMapping
    public Response<?> save(@RequestBody SchoolYear schoolYear) {
        try {
//            religion = religionService.save(religion);
            return new Response<>(HttpStatus.CREATED, schoolYearService.save(schoolYear));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Response<?> deleteById(@PathVariable("id") String id) {
        try {
            schoolYearService.deleteById(id);
            return new Response<>(HttpStatus.OK, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
