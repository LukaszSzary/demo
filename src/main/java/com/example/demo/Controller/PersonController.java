package com.example.demo.Controller;

import com.example.demo.Model.Person;
import com.example.demo.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices services;
    @GetMapping("/get/{id}/person")
    public Person getPersonById(@PathVariable Integer id){
        return services.getPersonById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT,"there is no such person"));
    }
}
