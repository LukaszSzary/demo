package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarServices CarServices;
    @GetMapping("/getAllCars")
    public List<Car> getAllCars(){
        return CarServices.getCars();
    }

    @GetMapping("/getpage/{i}")
    public List<Car> getPage(@PathVariable int i ){
        i = i>=0? i :0;
        return CarServices.getCars(i);
    }

    @GetMapping("/filter")
    public List<Car> get(){
        return CarServices.getCarsByFilters("BMW",50000);
    }
}
