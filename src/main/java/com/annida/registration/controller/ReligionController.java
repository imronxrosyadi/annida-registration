package com.annida.registration.controller;

import com.annida.registration.helper.Response;
import com.annida.registration.model.Religion;
import com.annida.registration.service.impl.ReligionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/religion")
public class ReligionController {

    @Autowired
    private ReligionServiceImpl religionService;

    @GetMapping
    public Response<List<Religion>> getAll() {
        try {
            return new Response<>(HttpStatus.OK, religionService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Response<?> getById(@PathVariable("id") String id) {
        try {
            return new Response<>(HttpStatus.OK, religionService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @PostMapping
    public Response<?> save(@RequestBody Religion religion) {
        try {
//            religion = religionService.save(religion);
            return new Response<>(HttpStatus.CREATED, religionService.save(religion));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Response<?> deleteById(@PathVariable("id") String id) {
        try {
            religionService.deleteById(id);
            System.out.println(" ====== after proccess");
            return new Response<>(HttpStatus.OK, null, "Success Delete Religion");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" ====== here is the catch");
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

}
