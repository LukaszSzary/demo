package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity

@Data
@Table(name ="Persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private Integer pesel;
    @Transient
    @OneToMany(mappedBy ="person", cascade = CascadeType.ALL)
    private List<Car> cars;

}
