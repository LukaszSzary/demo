package com.example.demo.Services;

import com.example.demo.Model.Person;
import com.example.demo.Repositories.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository repo;

    public Optional<Person> getPersonById(Integer id) {
        return repo.findById(id);
    }


}
