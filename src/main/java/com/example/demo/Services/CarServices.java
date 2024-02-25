package com.example.demo.Services;

import com.example.demo.Model.Car;
import com.example.demo.Repositories.CarRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CarServices {
    @Autowired
    private CarRepository repo;
    @Autowired
    private EntityManager em;
    private final int PAGE_SIZE = 3;
    public List<Car> getCars(){
        return repo.findAll();
    }

    public List<Car> getCars(int page){
        return repo.findAll(PageRequest.of(page,PAGE_SIZE)).toList();
    }

    public List<Car> getCarsByFilters(String bran,Integer miles){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Car> cq = cb.createQuery(Car.class);
        Root<Car> car = cq.from(Car.class);

        Predicate brand =cb.like(car.get("brand"),"%"+bran +"%");

        Predicate mile =cb.lessThan(car.get("milomiter"), miles);
        cq.where(brand, mile);

        TypedQuery<Car> query = em.createQuery(cq);
        return query.getResultList();
    }
}
